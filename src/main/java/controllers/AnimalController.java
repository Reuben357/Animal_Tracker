package controllers;

import models.Animal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import spark.Request;
import utils.Age;
import utils.HealthStatus;

public class AnimalController {
    private static final Logger animalControllerLogger = LoggerFactory.getLogger(AnimalController.class);

    public Animal create(Request request) {
        String name = request.queryParams("animal-name");
        
        // handle setting health status
        String age;
        String ageFromValue= request.queryParams("animal-age");
        switch (ageFromValue) {
            case "Adult":
                age = Age.ADULT.toString();
                break;
            case "Newborn":
                age = Age.NEWBORN.toString();
                break;
            case "Young":
                age = Age.YOUNG.toString();
                break;
            default:
                age = null;
        }

        // handle setting health status
        String healthStatus;
        String healthStatusFormValue = request.queryParams("animal-health-status");
        switch (healthStatusFormValue) {
            case "Healthy":
                healthStatus = HealthStatus.HEALTHY.toString();
                break;
            case "Ill":
                healthStatus = HealthStatus.ILL.toString();
                break;
            case "Okay":
                healthStatus = HealthStatus.OKAY.toString();
                break;
            default:
                healthStatus = null;

        }
        // handle setting is endangered
        boolean isEndangered;
        String isEndangeredFormValue= request.queryParams("animal-is-endangered");
        isEndangered = "on".equals(isEndangeredFormValue);

        String sighting = request.queryParams("animal-sighting");

        return new Animal(name, age, healthStatus, isEndangered, sighting);
    }
}
