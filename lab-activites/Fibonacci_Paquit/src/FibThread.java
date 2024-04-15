import java.util.Scanner;

class FibThread implements Runnable {
    private final int n;
    private final int[] fibResults;
    private final Thread thread1;
    private final Thread thread2;

    public FibThread(int n, int[] fibNumbers) {
        this.n = n;
        this.fibResults = fibNumbers;
        this.thread1 = null;
        this.thread2 = null;
    }

    public FibThread(int n, int[] fibNumbers, Thread thread1, Thread thread2) {
        this.n = n;
        this.fibResults = fibNumbers;
        this.thread1 = thread1;
        this.thread2 = thread2;
    }

    @Override
    public void run() {
        if (n == 1) {
            fibResults[0] = 0;
        } else if (n == 2) {
            fibResults[1] = 1;
        } else {
            try {

                thread2.join();
                thread1.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            fibResults[n - 1] = fibResults[n - 3] + fibResults[n - 2];
        }
    }
}