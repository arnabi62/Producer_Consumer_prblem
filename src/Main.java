//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws InterruptedException {

        MessageQueue messageQueue = new MessageQueue(5);

        Thread producer = new Thread(new Producer(messageQueue, "1"));
        Thread consumer = new Thread(new Consumer(messageQueue, "1"));

        producer.start();
        consumer.start();

        producer.join();
        consumer.join();
    }
}