package com.santander.testkafka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.kafka.DefaultKafkaProducerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;

@Configuration
@Slf4j
public class KafkaConfig {

    @Bean
    public DefaultKafkaProducerFactoryCustomizer producerFactoryCustomizer() {
        return producerFactory -> producerFactory.setMaxAge(Duration.ofSeconds(7));
    }

}
