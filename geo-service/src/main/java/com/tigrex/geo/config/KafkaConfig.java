package com.tigrex.geo.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;

import java.util.Optional;

/**
 * @author linus
 */
@Slf4j
@Configuration
@EnableKafka
public class KafkaConfig {

    @KafkaListener(topics = {"geo"})
    public void listen(ConsumerRecord<?, ?> record) {
        Optional.ofNullable(record.value()).ifPresent(message -> {
            log.info("【+++++++++++++++++ record = {} 】", record);
            log.info("【+++++++++++++++++ message = {}】", message);
        });
    }
}
