public class ThreadPrintDemo2 {
    static Object lock = new Object();
    static int num = 1;

    static class Thread1 implements Runnable {
        public void run() {
            while (true) {
                synchronized (lock) {
                    while (num > 9 || num % 2 == 0) {
                        if (num > 9) return;
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    String s = String.valueOf(num).repeat(num);
                    System.out.println(s);
                    num++;
                    lock.notifyAll();
                }
            }
        }
    }

    static class Thread2 implements Runnable {
        public void run() {
            while (true) {
                synchronized (lock) {
                    while (num > 9 || num % 2 == 1) {
                        if (num > 9) return;
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    String s = String.valueOf(num).repeat(num);
                    System.out.println(s);
                    num++;
                    lock.notifyAll();
                }
            }
        }
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new Thread1());
        Thread t2 = new Thread(new Thread2());
        t1.start();
        t2.start();
    }
}