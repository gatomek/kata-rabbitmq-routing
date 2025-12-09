package pl.gatomek.rabbitmq.demo.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Listener {

    @RabbitListener(queues = "#{anonymouseQueue.name}")
    public void receiveNumber(String value) {
        log.info("Received: {}", value);
    }
}
