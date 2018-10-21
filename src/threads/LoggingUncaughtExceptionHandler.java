package threads;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class LoggingUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {

    private static final Logger logger = Logger.getLogger("Uncaught Execptions");
    private FileHandler fileHandler;
    private File logFile;

    public LoggingUncaughtExceptionHandler() {
        try {
            logFile = new File( System.getProperty("user.dir") + "/JavaStuff/src/threads/threadExceptions.log");
            fileHandler = new FileHandler(logFile.getAbsolutePath());
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
