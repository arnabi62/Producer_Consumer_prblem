public class Producer implements  Runnable{
    String id;
    MessageQueue messageQueue;
    int token = 10;

    public Producer(MessageQueue messageQueue, String id){
        this.id = id;
        this.messageQueue = messageQueue;
    }

    @Override
    public void run() {
        try{
            for(int i=0; i<token; i++) {
                Message msg = new Message("id:"+i);
                messageQueue.produce(msg);
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
