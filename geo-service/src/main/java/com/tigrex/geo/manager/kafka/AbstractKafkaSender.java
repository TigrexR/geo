package com.tigrex.geo.manager.kafka;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;

/**
 * @author linus
 */
public abstract class AbstractKafkaSender<T> {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    /**
     * send
     * @param data data
     * @param topic topic
     * @throws JsonProcessingException
     */
    abstract void send(T data, String topic) throws JsonProcessingException;

    public KafkaTemplate<String, String> getKafkaTemplate() {
        return kafkaTemplate;
    }
}
