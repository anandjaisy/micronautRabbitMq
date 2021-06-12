package com.rabbitmq.sample;
import io.micronaut.messaging.annotation.MessageHeader;
import io.micronaut.rabbitmq.annotation.Binding;
import io.reactivex.Completable;
import io.micronaut.rabbitmq.annotation.RabbitClient;

@RabbitClient("micronaut")
public interface IProducer {
    @Binding("analytics")
    void SendMessage(@MessageHeader String messageFirst, String messageSecond);
}
