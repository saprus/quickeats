package com.KafkaSpringboot;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaListeners {

    @KafkaListener(topics = "kafkaTopic", groupId = "groupId")
    void listener(String data) {
        System.out.println("Recieved listener" + data + " :)");
    }

}
