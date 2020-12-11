package ua.gudlana.StadyGudLana.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Builder
@Getter
@Setter
public class PostRequestDto {

    public String title;

    public String tag;

    public String description;

    public String authorId;
}
