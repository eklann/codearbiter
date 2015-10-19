package se.eklann.codearbiter.api;

import se.eklann.codearbiter.Config;
import se.eklann.codearbiter.model.ArbiterType;
import se.eklann.codearbiter.model.EvaluationStatus;
import se.eklann.codearbiter.model.Language;
import spark.Request;
import spark.Response;
import spark.Spark;

/**
 *
 * @author eklann
 */
public class Main {
    public static void main(String[] args) {
        Config.save();
        
        Spark.post("/login", (req, res) -> Login(req, res));
        Spark.post("/logout", (req, res) -> Logout(req, res));
        
        Spark.before("/admin/*", (req, res) -> {
            if (!Boolean.parseBoolean(req.session().attribute("Admin"))) {
                Spark.halt(401);
            }
        });
        
        Spark.get("/enum/ArbiterType", (req, res) -> 
                Util.arrayToJson(Util.getNames(ArbiterType.class)));
        Spark.get("/enum/EvaluationStatus", (req, res) -> 
                Util.arrayToJson(Util.getNames(EvaluationStatus.class)));
        Spark.get("/enum/Language", (req, res) ->  
                Util.arrayToJson(Util.getNames(Language.class)));
        
        
    }
    
    private static String Login(Request req, Response res) {
        try {
            return req.body(); // TODO: Get the data from the body?
            /*
            String password = req.queryParams("password");
            if (Config.getValue("AdminPassword", "secret").equals(password))
            {
                req.session(true);
                req.session().attribute("Admin", true);
                return "ok";
            }
            return "nok";
            //*/
        } catch (Exception e) {
            return "fail";
        }
    }
    
    private static String Logout(Request req, Response res) {   
        req.session().removeAttribute("Admin");
        return "ok";
    }
}
