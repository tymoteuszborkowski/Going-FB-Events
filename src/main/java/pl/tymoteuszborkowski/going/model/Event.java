package pl.tymoteuszborkowski.going.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
public class Event{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String name;
    @Type(type = "text")
    private String description;
    @Column(name = "price_pln")
    private int pricePLN;
    private Date start_time;
    private Date end_time;

    @ElementCollection
    @CollectionTable(name="photos_urls", joinColumns=@JoinColumn(name="event_id"))
    @Column(name = "photo_url")
    private List<String> photosLinks;

    public List<String> getPhotosLinks() {
        return photosLinks;
    }

    public void setPhotosLinks(List<String> photosLinks) {
        this.photosLinks = photosLinks;
    }

    public int getPricePLN() {
        return pricePLN;
    }

    public void setPricePLN(int pricePLN) {
        this.pricePLN = pricePLN;
    }

    public Date getStart_time() {
        return start_time;
    }

    public void setStartTime(Date startTime) {
        this.start_time = startTime;
    }

    public Date getEnd_time() {
        return end_time;
    }

    public void setEndTime(Date endTime) {
        this.end_time = endTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
