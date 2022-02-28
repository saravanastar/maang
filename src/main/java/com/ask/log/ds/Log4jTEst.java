package com.ask.log.ds;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Log4jTEst {
    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(Log4jTEst.class);
        logger.info("print {}", args[0]);
    }
}
