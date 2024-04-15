import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int num = scanner.nextInt();

        Thread[] fibThreads = new Thread[num];
        int[] fibNumbers = new int[num];

        fibThreads[0] = new Thread(new FibThread(1, fibNumbers));
        fibThreads[1] = new Thread(new FibThread(2, fibNumbers));
        fibThreads[0].start();
        fibThreads[1].start();

        for (int i = 2; i < num; i++) {
            fibThreads[i] = new Thread(new FibThread(i + 1, fibNumbers, fibThreads[i - 1], fibThreads[i - 2]));
            fibThreads[i].start();
        }

        fibThreads[num - 1].join();

        for (int i = 0; i < num; i++) {
            System.out.println(fibNumbers[i]);
        }
    }
}