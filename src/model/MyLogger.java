package model;

import java.io.IOException;
import java.util.logging.*;

public class MyLogger {
    private static int num =1;


    private Logger logger;
    static class CustomFormatter extends SimpleFormatter {

        public String format(LogRecord record) {
            return record.getMessage() + "\n"; // Только сообщение
        }
    }


    public MyLogger (String name) {
        try {
            String s = name + num;
            logger = Logger.getLogger(s);
            logger.setUseParentHandlers(false);
            // Файл для логов
            String projectPath = System.getProperty("user.dir"); // получаем путь к текущему проекту
            String logPath = projectPath + "/src/logs/" + s + ".log"; // формируем путь к файлу логов

            FileHandler fh = new FileHandler(logPath, false); // append mode
            logger.addHandler(fh);
            CustomFormatter formatter = new CustomFormatter();
            fh.setFormatter(formatter);
            //for(Handler h: logger.getHandlers()){
              //  h.close();
            //}
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        num+=1;
    }

    public void log(String message) {
        logger.info(message);
    }


}
