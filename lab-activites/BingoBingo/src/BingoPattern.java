import java.util.*;

public abstract class BingoPattern implements Runnable{
    List<BingoChecker> checkers;

    BingoCard card;

    public BingoPattern(BingoCard card){
        this.card = card;
        checkers = new ArrayList<>();

    }

    @Override
    public void run(){

    }
}
