package villagewars.game.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class MapController {

    @FXML
    private Label attackPowerNumber;

    @FXML
    private Label axemanNumber;

    @FXML
    private Label defencePowerNumber;

    @FXML
    private Label enemyAttackPowerNumber;

    @FXML
    private Label enemyAxemanNumber;

    @FXML
    private Label enemyDefencePowerNumber;

    @FXML
    private Label enemyNickname;

    @FXML
    private Label enemyPikemanNumber;

    @FXML
    private Label enemySwordsmanNumber;

    @FXML
    private Label pikemanNumber;

    @FXML
    private Label playersNickname;

    @FXML
    private Label swordsmanNumber;

    @FXML
    void attackPlayer(ActionEvent event) {

    }

    @FXML
    void goToVillageMap(ActionEvent event) {
        ViewController.setGameView();
    }

}