package edu.escuelaing.arep.designprimer;


import com.google.gson.Gson;
import static spark.Spark.*;

import edu.escuelaing.arep.Calculator.Calculator;

public class SparkWebApp {
    static Calculator calc;
    public static void main(String[] args) {
        calc = new Calculator();
        
        staticFiles.location("/paginas");
        Gson gson = new Gson();
        //port(getPort());
        get("/calculator", (request, response) -> {
            response.redirect("/index.html");
            response.status(200);
            return null;
        });
        


        post("/calculator/calcular/", (req, res) -> {
            //res.type("application/json");
            //res.status(201);
            
            String calculado = Calculator.Calcular(req.body());
            System.out.println(calculado);
			return gson.toJson(calculado);
            
        });
        }

        static int getPort() {
        if (System.getenv("PORT") != null) {
        return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567; //returns default port if heroku-port isn't set
        }
    
}

