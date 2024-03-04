import java.util.*;
public class BingoCard {
    int [][]card=new int [5][5];
    ArrayList<Integer> alreadyUsed = new ArrayList<Integer>();
    boolean valid = false;
    int tmp = 0;
    List<Integer> numbers;
    int id;



    public BingoCard(int id){
        this.id = id;
        makeBingo();

        }

    public void makeBingo(){


        for(int i = 0; i <= 4; i++){
            for(int row = 0; row < card.length; row++){
                while(!valid){
                    tmp = (int)(Math.random() * 15) + 1 + 15 * i;
                    if(!alreadyUsed.contains(tmp)){
                        valid = true;
                        alreadyUsed.add(tmp);
                    }
                }
                card[row][i] = tmp;
                valid = false;
            }
        }
        card[2][2] = 0;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        for(int row = 0; row < 5; row++){
            for(int col = 0; col < 5; col++){
                //sb.append(numbers.get(col*5+row)).append(" ");
                sb.append(card[row][col]).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public void printBingoCard(){
        for(int i = 0; i < card.length; i++){
            for(int j = 0; j < card[i].length; j++){
                System.out.print(card[i][j] + " ");
            }
            System.out.println(" ");
        }
    }
}
