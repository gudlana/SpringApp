package ua.gudlana.StadyGudLana.data.domain;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;


@Document(collection = "role")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Role {

    @Id
    public String id;

    @Indexed(unique = true, direction = IndexDirection.DESCENDING, dropDups = true)
    public String role;

    public String description;

    public Date dtCreate;


}
