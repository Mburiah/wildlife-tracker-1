import spark.ModelAndView;
import spark.Spark;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.*;
public class App {
    public static void main(String[] args) {
        /*Project Configuration*/
        ProcessBuilder process = new ProcessBuilder();
        Integer port;
        if (process.environment().get("PORT") != null) {
            port = Integer.parseInt(process.environment().get("PORT"));
        } else {
            port = 4567;
        }

        Spark.port(port);

        staticFiles.location("/public");

        Map<String, Object> model = new HashMap<>();
        get("/", (request, response) -> new ModelAndView(model, "index.hbs"), new HandlebarsTemplateEngine());

        get("/animals", (request, response) -> new ModelAndView(model, "animals.hbs"), new HandlebarsTemplateEngine());

        get("/animal/new", (request, response) -> {
            List<Animal> animals = Animal.getAll();
            model.put("animals", animals);
            return new ModelAndView(model, "animal.hbs");
        }, new HandlebarsTemplateEngine());

        post("/animal/add", (request, response) -> {
            String animal_name = request.queryParams("animal_name");
            int animal_age = Integer.parseInt(request.queryParams("animal_age"));
            Animal newAnimal = new Animal(animal_name, animal_age);
            newAnimal.add();
            response.redirect("/");
            return null;
        });
    }
}
