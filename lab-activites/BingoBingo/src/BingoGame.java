import java.util.*;
public class BingoGame implements Runnable{
    static Scanner sc = new Scanner(System.in);
    boolean result[];
    boolean bingo;
    List<BingoCard> cards;

    public BingoGame(List<BingoCard> card) {
        this.cards= card;
    }

    @Override
    public void run(){
        System.out.println("How many Players ");
        int temp = sc.nextInt();
        for(int i = 0; i < temp; i++){
            BingoCard card = new BingoCard(i + 1);
            cards.add(card);
        }

        for(BingoCard card: cards){
            System.out.println("Card #" + card.id);
            System.out.println(card);
           // System.out.println("");
        }
    }
}
