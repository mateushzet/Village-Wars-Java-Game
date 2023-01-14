package villagewars.game.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class LoginController {

    @FXML
    private TextField loginName;

    @FXML
    private TextField loginPassword;


    @FXML
    void onLogin(ActionEvent event) {
        ViewController.setMenuView();
    }

    @FXML
    void redirectToRegister(ActionEvent event) {
        ViewController.setRegisterView();
    }

}