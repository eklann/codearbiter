package se.eklann.codearbiter.api;

import spark.Spark;

/**
 *
 * @author eklann
 */
public class Main {
    
    public static void main(String[] args) {
        Spark.get("/hello", (req, res) -> "Hello World");
    }
}
