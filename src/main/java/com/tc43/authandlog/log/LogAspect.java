package com.tc43.authandlog.log;

import com.tc43.authandlog.entity.LogMessage;
import com.tc43.authandlog.service.LogService;
import com.tc43.authandlog.utils.DateUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

@Aspect
@Component
public class LogAspect {
    //    切面日志配置
    private final static Logger log = LoggerFactory.getLogger(LogAspect.class);

    @Autowired
    private LogService logService;

    @Pointcut("@annotation(Log)")
    public void pointcut() {
    }

    @Around("pointcut()")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
        //获取当前时间
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        date = sdf.parse(sdf.format(date));
        //创建一个日志对象，记录日志的信息
        LogMessage logMessage = new LogMessage();
        //获取当前对象
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        //获取切入点的方法签名
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        //获取切入点的方法
        Method method = signature.getMethod();
        //获取切入点方法上的注解
        Log userAction = method.getAnnotation(Log.class);
        if (userAction != null) {
            //注解上的描述
            logMessage.setUser_action(userAction.value());
        }
        //获取操作的url路径
        String urlStr = request.getRequestURL().toString();
        //获取调用的类名
        String className = joinPoint.getTarget().getClass().getName();
        //获取调用的方法名
        String methodName = signature.getName();
        //获取参数
        Object[] args = joinPoint.getArgs();
        Arrays.stream(args).map(Object::toString);
        //TODO 参数序列化保存
        //通过session获取用户ID和用户名
        String userId;
        if (request.getSession().getAttribute("userid") == null) {
            userId = "";
        } else {
            userId = request.getSession().getAttribute("userid").toString();
        }
        String userName;
        if (request.getSession().getAttribute("username") == null) {
            userName = "";
        } else {
            userName = request.getSession().getAttribute("username").toString();
        }

        Object result = null;
        try {
            // 让代理方法执行
            result = joinPoint.proceed();
            logMessage.setOperate_result("正常");
        } catch (Exception e) {
            logMessage.setOperate_result("失败");
        }
        //将获得的信息储存在log变量中

        logMessage.setUser_id(userId);
        logMessage.setUser_name(userName);
        logMessage.setBase_path(urlStr);
        logMessage.setCreate_at(DateUtils.getStamp());
        logMessage.setBase_parameter(Arrays.toString(args));
        log.info("ID：{}, 用户名:{}, 类名:{}, 方法名：{}, 动作:{}, 参数{}, 时间:{}", userId, userName, className, methodName, userAction.value(), args, date);
        logService.insertLog(logMessage);
        return result;
    }
}
