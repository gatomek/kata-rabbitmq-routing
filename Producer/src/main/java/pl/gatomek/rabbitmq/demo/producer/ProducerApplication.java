package pl.gatomek.rabbitmq.demo.producer;

import org.springframework.amqp.core.DirectExchange;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class ProducerApplication {

    public static final String NUMBER_EXCHANGE = "number-exchange";

    public static void main(String[] args) {
        SpringApplication.run(ProducerApplication.class, args);
    }

    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange(NUMBER_EXCHANGE);
    }
}
