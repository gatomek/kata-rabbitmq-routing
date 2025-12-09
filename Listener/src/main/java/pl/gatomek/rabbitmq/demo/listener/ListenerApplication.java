package pl.gatomek.rabbitmq.demo.listener;

import org.springframework.amqp.core.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
public class ListenerApplication {

    public static final String NUMBER_EXCHANGE = "number-exchange";

    public static void main(String[] args) {
        SpringApplication.run(ListenerApplication.class, args);
    }

    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange(NUMBER_EXCHANGE);
    }

    @Bean
    public Queue anonymousQueue() {
        return new AnonymousQueue();
    }

    @Profile("odd")
    @Bean
    public Binding oddBinding(Queue queue, DirectExchange directExchange) {
        return BindingBuilder.bind(queue).to(directExchange).with("odd");
    }

    @Profile("even")
    @Bean
    public Binding evenBinding(Queue queue, DirectExchange directExchange) {
        return BindingBuilder.bind(queue).to(directExchange).with("even");
    }

    @Profile("all")
    @Bean
    public Binding oddAllBinding(Queue queue, DirectExchange directExchange) {
        return BindingBuilder.bind(queue).to(directExchange).with("odd");
    }

    @Profile("all")
    @Bean
    public Binding evenAllBinding(Queue queue, DirectExchange directExchange) {
        return BindingBuilder.bind(queue).to(directExchange).with("even");
    }
}
