package pl.tymoteuszborkowski.going.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.tymoteuszborkowski.going.model.Event;

@Repository
public interface EventRepository extends CrudRepository<Event, Long>{

}
