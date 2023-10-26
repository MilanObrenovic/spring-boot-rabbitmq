package com.example.springbootrabbitmq.service;

import com.example.springbootrabbitmq.dto.UserDTO;

public interface RabbitMqProducerService {

    void sendMessage(String message);
    void sendJsonMessage(UserDTO userDTO);

}
