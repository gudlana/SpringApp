package ua.gudlana.StadyGudLana.data.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collation = "group")
public class Group {
    @Id
    private String Id;
    private String title;

    public Group() {
    }

    public Group(String id, String title) {
        Id = id;
        this.title = title;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
