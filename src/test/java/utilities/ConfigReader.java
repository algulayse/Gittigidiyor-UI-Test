package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    static private Properties properties;

    static {
/*        try {
            File file= new File("configuration.properties");
            if (file.createNewFile()) {
                System.out.println("configuration.properties file not found and created!");
            } else {
                System.out.println("configuration.properties file already exist");
            }
        } catch (IOException e) {
            System.out.println("configuration.properties file creation error!");
            e.printStackTrace();
        }*/

        String path = "configuration.properties";
        try {
            FileInputStream fileInputStream = new FileInputStream(path);
            properties = new Properties();
            properties.load(fileInputStream);

            fileInputStream.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: configuration.properties");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("configuration.properties error");
            e.printStackTrace();
        }

    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}
