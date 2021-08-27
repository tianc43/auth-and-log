package com.tc43.authandlog.auxiliary;

/**
 * 在service层抛出的错误，供controller捕获，然后返还给客户端
 */
public class ServiceException extends Exception {
    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(Exception e) {
        super(e);
    }
}
