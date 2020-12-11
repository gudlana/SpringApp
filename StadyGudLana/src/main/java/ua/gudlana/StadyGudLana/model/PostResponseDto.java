package ua.gudlana.StadyGudLana.model;

import lombok.*;

import java.util.Date;
import java.util.List;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostResponseDto {

    public String id;

    public String title;

    public String tag;

    public Date dateCreate;

    public String description;

    public UserDto author;

    public List<CommentResponseDto> comments;
}
