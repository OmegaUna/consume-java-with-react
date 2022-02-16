package ui;

import domain.model.NewsItem;
import ui.controller.RequestHandler;
import util.JSONParser;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collections;
import java.util.List;

public class GetAllNewsItems extends RequestHandler {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        List<NewsItem> newsitems = getService().getAll();
        String yep = "";
        try {
            yep = JSONParser.parseToJson(Collections.singletonList(newsitems));
        } catch (Exception e) {
            System.out.println(e.toString());
            yep = "";
        }
        return yep;
    }
}
