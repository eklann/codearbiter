package se.eklann.codearbiter;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import se.eklann.codearbiter.api.Main;

/**
 *
 * @author eklann
 */
public class Config {
    private static final String PROPERTIES_FILE = "codearbiter.properties";
    private static final Properties properties;
    
    static {
        properties = new Properties();
        
        try {
            Reader reader = new FileReader(PROPERTIES_FILE);
            properties.load(reader);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void save() {
        try {
            Writer writer = new FileWriter(PROPERTIES_FILE);
            properties.store(writer, "Code Arbiter Config");
        } catch (IOException ex) {
            Logger.getLogger(Config.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static String getValue(String key, String defaultValue) {
        if (properties.containsKey(key)) {
            return properties.getProperty(key);
        } else {
            setValue(key, defaultValue);
            return defaultValue;
        }
    }
    
    public static String getValue(String key) {
        return properties.getProperty(key);
    }
    
    public static void setValue(String key, String value) {
        properties.setProperty(key, value);
    }
}
