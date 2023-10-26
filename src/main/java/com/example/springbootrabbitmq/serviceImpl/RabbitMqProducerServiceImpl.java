package com.example.springbootrabbitmq.serviceImpl;

import com.example.springbootrabbitmq.dto.UserDTO;
import com.example.springbootrabbitmq.service.RabbitMqProducerService;
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

    private final RabbitTemplate rabbitTemplate;

    @Override
    public void sendMessage(String message) {
        log.info(String.format("[SENT] STRING message: %s", message));
        rabbitTemplate.convertAndSend(
                exchange,
                routingKey,
                message
        );
    }

    @Override
    public void sendJsonMessage(UserDTO userDTO) {
        log.info(String.format("[SENT] JSON message: %s", userDTO.toString()));
        rabbitTemplate.convertAndSend(
                exchange,
                routingJsonKey,
                userDTO
        );
    }

}
