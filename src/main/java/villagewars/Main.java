package villagewars;

import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import villagewars.game.controller.ViewController;
import villagewars.game.player.Player;

import java.util.Scanner;
public class Main extends Application{

	public static Stage stage;
	public static Scene scene;
	public static Timeline animation;
	public static Player a = new Player("MyNickname", "MyPassword");

	public static void main(String[] args) {
		launch(args);
	}

	static public void printVillage(Player player){
	}
	@Override
	public void start(Stage primaryStage) {
		primaryStage.setResizable(false);
		primaryStage.alwaysOnTopProperty();
		primaryStage.requestFocus();
		stage = primaryStage;
		ViewController.setMenuView();
	}

}