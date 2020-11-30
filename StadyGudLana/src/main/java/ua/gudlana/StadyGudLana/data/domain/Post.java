package ua.gudlana.StadyGudLana.data.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Document(collection = "posts")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Post {

    @Id
    public String id;

    public String description;

    public String authorId;

    public Date dateCreate;

    public List<Comment> comments;

}
