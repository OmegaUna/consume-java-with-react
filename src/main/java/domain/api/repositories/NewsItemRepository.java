package domain.api.repositories;

import domain.model.NewsItem;
import util.JSONParser;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NewsItemRepository {
    private List<NewsItem> newsitems = new ArrayList<NewsItem>();

    public NewsItemRepository() {
        NewsItem elke = new NewsItem("Elke is hier", "Elke", "Ja dat klopt.", LocalDate.now().format(DateTimeFormatter.ofPattern("Y-M-d")));
        NewsItem johan = new NewsItem("Pieck is hier", "Johan", "Ja dat klopt.", LocalDate.now().format(DateTimeFormatter.ofPattern("Y-M-d")));
        newsitems.add(elke);
        newsitems.add(johan);
    }

    public List<NewsItem> getAll() {
        return newsitems;
    }

    public void add (NewsItem newsitem) {
        newsitems.add(newsitem);
    }

    public NewsItem getRandomNewsItem() {
        Random random = new Random();
        int position = random.nextInt(newsitems.size());
        return newsitems.get(position);
    }
}
