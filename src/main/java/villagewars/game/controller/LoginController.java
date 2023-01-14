package villagewars.game.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import villagewars.Main;

import java.io.IOException;

public class LoginController {

    @FXML
    private TextField loginName;

    @FXML
    private TextField loginPassword;


    @FXML
    void onLogin(ActionEvent event) {
        try {
            if(Main.login(loginName.getText(), loginPassword.getText())){
                ViewController.setGameView();
            };
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void redirectToRegister(ActionEvent event) {
        ViewController.setRegisterView();
    }

}