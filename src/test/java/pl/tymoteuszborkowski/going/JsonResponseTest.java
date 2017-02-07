package pl.tymoteuszborkowski.going;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pl.tymoteuszborkowski.going.controllers.EventController;
import pl.tymoteuszborkowski.going.model.Event;
import pl.tymoteuszborkowski.going.model.Photo;
import pl.tymoteuszborkowski.going.model.PhotoData;
import pl.tymoteuszborkowski.going.services.FacebookService;

import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class JsonResponseTest {

    // events
    // 444134282584226
    // 144699732700589

    @Autowired
    private FacebookService facebookService;

    @Test
    public void infoJsonResponse(){
        Event event = facebookService.getEventById("444134282584226");

        System.out.println(event.getName());
        System.out.println(event.getDescription());
        System.out.println(event.getEnd_time());
        System.out.println(event.getStart_time());

    }

    @Test
    public void photoResponse(){
        Photo photo = facebookService.getPhotoByEventId("444134282584226");

        List<PhotoData> dataList = photo.getData();

        for(PhotoData data : dataList){
            System.out.println(data.getLink());
        }
    }





}
