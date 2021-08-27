package com.tc43.authandlog.entity;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class LogMessage {
    private long id;
    private String user_id;
    private String user_name;
    private String user_action;
    private Timestamp create_at;
    private String base_path;
    private String base_parameter;
    private String operate_result;
}
