package com.yaco.FileWriter.FileWriter.MQ;

import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;



@Component
public class Reciever {

    private CountDownLatch latch = new CountDownLatch(1);

    public void recieveMessage(String message) {
        System.out.println("Recieved <" + message + ">");
        this.latch.countDown();
    }

    public CountDownLatch getLatch() {
        return this.latch;
    }


}
