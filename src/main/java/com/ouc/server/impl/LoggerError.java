package com.ouc.server.impl;

import com.ouc.server.Observer;
import org.apache.log4j.Logger;

public class LoggerError  implements Observer {
    private static final Logger logger = Logger.getLogger(LoggerError.class);
    private String loggerName = "error";
    @Override
    public void update(String message, String name) {
        logger.error(loggerName+":"+name+"执行了"+message);
    }
}
