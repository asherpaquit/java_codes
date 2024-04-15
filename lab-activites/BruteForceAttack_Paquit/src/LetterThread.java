
import javax.print.DocFlavor;

public class LetterThread implements Runnable{
    String pass;
    int len;

    char ch;

   LetterThread(String pass,int len, char ch) {
        this.pass=pass;
        this.len=len;
        this.ch=ch;
    }


    @Override
    public void run() {
        StringBuilder ender= new StringBuilder(ch);
        ender.append("gzzzz");
        boolean hasfound=true;
        int ctr=0;
        StringBuilder atk = new StringBuilder(ch);
        String s=String.valueOf(ch);
        atk.append(ch).append("a".repeat(len-1));


        while(!atk.toString().equals(pass) && ctr<Math.pow(26,len-1)-1){
            ctr++;
            int res[] = new int[len];
            int temp = ctr;
            for(int i = len-2, j=1; i>=0;i--,j++){
                res[j]=temp/(int) Math.pow(26,i);
                temp = temp%(int)Math.pow(26,i);
            }
            atk=new StringBuilder();
            atk.append(ch);
            for(int i=1;i<len;i++){
                atk.append((char)('a'+res[i]));
            }
            System.out.println(atk);
        }

        if(atk.toString().equals(pass)){
            System.out.println("Yey, Hackerman");
        }


    }

    private String toString(Character ch) {
        return "ch";
    }
}