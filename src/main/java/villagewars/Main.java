package villagewars;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import villagewars.game.controller.ViewController;
import villagewars.game.player.Player;

import java.util.Scanner;
public class Main extends Application {

	public static Stage stage;
	public static Scene scene;
	
	public static Player a = new Player("MyNickname", "MyPassword");
	
	public static void main(String[] args) {
//		a.village.startResourcesProduction();
//		printVillage(a);
//		a.village.stopResourcesProduction();
		launch(args);
	}
	
	static public void printVillage(Player player){
		int choose;
		Scanner sc = new Scanner(System.in);

		while(true){
		
			System.out.println(player.getNickname() + "'s villagewars.game.game.village.Village ");
			
			System.out.println();
			System.out.println("Type:");
			System.out.print("1) - show resources\t");
			System.out.print("2) - show building levels\t");
			System.out.print("3) - show army\t");
			System.out.println("4) - recruit pikeman");
			System.out.print("5) - recruit swordseman\t");
			System.out.print("6) - recruit axeman\t");
			System.out.print("7) - upgrade rathaus\t");
		
			choose = sc.nextInt();
			if(choose == 1){
				player.village.getRathaus().getWareHouse().printResources();
			}
			if(choose == 2){
				player.village.printBuildings();
			}
			if(choose == 3){
			player.village.getRathaus().getBarracks().printArmy();
			}
			if(choose == 4){
				player.village.getRathaus().getBarracks().recruitPikeman();
			}
			if(choose == 5){
				player.village.getRathaus().getBarracks().recruitSwordsman();
			}
			if(choose == 6){
				player.village.getRathaus().getBarracks().recruitAxeman();
			}
			if(choose == 7){
				player.village.getRathaus().levelUp(player.village.getRathaus());
			}

			System.out.println();
		}
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