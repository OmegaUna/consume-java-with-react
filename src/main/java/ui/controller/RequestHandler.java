package ui.controller;

import domain.api.repositories.NewsItemRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class RequestHandler {
    protected NewsItemRepository newsitemRepository;

    public abstract String handleRequest (HttpServletRequest request, HttpServletResponse response);

    public NewsItemRepository getService() {
        return newsitemRepository;
    }

    public void setService(NewsItemRepository service) {
        this.newsitemRepository = service;
    }
}
