package villagewars.game.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import villagewars.Main;
import java.util.ArrayList;

import java.util.Collections;

public class MapController {

    static int enemyID;


    @FXML
    private Button attack;

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
    private Button village1Btn;

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

    private ArrayList<Button> villageButtons = new ArrayList<>();


    private ArrayList<ImageView> villageImages = new ArrayList<>();

    private

    @FXML
    void attackPlayer(ActionEvent event) {

        Main.attackPlayer(String.valueOf(enemyID));

    }

    @FXML
    void goToVillageMap(ActionEvent event) {
        ViewController.setGameView();
    }

    @FXML
    void showVillage(ActionEvent event) {
        Button btn = (Button) (event.getSource());

        for (int i = 0; i < villageButtons.size(); i++) {
            if(villageButtons.get(i).getId().equals(btn.getId())){
                enemyID = i+1;
            }
        }
        updatePlayerStats();
        System.out.println(Main.getPlayerID());
        if (enemyID != Integer.parseInt(Main.getPlayerID())){
        attack.setVisible(true);}
        else {attack.setVisible(false);}
    }

    @FXML
    void initialize(){
        villageImages.add(village1);
        villageImages.add(village2);
        villageImages.add(village3);
        villageImages.add(village4);
        villageImages.add(village5);
        villageImages.add(village6);

        villageButtons.add(village1Btn);
        villageButtons.add(village2Btn);
        villageButtons.add(village3Btn);
        villageButtons.add(village4Btn);
        villageButtons.add(village5Btn);
        villageButtons.add(village6Btn);

        playersNickname.setText(Main.getNickname());
        enemyNickname.setText("Enemy");

        int maxID = Main.getMaxID();
        for (int i = maxID ; i < villageImages.size(); i++) {
            villageImages.get(i).setVisible(false);
        }
        pikemanNumber.setText(Main.quantityPikeman());
        swordsmanNumber.setText(Main.quantitySwordsman());
        axemanNumber.setText(Main.quantityAxeman());
        attackPowerNumber.setText(String.valueOf( Main.getAttackPower()));
        defencePowerNumber.setText(String.valueOf( Main.getDefencePower()));

        attack.setVisible(false);
    }

    void updatePlayerStats(){

        enemyDefencePowerNumber.setText(String.valueOf(Main.getDefencePowerByVillageID(String.valueOf(enemyID))));
        enemyAttackPowerNumber.setText(String.valueOf(Main.getAttackPowerByVillageID(String.valueOf(enemyID))));

    }
}