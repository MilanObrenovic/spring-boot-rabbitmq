# Java Spring Boot + RabbitMQ

This repository demonstrates the basic usage of RabbitMQ integrated in a Java Spring Boot v3.1.5+ backend.

# 1. RabbitMQ

- RabbitMQ is a tool that helps different parts of a program to communicate with each other, even if they're not in the
	same place.
- This means that RabbitMQ makes sure that the messages get to the right place without data loss.
- It is specifically helpful when a lot of people are trying to send messages at the same time.

## 1.1. RabbitMQ Architecture

![spring-boot-rabbitmq-flow-diagram.svg](misc/spring-boot-rabbitmq-flow-diagram.svg)

- Here RabbitMQ supports multiple messaging protocols and streaming.
- This Java Spring Boot REST API example covers the following operations with RabbitMQ integration:

1. Push a single message to queue.
2. Push a json message to queue.
3. Consume a single message from queue.
4. Consume json message from queue.
