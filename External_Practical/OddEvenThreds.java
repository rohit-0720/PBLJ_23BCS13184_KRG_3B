public class EvenOrOdd {
    private static final Object lock = new Object();
    private static int currentNumber = 1;
    private static final int MAX_NUMBER = 15;

    public static void main(String[] args) {
        Thread oddThread = new Thread(() -> {
            while (currentNumber <= MAX_NUMBER) {
                synchronized (lock) {
                    while (currentNumber % 2 == 0) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                    if (currentNumber > MAX_NUMBER) break;
                    System.out.println("Odd: " + currentNumber);
                    currentNumber++;
                    lock.notifyAll();
                }
            }
        });

        Thread evenThread = new Thread(() -> {
            while (currentNumber <= MAX_NUMBER) {
                synchronized (lock) {
                    while (currentNumber % 2 != 0) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                    if (currentNumber > MAX_NUMBER) break;
                    System.out.println("Even: " + currentNumber);
                    currentNumber++;
                    lock.notifyAll();
                }
            }
        });

        oddThread.start();
        evenThread.start();
    }
}
