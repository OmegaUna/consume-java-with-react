package ui;

import domain.model.NewsItem;
import ui.controller.RequestHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class AddNewsItem extends RequestHandler {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        getService().add(new NewsItem(request.getParameter("title"), request.getParameter("author"), request.getParameter("text"), LocalDate.now().format(DateTimeFormatter.ofPattern("Y-M-d"))));
        return "{result: true, error: false}"; // could return a response class
    }

}
