package handlers;

import spark.ModelAndView;
import spark.Request;
import spark.Response;
import utils.Utilities;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public abstract class StaticFileTemplateHandler {
    private final String templateName;
    private final int haltNumber;

    public StaticFileTemplateHandler(String templateName, int onErrorHTTPStatusCode) {
        if (templateName == null || templateName.isEmpty()) {
            throw new IllegalArgumentException("Template name cannot be empty.");
        }
        this.templateName = templateName;
        this.haltNumber = onErrorHTTPStatusCode;
    }

    public Map<String, Object> onErrorPage(String message) {
        Map<String, Object> map = new HashMap<>();
        map.put("error_msg", message);
        return map;
    }

    public ModelAndView handleTemplateFileRequest(Request request, Response response) {
        Optional<Map<String, Object>>options = createModelMap(request);
        if(options.isPresent()) {
            options.get().put("Utilities", Utilities.class);
            return new ModelAndView(options.get(), templateName);
        } else {
            return new ModelAndView(onErrorPage("Server error please try again later"), "");
        }
    }

    public Optional<Map<String,Object>> createModelMap(Request request) {
        return Optional.of(new HashMap<>());
    }
}
