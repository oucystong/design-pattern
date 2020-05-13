package com.ouc.server.impl;

import com.ouc.server.Observer;
import org.apache.log4j.Logger;

public class LoggerWarn  implements Observer {
    private static final Logger logger = Logger.getLogger(LoggerWarn.class);
    private String loggerName = "warning";

    @Override
    public void update(String message, String name) {
        logger.warn(loggerName+":"+name+"执行了"+message);
    }
}
