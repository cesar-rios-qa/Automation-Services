package co.com.practice.utils;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class TestDataReader {

    private static final Properties configFile;

    private TestDataReader() {
        throw new IllegalStateException("Utility class");
    }
    static {
        try {
            String path;
            path = System.getProperty("user.dir") + "/src/test/resources/serenity-data.properties";
            FileReader input = new FileReader(path);
            configFile = new Properties();
            configFile.load(input);
            input.close();
        } catch (IOException e) {
            throw new AutomationException(e.getMessage());
        }
    }


    public static String getProperty(String keyName) {
        return configFile.getProperty(keyName);
    }
}
