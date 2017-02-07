package pl.tymoteuszborkowski.going;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pl.tymoteuszborkowski.going.model.Event;
import pl.tymoteuszborkowski.going.repositories.EventRepository;
import pl.tymoteuszborkowski.going.services.FacebookService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DatabaseTest {

    @Autowired
    private FacebookService facebookService;

    @Autowired
    private EventRepository eventRepository;

    @Test
    public void saveEventTest(){
        Event event = facebookService.getEventById("444134282584226");
        eventRepository.save(event);
    }
}
