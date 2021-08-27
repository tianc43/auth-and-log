package com.tc43.authandlog.mapper;

import com.tc43.authandlog.entity.LogMessage;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LogMapper {
    void insert(LogMessage logMessage);
}
