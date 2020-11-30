package ua.gudlana.StadyGudLana.data.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

//@Document(collection = "comments")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Comment {

    @Id
    public String id;

    public String text;

    public String userId;

    public Date dateCreate;

}
