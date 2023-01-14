package villagewars.game.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import villagewars.Main;

import java.io.IOException;

public class RegisterController{

    @FXML
    private TextField registerEmail;

    @FXML
    private TextField registerName;

    @FXML
    private TextField registerPassword;

    @FXML
    void onRegister(ActionEvent event) {
        try {
            if(!registerName.getText().equals("") && !registerPassword.getText().equals("")){
            if(Main.registration(registerName.getText(),registerPassword.getText())) {
                ViewController.setGameView();
                }else ViewController.setRegisterView();
            }
            else ViewController.setRegisterView();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void redirectToLogin(ActionEvent event) {
        ViewController.setLoginView();
    }

}