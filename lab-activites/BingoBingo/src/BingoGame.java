import java.util.*;
public class BingoGame implements Runnable{
    static Scanner sc = new Scanner(System.in);
    static Random rd = new Random();
    static boolean result[];
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
//        do{
//            int ctr;
//            int randomToBingo = rd.nextInt(75);
//            System.out.println(randomToBingo);
//            result[75] = true;
//
//        }while(!bingo);
        do{
            int randomToBingo;
            while(true){
                randomToBingo = rd.nextInt(75);

                if(randomToBingo == randomToBingo){

               }

                if(randomToBingo != 0)
                    break;
            }

            System.out.print(randomToBingo + " ");
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }while(!bingo );
    }
}
