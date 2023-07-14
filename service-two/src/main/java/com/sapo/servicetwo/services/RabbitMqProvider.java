package com.sapo.servicetwo.services;

import com.sapo.servicetwo.entity.User;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class RabbitMqProvider {
    private final RabbitTemplate rabbitTemplate;

    @Autowired
    public RabbitMqProvider(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Value("${spring.rabbitmq.exchange}")
    private String exchange;

    @Value("${spring.rabbitmq.routingkey}")
    private String routingkey;

    public void send(User user){
        rabbitTemplate.convertAndSend(exchange,routingkey, user);

    }

}
