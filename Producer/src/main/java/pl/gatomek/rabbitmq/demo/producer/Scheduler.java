package pl.gatomek.rabbitmq.demo.producer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.ThreadLocalRandom;

@RequiredArgsConstructor
@Component
@Slf4j
public class Scheduler {

    private static final String EVEN = "even";
    private static final String ODD = "odd";

    private final RabbitTemplate rabbitTemplate;

    @Scheduled(cron = "*/15 * * * * *")
    void scheduledTask() {
        long val = ThreadLocalRandom.current().nextLong(1000);
        String routingKey = (val % 2 == 0) ? EVEN : ODD;
        String message = String.valueOf(val);
        log.info( "Publishing {} @ {}", message, routingKey);
        rabbitTemplate.convertAndSend(ProducerApplication.NUMBER_EXCHANGE, routingKey, message);
    }
}
