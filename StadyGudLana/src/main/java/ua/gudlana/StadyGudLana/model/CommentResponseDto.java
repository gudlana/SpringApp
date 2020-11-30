package ua.gudlana.StadyGudLana.model;

import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
public class CommentResponseDto extends CommentRequestDto {

    public String text;

    public UserDto user;

    public Date dateCreate;
}
