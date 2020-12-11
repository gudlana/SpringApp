package ua.gudlana.StadyGudLana.model;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RoleRequestDto {

    public String role;

    public String description;

}
