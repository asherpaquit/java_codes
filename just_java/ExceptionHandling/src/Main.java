public class Main {
    public static void main(String[] args) {
       // System.out.println("Hello world!");
        try{
            int myInt = Integer.parseInt("pants");
        }
        catch(NumberFormatException nfe){
            System.out.println("You cannot make an int out of that bro...");
        }
    }
}