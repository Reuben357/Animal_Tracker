package routes;


import lombok.extern.slf4j.Slf4j;
import config.Configs;
import utils.Constants;

import static spark.Spark.port;
import static spark.Spark.staticFiles;

@Slf4j
public class WebServer {
    public WebServer() {
        port(getHerokuAssignedPort());
        setStaticFilesPath();
        initializeRoutes();
    }

    static int getHerokuAssignedPort() {
        if (System.getenv("PORT") != null) {
            Constants.DEV = false;
            return Integer.parseInt(System.getenv("PORT"));
        }

        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            Constants.DEV = false;
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return Configs.PORT;
    }

    private void setStaticFilesPath() {
        if (Constants.DEV) {
            String projectDirectory = System.getProperty("user.dir");
            String staticDirectory = "/src/main/resources/public";
            // absolute path
            staticFiles.externalLocation(projectDirectory + staticDirectory);
        } else {
            staticFiles.location("/public");
        }
    }

    private void initializeRoutes() {
        StaticFileRoutes.initializeFileRoutes();
        Routes.initializeRoutes();
    }
}
