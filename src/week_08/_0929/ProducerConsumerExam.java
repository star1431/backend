package week_08._0929;

class SharedResource {
    private int data;
    private boolean available = false;

    public synchronized int consume() throws InterruptedException {
        while (!available) {
            System.out.println("[consume] 대기중..");
            wait(); // 데이터가 없으면 대기
        }
        available = false;
        notify(); // 생산자에게 알림
        return data;
    }

    public synchronized void produce(int value) throws InterruptedException {
        while (available) {
            System.out.println("[produce] 대기중..");
            wait(); // 데이터가 있으면 대기
        }
        data = value;
        available = true;
        notify(); // 소비자에게 알림
    }
}
public class ProducerConsumerExam {
    public static void main(String[] args) {
        SharedResource resource = new SharedResource();

        Thread producer = new Thread(() -> {
            try {
                for (int i = 1; i <= 5; i++) {
                    System.out.println("Producing: " + i);
                    resource.produce(i);
                    Thread.sleep(500); // 생산 속도 조절
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread consumer = new Thread(() -> {
            try {
                for (int i = 1; i <= 5; i++) {
                    int value = resource.consume();
                    System.out.println("Consuming: " + value);
                    Thread.sleep(1000); // 소비 속도 조절
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        producer.start();
        consumer.start();
    }
}