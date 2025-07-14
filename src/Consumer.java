public class Consumer implements Runnable{

    String id;
    MessageQueue messageQueue;
    int token = 10;

    public Consumer(MessageQueue messageQueue, String id) {
        this.id = id;
        this.messageQueue = messageQueue;
    }


    @Override
    public void run() {
        try{
            for(int i=0; i<token; i++) {
                messageQueue.consume();
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
