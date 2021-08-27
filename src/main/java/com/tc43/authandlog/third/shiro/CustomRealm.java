package com.tc43.authandlog.third.shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;


public class CustomRealm extends AuthorizingRealm {
    //TODO 需要完成这两个方法才能实现认证和授权

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
//        String principal = (String) principals.getPrimaryPrincipal();
//        UserService userService = (UserService) ApplicationContextUtils.getBean("userService");
//        User user = userService.queryRolesByUsername(principal);
////        System.out.println("principal: " + principal);
//        List<Role> roles = user.getRoles();//userService.queryRolesByUsername(principal);
////        System.out.println("roles: " + roles);
//        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
//        if (!CollectionUtils.isEmpty(roles)) {
//            roles.forEach(role -> {
//                simpleAuthorizationInfo.addRole(role.getName());
//            });
//            return simpleAuthorizationInfo;
//        }
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
//        String principal = (String) token.getPrincipal();

//        UserService userService = (UserService) ApplicationContextUtils.getBean("userService");
//
//        User user = userService.queryByUsername(principal);
//        if (!ObjectUtils.isEmpty(user)) {
//            SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(principal, user.getPassword(), ByteSource.Util.bytes(user.getSalt()), this.getName());
//            return simpleAuthenticationInfo;
//        }
        return null;
    }
}
