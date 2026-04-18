class Shared {
    private int data;
    private boolean hasData = false;

    // 'while' handles spurious wakeups; 'notifyAll' is safer for multiple threads
    synchronized void produce(int value) {
        while (hasData) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        data = value;
        System.out.println("Produced: " + data);
        hasData = true;
        notifyAll();
    }

    synchronized void consume() {
        while (!hasData) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("Consumed: " + data);
        hasData = false;
        notifyAll();
    }
}

class Producer extends Thread {
    private final Shared s;

    Producer(Shared s) {
        this.s = s;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            s.produce(i);
            try { Thread.sleep(500); } catch (InterruptedException e) {}
        }
    }
}

class Consumer extends Thread {
    private final Shared s;

    Consumer(Shared s) {
        this.s = s;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            s.consume();
            try { Thread.sleep(1000); } catch (InterruptedException e) {}
        }
    }
}

public class ProducerConsumerProblem {
    public static void main(String[] args) {
        Shared obj = new Shared();
        Producer p = new Producer(obj);
        Consumer c = new Consumer(obj);

        p.start();
        c.start();
    }
}