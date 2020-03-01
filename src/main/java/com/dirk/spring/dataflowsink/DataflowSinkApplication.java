package com.dirk.spring.dataflowsink;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

import java.util.List;

@SpringBootApplication
@EnableBinding(Sink.class)
public class DataflowSinkApplication {

    Logger logger = LoggerFactory.getLogger(DataflowSinkApplication.class);

    @StreamListener(Sink.INPUT)
    public void messageRecieved(List<TheData> theData) {
        theData.forEach(
                theData1 -> {
                    logger.info(
                            "Message received: id-{} name-{} price-{}",
                            theData1.getId(),
                            theData1.getName(),
                            theData1.getPrice());
                });
    }

    public static void main(String[] args) {
        SpringApplication.run(DataflowSinkApplication.class, args);
    }
}