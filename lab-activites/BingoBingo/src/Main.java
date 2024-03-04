import java.util.*;
public class Main {
    public static void main(String[] args) {
        List<BingoCard>card = new ArrayList<>();
        Thread t = new Thread(new BingoGame(card));

        t.start();
    }
}
