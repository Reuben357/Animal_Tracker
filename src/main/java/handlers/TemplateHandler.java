package handlers;

public class TemplateHandler extends StaticFileTemplateHandler {

    public TemplateHandler(String templateName, int onErrorHTTPStatusCode) throws IllegalArgumentException {
        super(templateName, onErrorHTTPStatusCode);
    }
}
