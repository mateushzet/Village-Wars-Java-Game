package villagewars;

import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import villagewars.game.controller.ViewController;

public class Main extends Application{

	public static Stage stage;
	public static Scene scene;
	public static Timeline animation;

	public static void main(String[] args) {
		launch(args);
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