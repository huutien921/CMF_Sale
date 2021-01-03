package com.cmf.sale.kafka;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class CFMKafkaService {
	   @Autowired
	    private KafkaTemplate<String, String> kafkaTemplate;
	   public void sendMessage(String msg) {
	        kafkaTemplate.send("test", msg);
	    }
	    @KafkaListener(topics = "test", groupId = "group-id")
	    public void listen(String message) {
	        System.out.println("Received Message in group - group-id: " + message);
	    }

}
