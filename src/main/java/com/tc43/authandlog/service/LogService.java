package com.tc43.authandlog.service;

import com.tc43.authandlog.entity.LogMessage;
import com.tc43.authandlog.mapper.LogMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service("LogService")
@RequiredArgsConstructor
public class LogService {
    private final LogMapper logMapper;

    public void insertLog(LogMessage logMessage) {
        logMapper.insert(logMessage);
    }
}
