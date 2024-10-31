package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static Properties properties;

    static {
        try (FileInputStream fileInput = new FileInputStream("src/test/resources/config.properties")) {
            properties = new Properties();
            properties.load(fileInput);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load configuration properties.");
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}
