package com.solvd.laba;


import com.solvd.laba.persistence.Config;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private static final Logger LOGGER = LogManager.getLogger(Main.class);
    public static void main(String[] args) {
        LOGGER.info(Config.DRIVER.getValue());



    }
}