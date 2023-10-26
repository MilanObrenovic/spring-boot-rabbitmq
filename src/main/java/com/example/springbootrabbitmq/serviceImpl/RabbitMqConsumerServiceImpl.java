package com.example.springbootrabbitmq.serviceImpl;

import com.example.springbootrabbitmq.dto.UserDTO;
import com.example.springbootrabbitmq.service.RabbitMqConsumerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class RabbitMqConsumerServiceImpl implements RabbitMqConsumerService {

    @RabbitListener(queues = {"${rabbitmq.queue.name}"})
    @Override
    public void consumeMessage(String message) {
        log.info(String.format("[RECEIVED] STRING message: %s", message));
    }

    @RabbitListener(queues = {"${rabbitmq.queue.json.name}"})
    @Override
    public void consumeJsonMessage(UserDTO userDTO) {
        log.info(String.format("[RECEIVED] JSON message: %s", userDTO));
    }

}
