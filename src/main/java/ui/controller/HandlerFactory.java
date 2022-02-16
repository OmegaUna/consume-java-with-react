package ui.controller;

import domain.api.repositories.NewsItemRepository;

public class HandlerFactory {

    public RequestHandler getHandler(String command, NewsItemRepository service) {
        RequestHandler handler = null;
        try {
            Class handlerClass = Class.forName("ui."+command);
            Object objectHandler = handlerClass.getConstructor().newInstance();
            handler = (RequestHandler) objectHandler;
            handler.setService(service);
        } catch (Exception e) {
            throw new RuntimeException("Deze pagina bestaat niet!");
        }
        return handler;
    }
}
