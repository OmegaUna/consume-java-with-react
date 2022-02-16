package ui;

import domain.model.NewsItem;
import ui.controller.RequestHandler;
import util.JSONParser;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

public class RandomNewsItem extends RequestHandler {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        NewsItem newsitem = getService().getRandomNewsItem();
        ArrayList<Object> l = new ArrayList<>();
        l.add(newsitem);
        return JSONParser.parseToJson(l);
    }
}


