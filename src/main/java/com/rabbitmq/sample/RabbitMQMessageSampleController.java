package com.rabbitmq.sample;
import io.micronaut.http.annotation.*;

@Controller("/message")
public class RabbitMQMessageSampleController {
    private final IProducer iProducer;
    
    public RabbitMQMessageSampleController(IProducer iProducer){
        this.iProducer = iProducer;
    }

    @Get(uri="/")
    public void index() {
         iProducer.SendMessage("first", "second");
    }
}