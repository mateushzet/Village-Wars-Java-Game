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
       // Main.a.village.getRathaus().levelUp("rathaus");
        updatePlayerStats();
    }

    @FXML
    void increaseAxeman(ActionEvent event) {
        //Main.a.village.getRathaus().getBarracks().recruitAxeman(1);
        updatePlayerStats();
    }

    @FXML
    void increasePikeman(ActionEvent event) {
        Main.recruitPikeman();
        updatePlayerStats();

    }

    @FXML
    void increaseSwordsman(ActionEvent event) {
        //Main.a.village.getRathaus().getBarracks().recruitSwordsman(1);
        updatePlayerStats();

    }

    public void updatePlayerStats() {


        axemanNumber.setText(String.valueOf(Main.quantityAxeman()));
        pikemanNumber.setText(String.valueOf(Main.quantityPikeman()));
        swordsmanNumber.setText(String.valueOf(Main.quantitySwordsman()));
        woodNumber.setText(String.valueOf(Main.getWood()));
        stoneNumber.setText(String.valueOf(Main.getStone()));
        foodNumber.setText(String.valueOf(Main.getFood()));
        rathausLevel.setText(String.valueOf(Main.rathausLevel()));
        //attackPowerNumber.setText(String.valueOf(Main. ));
        //DefencePowerNumber.setText(String.valueOf(Main.a.village.getRathaus().getBarracks().calculateDefencePower()));
    }

    @FXML
    void initialize(){
        //Main.a.village.startResourcesProduction();
        Main.animation = new Timeline(new KeyFrame(Duration.seconds(1.0), e -> updatePlayerStats()));
        Main.animation.setCycleCount(Animation.INDEFINITE);
        Main.animation.playFromStart();
    }

}
