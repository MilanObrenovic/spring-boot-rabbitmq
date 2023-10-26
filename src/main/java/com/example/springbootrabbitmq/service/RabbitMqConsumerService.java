package com.example.springbootrabbitmq.service;

import com.example.springbootrabbitmq.dto.UserDTO;

public interface RabbitMqConsumerService {

    void consumeMessage(String message);
    void consumeJsonMessage(UserDTO userDTO);

}
