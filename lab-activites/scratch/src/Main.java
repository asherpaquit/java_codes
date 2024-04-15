public class Main {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new PerfectNumberGenerator());
        thread1.start();
    }
}