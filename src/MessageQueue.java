import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;;

public class MessageQueue {

    Queue<Message> messageList = new LinkedBlockingDeque<>();
    int size;

    public MessageQueue(int size) {
        this.size = size;
    }

    public synchronized void produce(Message msg) throws InterruptedException {
        if(messageList.size() == size) {
            wait();
        }
        messageList.add(msg);
        System.out.println("message produced: " + msg.getMessageId());
        notifyAll();
    }

    public synchronized void consume() throws InterruptedException {
        if(messageList.isEmpty()) {
            wait();
        }
        Message msg = messageList.poll();
        if(msg != null)
            System.out.println("message consumed: " + msg.getMessageId());
        notifyAll();
    }

}
