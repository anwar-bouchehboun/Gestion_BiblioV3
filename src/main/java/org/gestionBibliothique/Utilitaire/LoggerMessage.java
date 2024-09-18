package org.gestionBibliothique.Utilitaire;
import java.util.logging.Level;


import java.util.logging.Logger;

public class LoggerMessage {
    private static final Logger logger = Logger.getLogger(LoggerMessage.class.getName());

    public LoggerMessage(){


    }
    // Method to log info messages
    public static void info(String message) {
        logger.info(message);
    }

    // Method to log warning messages
    public static void warn(String message) {
        logger.warning(message);
    }


    public static void error(String message) {
        logger.log(Level.SEVERE, message);
    }




}
