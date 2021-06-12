package com.rabbitmq.sample;
import java.io.IOException;
import com.rabbitmq.client.BuiltinExchangeType;
import javax.inject.Singleton;
import com.rabbitmq.client.Channel;
import io.micronaut.rabbitmq.connect.ChannelInitializer;

@Singleton
public class ChannelPoolListener  extends ChannelInitializer{
    @Override
    public void initialize(Channel channel) throws IOException {
        channel.exchangeDeclare("micronaut", BuiltinExchangeType.DIRECT, true);
        channel.queueDeclare("analytics", true, false, false, null);
        channel.queueBind("analytics", "micronaut", "analytics");
    }
}