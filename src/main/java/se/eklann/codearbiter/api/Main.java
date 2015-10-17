package se.eklann.codearbiter.api;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import spark.Spark;

/**
 *
 * @author eklann
 */
public class Main {
    private static String PROPERTIES_FILE = "codearbiter.properties";
    
    public static void main(String[] args) {
        Properties properties = LoadProperties();
        
        Spark.get("/hello", (req, res) -> "Hello World");
    }

    private static Properties LoadProperties() {
        Properties properties = new Properties();
        
        try {
            Reader reader = new FileReader(PROPERTIES_FILE);
            properties.load(reader);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return properties;
    }
}
