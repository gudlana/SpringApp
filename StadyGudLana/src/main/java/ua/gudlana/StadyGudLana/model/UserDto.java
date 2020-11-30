package ua.gudlana.StadyGudLana.model;

import lombok.*;

import java.util.List;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    public String id;

    public String username;
}
