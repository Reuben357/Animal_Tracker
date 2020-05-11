package routes;

import controllers.AnimalController;
import database.AnimalDao;
import handlers.TemplateHandler;

import lombok.extern.slf4j.Slf4j;

import models.Animal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import utils.Age;
import utils.HealthStatus;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.*;

@Slf4j
public class Routes {
    private static final AnimalController animalController = new AnimalController();
    private static final AnimalDao animalDao = new AnimalDao();
    static final Logger routesLogger = LoggerFactory.getLogger(Routes.class.getSimpleName());

    public static void initializeRoutes(){
        get("/", new TemplateHandler("home.hbs",404)::handleTemplateFileRequest, new HandlebarsTemplateEngine());

        get("/animals/", (request, response) -> {
            List<Animal> animals = animalDao.getAllAnimals();
            Map<String, Object> map = new HashMap<>();
            map.put("animals", animals);
            return new ModelAndView(map, "animals_index.hbs");
        }, new HandlebarsTemplateEngine());

        get("/animals/new/", new TemplateHandler("animals_new.hbs", 404)::handleTemplateFileRequest, new HandlebarsTemplateEngine());

        post("/animals/", (request, response) -> {
            Animal newAnimal = animalController.create(request);
            Map<String, Object> map = new HashMap<>();
            map.put("animal", animalDao.createAnimal(newAnimal));
            return new ModelAndView(map, "animal_successfully_created.hbs");
        }, new HandlebarsTemplateEngine());

        get("/animals/:id/", (request, response) -> {
            Map<String, Object> map = new HashMap<>();
            map.put("animal", animalDao.getAnimalById(Integer.parseInt(request.params(":id"))));
            return new ModelAndView(map, "animal_show.hbs");
        }, new HandlebarsTemplateEngine());
    }
}
