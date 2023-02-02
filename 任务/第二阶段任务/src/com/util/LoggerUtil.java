package com.util;

import java.util.logging.Logger;

public class LoggerUtil {
    private static final Logger logger = Logger.getGlobal();

    public static Logger getLoggerUtil() {
        return logger;
    }
}
