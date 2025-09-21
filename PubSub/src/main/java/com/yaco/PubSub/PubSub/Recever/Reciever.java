package main.java.com.yaco.PubSub.PubSub.Recever;
import java.util.concurrent.CountDownLatch;

public class Reciever {
 

    private CountDownLatch latch = new CountDownLatch(1);

    public void recieveMessage(String message) {
        System.out.println("Message: " + message);
        this.latch.countDown();
    }

    public int getLatch() {
        return this.latch;
    }

}