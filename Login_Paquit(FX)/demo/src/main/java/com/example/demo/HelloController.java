package com.example.demo;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class HelloController {

    public static final String[] user1 = {"palma", "pilago", "econar"};
    public static final String[] password = {"russel", "emman", "jm"};
    String pass1 = "123456";
    @FXML
    private Label welcomeText;

    @FXML
    private TextField user_input;

    @FXML
    private PasswordField pass_input;

    @FXML
    private VBox pnLogin;

    @FXML
    private AnchorPane pnHome;

    @FXML
    private AnchorPane pnMain;

    @FXML
    private ColorPicker cpPicker;

//    @FXML
//    private

    @FXML
    protected void onLoginClick() throws IOException {
        String enteredUsername = user_input.getText();
        String enteredPassword = pass_input.getText();
        for(int i=0; i<3;i++){
            if(enteredUsername.equals(user1[i]) && enteredPassword.equals(password[i])) {
                Parent root = FXMLLoader.load(getClass().getResource("welcome-view.fxml"));
                pnMain.getChildren().remove(pnLogin);
                pnMain.getChildren().add(root);
                root.getStylesheets().remove("hello.css");
            }
        }



    }

    @FXML
    protected void onLogoutClick() throws IOException {
        Parent root= FXMLLoader.load(getClass().getResource("Login.fxml"));

        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter(getClass().getResource("hello.css").getPath()));
            bw.write(".root { -fx-background-image: url(\"bg.jpg\");}");
            bw.newLine();
            bw.write(".button { -fx-background-color: #"+ cpPicker.getValue().toString().substring(2,8)+";}");
            bw.close();
        }catch (IOException e){
            e.printStackTrace();
        }
        AnchorPane parent = (AnchorPane)pnMain.getParent();
        pnMain.getChildren().remove(pnLogin);
        pnMain.getChildren().add(root);

    }


}