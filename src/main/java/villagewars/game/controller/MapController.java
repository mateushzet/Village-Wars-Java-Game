package villagewars.game.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

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
    private ImageView village1;

    @FXML
    private Button village1Bth;

    @FXML
    private ImageView village2;

    @FXML
    private Button village2Btn;

    @FXML
    private ImageView village3;

    @FXML
    private Button village3Btn;

    @FXML
    private ImageView village4;

    @FXML
    private Button village4Btn;

    @FXML
    private ImageView village5;

    @FXML
    private Button village5Btn;

    @FXML
    private ImageView village6;

    @FXML
    private Button village6Btn;

    @FXML
    void attackPlayer(ActionEvent event) {

    }

    @FXML
    void goToVillageMap(ActionEvent event) {
        ViewController.setGameView();
    }

    @FXML
    void showVillage(ActionEvent event) {

    }

}