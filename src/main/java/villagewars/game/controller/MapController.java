package villagewars.game.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import javax.swing.text.View;

public class MapController {

    @FXML
    private Label DefencePowerNumber;

    @FXML
    private Label attackPowerNumber;

    @FXML
    private Label axemanNumber;

    @FXML
    private Label pikemanNumber;

    @FXML
    private Label swordsmanNumber;

    @FXML
    void goToVillageMap(ActionEvent event) {
        ViewController.setGameView();
    }

}