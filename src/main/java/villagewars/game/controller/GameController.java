package villagewars.game.controller;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.util.Duration;
import villagewars.Main;

public class GameController {


    @FXML
    private Label DefencePowerNumber;

    @FXML
    private Label attackPowerNumber;

    @FXML
    private Label axemanNumber;

    @FXML
    private Label foodNumber;

    @FXML
    private Label pikemanNumber;

    @FXML
    private Label rathausLevel;

    @FXML
    private Label stoneNumber;

    @FXML
    private Label swordsmanNumber;

    @FXML
    private Label woodNumber;

    @FXML
    void increaseRathausLevel(ActionEvent event) {
        Main.a.village.getRathaus().levelUp(Main.a.village.getRathaus());
        updatePlayerStats();
    }

    @FXML
    void increaseAxeman(ActionEvent event) {
        Main.a.village.getRathaus().getBarracks().recruitAxeman();
        updatePlayerStats();
    }

    @FXML
    void increasePikeman(ActionEvent event) {
        Main.a.village.getRathaus().getBarracks().recruitPikeman();
        updatePlayerStats();

    }

    @FXML
    void increaseSwordsman(ActionEvent event) {
        Main.a.village.getRathaus().getBarracks().recruitSwordsman();
        updatePlayerStats();

    }

    public void updatePlayerStats() {
        axemanNumber.setText(String.valueOf(Main.a.village.getRathaus().getBarracks().getAxemans().getQuantity()));
        pikemanNumber.setText(String.valueOf(Main.a.village.getRathaus().getBarracks().getPikemans().getQuantity()));
        swordsmanNumber.setText(String.valueOf(Main.a.village.getRathaus().getBarracks().getSwordsmans().getQuantity()));
        woodNumber.setText(String.valueOf(Main.a.village.getRathaus().getWareHouse().getWood()));
        stoneNumber.setText(String.valueOf(Main.a.village.getRathaus().getWareHouse().getStone()));
        foodNumber.setText(String.valueOf(Main.a.village.getRathaus().getWareHouse().getFood()));
        rathausLevel.setText(String.valueOf(Main.a.village.getRathaus().getLevel()));
        attackPowerNumber.setText(String.valueOf(Main.a.village.getRathaus().getBarracks().calculateAttackPower()));
        DefencePowerNumber.setText(String.valueOf(Main.a.village.getRathaus().getBarracks().calculateDefencePower()));
    }

    @FXML
    void initialize(){
        Main.a.village.startResourcesProduction();
        Main.animation = new Timeline(new KeyFrame(Duration.seconds(1.0), e -> updatePlayerStats()));
        Main.animation.setCycleCount(Animation.INDEFINITE);
        Main.animation.playFromStart();
    }

}
