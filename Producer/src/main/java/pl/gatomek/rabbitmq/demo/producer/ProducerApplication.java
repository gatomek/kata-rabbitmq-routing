package pl.gatomek.rabbitmq.demo.producer;

import org.springframework.amqp.core.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class ProducerApplication {

    public static final String NUMBER_EXCHANGE = "number-exchange";

    @Bean
    public DirectExchange topicExchange() {
        return new DirectExchange(NUMBER_EXCHANGE);
    }

    public static void main(String[] args) {
        SpringApplication.run(ProducerApplication.class, args);
    }
}
