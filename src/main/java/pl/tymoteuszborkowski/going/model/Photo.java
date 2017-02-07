package pl.tymoteuszborkowski.going.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Photo {

    private String id;
    private List<PhotoData> data = new ArrayList<>();


    public List<String> getLinks(){
        List<String> links = new ArrayList<>();

        for(int i = 0; i < data.size(); i++){
            links.add(data.get(i).getLink());
        }

        return links;
    }

    public List<PhotoData> getData() {
        return data;
    }

    public void setData(List<PhotoData> data) {
        this.data = data;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
