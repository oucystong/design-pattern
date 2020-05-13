package com.ouc.server.impl;

import com.ouc.server.Observer;
import org.apache.log4j.Logger;

public class LoggerInfo  implements Observer {
    private static final Logger logger = Logger.getLogger(LoggerInfo.class);
    private String loggerName = "info";
    @Override
    public void update(String message, String name) {
        logger.info(loggerName+":"+name+"执行了"+message);
    }
}
