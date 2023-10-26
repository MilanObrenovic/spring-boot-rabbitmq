package com.example.springbootrabbitmq.serviceImpl;

import com.example.springbootrabbitmq.dto.UserDTO;
import com.example.springbootrabbitmq.service.RabbitMqProducerService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class RabbitMqProducerServiceImpl implements RabbitMqProducerService {

    @Value("${rabbitmq.exchange.name}")
    private String exchange;

    @Value("${rabbitmq.routing.key}")
    private String routingKey;

    @Value("${rabbitmq.routing.json.key}")
    private String routingJsonKey;

    private RabbitTemplate rabbitTemplate;

    @Override
    public void sendMessage(String message) {
        log.info(String.format("Message sent: %s", message));
        rabbitTemplate.convertAndSend(
                exchange,
                routingKey,
                message
        );
    }

    @Override
    public void sendJsonMessage(UserDTO userDTO) {
        log.info(String.format("JSON message sent: %s", userDTO.toString()));
        rabbitTemplate.convertAndSend(
                exchange,
                routingJsonKey,
                userDTO
        );
    }

}