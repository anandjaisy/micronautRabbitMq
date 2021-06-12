package com.rabbitmq.sample;

import io.micronaut.context.annotation.Primary;
import io.micronaut.context.annotation.Replaces;
import io.micronaut.rabbitmq.bind.RabbitConsumerState;
import io.micronaut.rabbitmq.exception.DefaultRabbitListenerExceptionHandler;
import io.micronaut.rabbitmq.exception.RabbitListenerException;
import io.micronaut.rabbitmq.exception.RabbitListenerExceptionHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Singleton;
import java.util.Optional;
@Singleton
@Primary
@Replaces(DefaultRabbitListenerExceptionHandler.class)
public class RabbitListenerCustomExceptionHandler implements RabbitListenerExceptionHandler {
    private static final Logger LOG = LoggerFactory.getLogger(RabbitListenerCustomExceptionHandler.class);
    @Override
    public void handle(RabbitListenerException exception) {
        if (LOG.isErrorEnabled()) {
            Optional<RabbitConsumerState> messageState = exception.getMessageState();
            if (messageState.isPresent()) {
                LOG.error("Error processing a message for RabbitMQ consumer [" + exception.getListener() + "]", exception);
            } else {
                LOG.error("RabbitMQ consumer [" + exception.getListener() + "] produced an error", exception);
            }
        }
    }
}
