package ua.gudlana.StadyGudLana.model;


import lombok.*;

import java.util.Date;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RoleResponseDto {

    public String id;

    public String role;

    public String description;

    public Date dtCreate;
}
