package com.example.perfectnumber_paquit;

import javafx.fxml.FXML;
import javafx.scene.control.ProgressIndicator;

import java.util.Scanner;

public class setProgress implements Runnable{


    @FXML
    public static double progress;

    private ProgressIndicator myIndicator;

    int n;

    public setProgress(int n){

        this.n = n;
    }
    static Scanner scan = new Scanner(System.in);
    static boolean isPerfect(int n)
    {

        // 1 is not a perfect number
        if (n == 1)
            return false;

        // sum will store the sum of proper divisors
        // As 1 is a proper divisor for all numbers
        // initialised sum with 1
        int sum = 1;

        // Looping through the numbers to check if they are
        // divisors or not
        for (int i = 2; i * i <= n; i++) {

            if (n % i == 0) {

                // n is a perfect square
                // let's take 25
                // we need to add 5 only once
                // sum += i + n / i will add it twice

                if (i * i == n)
                    sum += i;
                else
                    sum += i + (n / i);
//                    System.out.println(i);
            }

            progress += 0.0001;

        }

        // If sum of divisors is equal to
        // n, then n is a perfect number

        if (sum == n){

            return true;
        }



        return false;
    }

    // Driver program
    public void running(){


        try{
            Thread.sleep(100);
        }catch(Exception e){

        }
        // Call isPerfect function to
        // check if the number is perfect or not.
        if (isPerfect(n)){
            System.out.println(n + " is a perfect number");

        } else{
            System.out.println(n + " is not a perfect number");

        }
        isPerfectThenPrint(n);

    }

    public void isPerfectThenPrint(int n){
        for(int i = 0; i < n; i++){
            if(isPerfect(i)){
                System.out.println(i);
            }
        }
    }

    @Override
    public void run(){
        running();
        if(progress >= 1){
            progress = 1;
        }
        System.out.println("This is the value of progress: " + progress);

    }
}
