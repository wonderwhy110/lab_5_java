package model;

import org.json.JSONObject;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.*;
import java.time.format.DateTimeFormatter;

public class Config {
    public String username;
    public String password;
    public String userGroup;
    public boolean debugMode;
    public boolean autoTestMode;

    public void loadConfig() {
        // Путь к файлу в пакете settings
        String projectPath = System.getProperty("user.dir"); // получаем путь к текущему проекту
        String Path = projectPath + "/src/settings/" + "config.json"; // формируем путь к файлу логов


        try (FileReader reader = new FileReader(Path)) {
            StringBuilder builder = new StringBuilder();
            int ch;
            while ((ch = reader.read()) != -1) {
                builder.append((char) ch);
            }
            JSONObject jsonObject = new JSONObject(builder.toString());

            this.username = jsonObject.getString("username");
            this.password = jsonObject.getString("password");
            this.userGroup = jsonObject.getString("userGroup");
            this.debugMode = jsonObject.getBoolean("debugMode");
            this.autoTestMode = jsonObject.getBoolean("autoTestMode");
        } catch (IOException e) {
            System.err.println("Ошибка при загрузке конфигурации: " + e.getMessage());
        }
    }
    public void updateConfigFile() {
        String projectPath = System.getProperty("user.dir"); // получаем путь к текущему проекту
        String Path = projectPath + "/src/settings/" + "config.json"; // формируем путь к файлу логов

        try (FileWriter writer = new FileWriter(Path)) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("username", this.username);
            jsonObject.put("password", this.password);
            jsonObject.put("userGroup", this.userGroup);
            jsonObject.put("debugMode", this.debugMode);
            jsonObject.put("autoTestMode", this.autoTestMode);

            writer.write(jsonObject.toString(4)); // Форматированный JSON
        } catch (IOException e) {
            System.err.println("Ошибка при записи в файл конфигурации: " + e.getMessage());
        }
    }

    public void writeLog (String message){
        System.out.println(message);
        if (this.debugMode) {
            try (FileWriter writer = new FileWriter("debug.log", true
            )) {
                LocalTime time=LocalTime.now();
                writer.write(time.format(DateTimeFormatter.ofPattern("H:mm:ss")) +"\t"+ message + "\n");
            } catch (IOException e) {
                System.err.println("Ошибка при записи в лог: " + e.getMessage());
            }
        }
    }


}


