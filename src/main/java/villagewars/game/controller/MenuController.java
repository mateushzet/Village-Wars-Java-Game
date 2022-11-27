package villagewars.game.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class MenuController {

    @FXML
    private Button exitButton;

    @FXML
    private Button loadGameButton;

    @FXML
    private Button startGameButton;

    @FXML
    void Exit(ActionEvent event) {
        ViewController.closeView();
    }

    @FXML
    void loadGame(ActionEvent event) {

    }

    @FXML
    void startGame(ActionEvent event) {
        ViewController.setGameView();

    }

}

