package villagewars.game.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class RegisterController{

    @FXML
    private TextField registerEmail;

    @FXML
    private TextField registerName;

    @FXML
    private TextField registerPassword;

    @FXML
    void onRegister(ActionEvent event) {
        ViewController.setMenuView();
    }

    @FXML
    void redirectToLogin(ActionEvent event) {
        ViewController.setLoginView();
    }

}