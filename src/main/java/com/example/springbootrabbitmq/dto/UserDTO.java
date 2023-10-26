package com.example.springbootrabbitmq.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    @JsonProperty(value = "id")
    private Long id;

    @JsonProperty(value = "last_name")
    private String firstName;

    @JsonProperty(value = "first_name")
    private String lastName;

}
