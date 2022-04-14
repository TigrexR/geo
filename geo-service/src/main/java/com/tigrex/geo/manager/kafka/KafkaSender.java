package com.tigrex.geo.manager.kafka;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.tigrex.geo.entity.kafka.Message;
import com.tigrex.geo.utils.JacksonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Repository;
import org.springframework.util.concurrent.ListenableFuture;

import java.util.Date;

/**
 * @author linus
 */
@Slf4j
@Repository
public class KafkaSender<T> extends AbstractKafkaSender<T> {

    @Override
    public void send(T data, String topic) throws JsonProcessingException {
        Message<T> message = new Message<>();
        message.setId(System.currentTimeMillis());
        message.setData(data);
        message.setDate(new Date());
        log.info("message data: {}", JacksonUtils.getJackson().writeValueAsString(message));
        ListenableFuture<SendResult<String, String>> result = getKafkaTemplate().send(topic,
                JacksonUtils.getJackson().writeValueAsString(message));
        log.info("kafka result: {}", JacksonUtils.getJackson().writeValueAsString(result));
    }
}
