packageco.edu.escuelaing.arem.designprimer;
import static spark.Spark.*;
public class SparkWebApp {
    public static void main(String[] args) {
    get("/hello", (req, res) -> "Hello Heroku");    }
    
}
}
