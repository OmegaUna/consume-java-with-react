package ui;

import domain.model.NewsItem;
import ui.controller.RequestHandler;
import util.JSONParser;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class Overview extends RequestHandler {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        List<NewsItem> newsitems = newsitemRepository.getAll();
        request.setAttribute("newsitems", newsitems);
        return "overview.jsp";
    }

}
