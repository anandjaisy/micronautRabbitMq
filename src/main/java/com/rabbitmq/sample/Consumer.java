package com.rabbitmq.sample;

import io.micronaut.messaging.annotation.MessageHeader;
import io.micronaut.rabbitmq.annotation.Queue;
import io.micronaut.rabbitmq.annotation.RabbitListener;

@RabbitListener
public class Consumer {
    @Queue("analytics")
    public void consumeMessage(@MessageHeader String messageFirst, String messageSecond) {
        System.out.println("Message received = " + messageFirst +"," + messageSecond);
    }
}
