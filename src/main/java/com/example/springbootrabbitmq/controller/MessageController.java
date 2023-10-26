package com.example.springbootrabbitmq.controller;

import com.example.springbootrabbitmq.dto.UserDTO;
import com.example.springbootrabbitmq.service.RabbitMqProducerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping(value = "/api/v1/messages")
public class MessageController {

    private RabbitMqProducerService rabbitMqProducerService;

    @GetMapping("/string")
    public ResponseEntity<String> sendMessage(
            @RequestParam("message") String message
    ) {
        rabbitMqProducerService.sendMessage(message);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body("Message sent to RabbitMQ.");
    }

    @PostMapping("/json")
    public ResponseEntity<String> sendJsonMessage(
            @RequestBody UserDTO userDTO
    ) {
        rabbitMqProducerService.sendJsonMessage(userDTO);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body("JSON message sent to RabbitMQ.");
    }

}
