package com.example.springbootrabbitmq.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDTO {

    @JsonProperty(value = "id")
    private Long id;

    @JsonProperty(value = "last_name")
    private String firstName;

    @JsonProperty(value = "first_name")
    private String lastName;

}
