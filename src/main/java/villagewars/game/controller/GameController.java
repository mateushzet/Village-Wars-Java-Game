package villagewars.game.controller;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import villagewars.Main;

import java.util.ArrayList;

public class GameController {


    @FXML
    private Label DefencePowerNumber;

    @FXML
    private Label attackPowerNumber;

    @FXML
    private Label axemanNumber;

    @FXML
    private Button barracksButton;

    @FXML
    private Pane barracksPane;

    @FXML
    private Button farmButton;

    @FXML
    private Label farmLevel;

    @FXML
    private Label farmLevelMine;

    @FXML
    private Label farmLevelRathaus;

    @FXML
    private Label farmLevelTimber;

    @FXML
    private Pane farmPane;

    @FXML
    private Label foodNeededForUpgrade;

    @FXML
    private Label foodNeededForUpgradeFarm;

    @FXML
    private Label foodNeededForUpgradeMine;

    @FXML
    private Label foodNeededForUpgradeTimber;

    @FXML
    private Label foodNumber;

    @FXML
    private Label foodNumber1;

    @FXML
    private Label foodNumber2;

    @FXML
    private Label foodProduction;

    @FXML
    private Button mindButton;

    @FXML
    private Label mineLevel;

    @FXML
    private Label mineLevelFarm;

    @FXML
    private Label mineLevelRathaus;

    @FXML
    private Label mineLevelTimber;

    @FXML
    private Pane minePane;

    @FXML
    private Label nickNameLabel;

    @FXML
    private Label pikemanNumber;

    @FXML
    private Label rathausLevel;

    @FXML
    private Label rathausLevelFarm;

    @FXML
    private Label rathausLevelMine;

    @FXML
    private Label rathausLevelTimber;

    @FXML
    private Button ratthausButton;

    @FXML
    private Pane ratthausPane;

    @FXML
    private Label stoneNeededForUpgrade;

    @FXML
    private Label stoneNeededForUpgradeFarm;

    @FXML
    private Label stoneNeededForUpgradeMine;

    @FXML
    private Label stoneNeededForUpgradeTimber;

    @FXML
    private Label stoneNumber;

    @FXML
    private Label stoneNumber1;

    @FXML
    private Label stoneProduction;

    @FXML
    private Label swordsmanNumber;

    @FXML
    private Button timberCampButton;

    @FXML
    private Label timberCampLevel;

    @FXML
    private Label timberCampLevelFarm;

    @FXML
    private Label timberCampLevelMine;

    @FXML
    private Label timberCampLevelRathaus;

    @FXML
    private Pane timberCampPane;

    @FXML
    private Button wareHouseButton;

    @FXML
    private Pane wareHousePane;

    @FXML
    private Label woodNeededForUpgrade;

    @FXML
    private Label woodNeededForUpgradeFarm;

    @FXML
    private Label woodNeededForUpgradeMine;

    @FXML
    private Label woodNeededForUpgradeTimber;

    @FXML
    private Label woodNumber;

    @FXML
    private Label woodNumber1;

    @FXML
    private Label woodProduction;


    private ArrayList<Pane> lista = new ArrayList<>();

    @FXML
    void goToWorldsMap(ActionEvent event) {
        ViewController.setMapView();
    }

    @FXML
    void increaseFarmLevel(ActionEvent event) {

    }

    @FXML
    void increaseMineLevel(ActionEvent event) {

    }

    @FXML
    void increaseTimberCampLevel(ActionEvent event) {

    }
    @FXML
    void showMineDetails(ActionEvent event){
        lista.forEach(pane -> pane.setVisible(false));
        minePane.setVisible(!ratthausPane.isVisible());
    }
    @FXML
    void showFarmDetails(ActionEvent event){
        lista.forEach(pane -> pane.setVisible(false));
        farmPane.setVisible(!ratthausPane.isVisible());
    }
    @FXML
    void showTimberCampDetails(ActionEvent event){
        lista.forEach(pane -> pane.setVisible(false));
        timberCampPane.setVisible(!ratthausPane.isVisible());
    }
    @FXML
    void showWareHouseDetails(ActionEvent event){
        lista.forEach(pane -> pane.setVisible(false));
        wareHousePane.setVisible(!ratthausPane.isVisible());
    }




