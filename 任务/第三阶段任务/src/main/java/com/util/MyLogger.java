package com.util;

import java.util.logging.Logger;

public class MyLogger {
    private static Logger logger = Logger.getGlobal();
    public static Logger setLogger() {
        return logger;
    }
}
