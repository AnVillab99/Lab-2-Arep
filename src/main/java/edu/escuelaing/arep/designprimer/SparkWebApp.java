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
        port(getPort());
        get("/calculator", (request, response) -> {
            response.redirect("/index.html");
            response.status(200);
            return null;
        });


        post("/calculator/calcular/", (req, res) -> {
            System.out.println("sdfdsfdsfdsfsd"+req.contentLength());
            System.out.println("aaaaaaaaaaaaaad "+req.body());
            res.type("application/json");
            res.status(201);
			return Calculator.Calcular(req.body());
            
        }, gson ::toJson);
        }

        static int getPort() {
        if (System.getenv("PORT") != null) {
        return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567; //returns default port if heroku-port isn't set
        }
    
}

