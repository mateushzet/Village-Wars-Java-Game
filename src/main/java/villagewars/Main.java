package villagewars;

import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import villagewars.game.controller.ViewController;
import villagewars.game.player.Player;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.util.Scanner;
public class Main extends Application {

	static PrintWriter pw;
	static String host = "localhost";
	static Integer port = 2234;
	static Socket socket;
	static InputStreamReader in;
	static BufferedReader bf;

	public static Stage stage;
	public static Scene scene;
	public static Timeline animation;
	//public static Player a = new Player("MyNickname", "MyPassword", con);

	public static void main(String[] args) throws Exception {
		socket = new Socket(InetAddress.getByName(host), port);

		//wysylanie do servera
		pw = new PrintWriter(socket.getOutputStream());

		//odbieranie od servera
		in = new InputStreamReader(socket.getInputStream());
		bf = new BufferedReader(in);

		System.out.println("Oczekiwanie na polaczenie" + System.lineSeparator());
		login("kamil", "piesek");

		launch(args);
	}

	static public void printVillage(Player player) {
	}

	@Override
	public void start(Stage primaryStage) {
		primaryStage.setResizable(false);
		primaryStage.alwaysOnTopProperty();
		primaryStage.requestFocus();
		stage = primaryStage;
		ViewController.setLoginView();
	}

	static public boolean login(String nickname, String password) throws IOException {

		String output;
		pw.println("login");
		pw.flush();
		while ((output = bf.readLine()) == null) {
		}
		pw.println(nickname);
		pw.flush();

		while ((output = bf.readLine()) == null) {
		}
		pw.println(password);
		pw.flush();

		while ((output = bf.readLine()) == null) {
		}
		return (output.equals("true")) ? true : false;
	}

	//---------------- Select methods

	static public String getWoodProduction() {
		try {

			String output;
			pw.println("getWoodProduction");
			pw.flush();
			while ((output = bf.readLine()) == null) {
			}
			return output;

		} catch (IOException e) {
			return "NaN";
		}
	}

	static public String getFoodProduction() {
		try {

			String output;
			pw.println("getFoodProduction");
			pw.flush();
			while ((output = bf.readLine()) == null) {
			}
			return output;

		} catch (IOException e) {
			return "NaN";
		}
	}

	static public String getStoneProduction() {
		try {

			String output;
			pw.println("getStoneProduction");
			pw.flush();
			while ((output = bf.readLine()) == null) {
			}
			return output;

		} catch (IOException e) {
			return "NaN";
		}
	}

	static public String getWood() {
		try {

			String output;
			pw.println("getWood");
			pw.flush();
			while ((output = bf.readLine()) == null) {
			}
			return output;

		} catch (IOException e) {
			return "NaN";
		}
	}

	static public String getFood() {
		try {

			String output;
			pw.println("getFood");
			pw.flush();
			while ((output = bf.readLine()) == null) {
			}
			return output;

		} catch (IOException e) {
			return "NaN";
		}
	}

	static public String getStone() {
		try {

			String output;
			pw.println("getStone");
			pw.flush();
			while ((output = bf.readLine()) == null) {
			}
			return output;

		} catch (IOException e) {
			return "NaN";
		}
	}

	static public String quantityPikeman() {
		try {

			String output;
			pw.println("quantityPikeman");
			pw.flush();
			while ((output = bf.readLine()) == null) {
			}
			return output;

		} catch (IOException e) {
			return "NaN";
		}
	}

	static public String quantitySwordsman() {
		try {

			String output;
			pw.println("quantitySwordsman");
			pw.flush();
			while ((output = bf.readLine()) == null) {
			}
			return output;

		} catch (IOException e) {
			return "NaN";
		}
	}

	static public String quantityAxeman() {
		try {

			String output;
			pw.println("quantityAxeman");
			pw.flush();
			while ((output = bf.readLine()) == null) {
			}
			return output;

		} catch (IOException e) {
			return "NaN";
		}
	}

	static public String barracksLevel() {
		try {

			String output;
			pw.println("barracksLevel");
			pw.flush();
			while ((output = bf.readLine()) == null) {
			}
			return output;

		} catch (IOException e) {
			return "NaN";
		}
	}

	static public String farmLevel() {
		try {

			String output;
			pw.println("farmLevel");
			pw.flush();
			while ((output = bf.readLine()) == null) {
			}
			return output;

		} catch (IOException e) {
			return "NaN";
		}
	}

	static public String mineLevel() {
		try {

			String output;
			pw.println("mineLevel");
			pw.flush();
			while ((output = bf.readLine()) == null) {
			}
			return output;

		} catch (IOException e) {
			return "NaN";
		}
	}

	static public String rathausLevel() {
		try {

			String output;
			pw.println("rathausLevel");
			pw.flush();
			while ((output = bf.readLine()) == null) {
			}
			return output;

		} catch (IOException e) {
			return "NaN";
		}
	}

	static public String timberCampLevel() {
		try {

			String output;
			pw.println("timberCampLevel");
			pw.flush();
			while ((output = bf.readLine()) == null) {
			}
			return output;

		} catch (IOException e) {
			return "NaN";
		}
	}

	static public String wareHouseLevel() {
		try {

			String output;
			pw.println("wareHouseLevel");
			pw.flush();
			while ((output = bf.readLine()) == null) {
			}
			return output;

		} catch (IOException e) {
			return "NaN";
		}
	}

	//------------- Update methods

	static public void recruitPikeman() {
		pw.println("recruitPikeman");
		pw.flush();
	}

	static public void recruitSwordsman() {
		pw.println("recruitSwordsman");
		pw.flush();
	}

	static public void recruitAxeman() {
		pw.println("recruitAxeman");
		pw.flush();
	}

	static public void incrementBarracks() {
		pw.println("incrementBarracks");
		pw.flush();
	}

	static public void incrementFarm() {
		pw.println("incrementFarm");
		pw.flush();
	}

	static public void incrementMine() {
		pw.println("incrementMine");
		pw.flush();
	}

	static public void incrementRathaus() {
		pw.println("incrementRathaus");
		pw.flush();
	}

	static public void incrementTimberCamp() {
		pw.println("incrementTimberCamp");
		pw.flush();
	}

	static public void incrementWareHouse() {
		pw.println("incrementWareHouse");
		pw.flush();
	}

}