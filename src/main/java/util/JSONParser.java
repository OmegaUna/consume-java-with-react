package util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import domain.model.NewsItem;

import java.util.List;

public class JSONParser {

    /*public static String parseToJson(Object obj) {
        String result = "[";
        try {
            result += mapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            result += "{error: true}";
        }
        return result + "]";
    }*/
    public static String parseToJson(List<Object> objects) {
        ObjectMapper mapper = new ObjectMapper();
        String r = "";
        for (Object obj: objects) {
            try {
                r += mapper.writeValueAsString(obj) + ",";
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }
        return r.substring(0, r.length()-1);
    }
}
