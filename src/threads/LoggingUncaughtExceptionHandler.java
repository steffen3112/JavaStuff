package threads;

import java.io.IOException;
import java.util.Date;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class LoggingUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {

    private static final Logger logger = Logger.getLogger("Uncaught Execptions");
    FileHandler fileHandler;

    public LoggingUncaughtExceptionHandler() {
        try {
            fileHandler = new FileHandler("/home/steffen/Repos/javastuff/JavaStuff/src/threads/ThreadLogFile.log");
            logger.addHandler(fileHandler);
            SimpleFormatter simpleFormatter = new SimpleFormatter();
            fileHandler.setFormatter(simpleFormatter);
            logger.info("Created Logger " + new Date().toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        logger.info("Time: " + new Date().toString() + "\n\tException: " + e.toString() + "\n\tin Thread " + t.getName());
    }
}
