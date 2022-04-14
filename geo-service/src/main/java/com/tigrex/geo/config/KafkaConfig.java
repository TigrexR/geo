package com.tigrex.geo.config;

import com.fasterxml.jackson.core.type.TypeReference;
import com.tigrex.geo.entity.bo.UserBO;
import com.tigrex.geo.entity.kafka.Message;
import com.tigrex.geo.utils.JacksonUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;

import java.io.IOException;
import java.util.Optional;

/**
 * @author linus
 */
@Slf4j
@Configuration
@EnableKafka
public class KafkaConfig {

    @KafkaListener(topics = {"geo"})
    public void listen(ConsumerRecord<?, String> record) {
        Optional.ofNullable(record.value()).ifPresent(message -> {
            try {
                Message<UserBO> value = JacksonUtils.getJackson().readValue(message, new TypeReference<Message<UserBO>>() {});
                log.info("【+++++++++++++++++ message = {}】", JacksonUtils.getJackson().writeValueAsString(value));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
