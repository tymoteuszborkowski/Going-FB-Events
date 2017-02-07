package pl.tymoteuszborkowski.going.services;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.tymoteuszborkowski.going.model.Event;
import pl.tymoteuszborkowski.going.model.Photo;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class FacebookService {

    private static final String ACCESS_TOKEN = "382713898769383|sMdjaj74wRosOsSNq5cPaDpw5X4";
    private static final String JSON_TEMPLATE = "https://graph.facebook.com/v2.8/";

    private RestTemplate restTemplate = new RestTemplate();

    public Event getEventById(String id) {

        Event event = restTemplate.getForObject(JSON_TEMPLATE + id + "?access_token=" + ACCESS_TOKEN, Event.class);
        List<String> links = getPhotoByEventId(id).getLinks();

        event.setPhotosLinks(links);
        event.setPricePLN(grabPrice(event.getDescription()));

        return event;
    }


    public Photo getPhotoByEventId(String id) {
        return restTemplate.getForObject(JSON_TEMPLATE + id + "/photos?fields=link&access_token=" + ACCESS_TOKEN, Photo.class);
    }

    private int grabPrice(String description) {
        String lowerDesc = description.toLowerCase();
        int indexFrom;
        int indexTo = -1;
        int price = -1;

        if (lowerDesc.contains("pln")) {
            indexTo = lowerDesc.indexOf("pln") + 2;
        } else if (lowerDesc.contains("zł")) {
            indexTo = lowerDesc.indexOf("zł") + 2;
        } else if (lowerDesc.contains("zl")) {
            indexTo = lowerDesc.indexOf("zl") + 2;
        }

        if (indexTo != -1) {
            indexFrom = indexTo - 5;
            String substring = lowerDesc.substring(indexFrom, indexTo);

            Pattern p = Pattern.compile("\\d+");
            Matcher m = p.matcher(substring);

            if (m.find()) {
                String group = m.group();
                price = Integer.parseInt(group);
            }
        }
        return price;
    }


}

