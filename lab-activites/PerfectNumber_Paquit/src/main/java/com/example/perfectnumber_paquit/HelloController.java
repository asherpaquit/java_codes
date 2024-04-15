package com.example.perfectnumber_paquit;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TextField;

public class HelloController{


    @FXML
    private Button myButton;
    @FXML
    private ProgressIndicator myIndicator;

    @FXML
    private TextField getThread;
    @FXML
    private TextField getInput;

    double progress = 0;
    @FXML
    protected void onHelloButtonClick() throws InterruptedException {
        myIndicator.setProgress(progress);
        int perfectNum = Integer.parseInt(getInput.getText());
        int Threads = Integer.parseInt(getThread.getText());
        double progress = 0;
        Thread[]thread = new Thread[Threads];
        for(int i = 0; i < Threads; i++){
            thread[i] = new Thread(new setProgress(perfectNum));

        }
        for(Thread t: thread){
            t.start();
            Thread.sleep(1000);

            progress+=0.1;

        }

//        double progress = setProgress.progress;
//        System.out.println(progress);

        myIndicator.setProgress(setProgress.progress);

    }

}