    @FXML
    void showRathausDetails(ActionEvent event){
        lista.forEach(pane -> pane.setVisible(false));
        ratthausPane.setVisible(!ratthausPane.isVisible());
    }

    @FXML
    void showBarracksDetails(ActionEvent event){
        lista.forEach(pane -> pane.setVisible(false));
        barracksPane.setVisible(!barracksPane.isVisible());
    }

    @FXML
    void increaseRathausLevel(ActionEvent event) {
//        Main.a.village.getRathaus().levelUp(Main.a.village.getRathaus());
        updatePlayerStats();
    }

    @FXML
    void increaseAxeman(ActionEvent event) {
//        Main.a.village.getRathaus().getBarracks().recruitAxeman();
        updatePlayerStats();
    }

    @FXML
    void increasePikeman(ActionEvent event) {
//        Main.a.village.getRathaus().getBarracks().recruitPikeman();
        updatePlayerStats();

    }

    @FXML
    void increaseSwordsman(ActionEvent event) {
//        Main.a.village.getRathaus().getBarracks().recruitSwordsman();
        updatePlayerStats();

    }

    public void updatePlayerStats() {
//        axemanNumber.setText(String.valueOf(Main.a.village.getRathaus().getBarracks().getAxemans().getQuantity()));
//        pikemanNumber.setText(String.valueOf(Main.a.village.getRathaus().getBarracks().getPikemans().getQuantity()));
//        swordsmanNumber.setText(String.valueOf(Main.a.village.getRathaus().getBarracks().getSwordsmans().getQuantity()));
//        woodNumber.setText(String.valueOf(Main.a.village.getRathaus().getWareHouse().getWood()));
//        stoneNumber.setText(String.valueOf(Main.a.village.getRathaus().getWareHouse().getStone()));
//        foodNumber.setText(String.valueOf(Main.a.village.getRathaus().getWareHouse().getFood()));
//        woodNumber1.setText(String.valueOf(Main.a.village.getRathaus().getWareHouse().getWood()));
//        stoneNumber1.setText(String.valueOf(Main.a.village.getRathaus().getWareHouse().getStone()));
//        foodNumber2.setText(String.valueOf(Main.a.village.getRathaus().getWareHouse().getFood()));
//        rathausLevel.setText(String.valueOf(Main.a.village.getRathaus().getLevel()));
//        attackPowerNumber.setText(String.valueOf(Main.a.village.getRathaus().getBarracks().calculateAttackPower()));
//        DefencePowerNumber.setText(String.valueOf(Main.a.village.getRathaus().getBarracks().calculateDefencePower()));
//        woodNeededForUpgrade.setText(String.valueOf(Main.a.village.getRathaus().getLevel()*100));
//        stoneNeededForUpgrade.setText(String.valueOf(Main.a.village.getRathaus().getLevel()*100));
//        foodNeededForUpgrade.setText(String.valueOf(Main.a.village.getRathaus().getLevel()*100));
    }

    @FXML
    void initialize(){
//        Main.a.village.startResourcesProduction();
        nickNameLabel.setText(Main.getNickname());
        Main.animation = new Timeline(new KeyFrame(Duration.seconds(1.0), e -> updatePlayerStats()));
        Main.animation.setCycleCount(Animation.INDEFINITE);
        Main.animation.playFromStart();
        lista.add(ratthausPane);
        lista.add(barracksPane);
        lista.add(minePane);
        lista.add(farmPane);
        lista.add(timberCampPane);
        lista.add(wareHousePane);
        lista.forEach(pane -> pane.setVisible(false));

    }

}