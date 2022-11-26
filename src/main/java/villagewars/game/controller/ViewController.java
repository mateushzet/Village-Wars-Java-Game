package villagewars.game.controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import villagewars.Main;

import java.io.IOException;

public class ViewController {

    public static GraphicsContext context;

    private static FXMLLoader menuViewLoader;

    private static FXMLLoader gameViewLoader;


    public static void closeView() {
        Main.stage.close();
    }

    private static void setView(FXMLLoader view, String title) {
        try {
            Main.scene = new Scene(view.load());
            Main.stage.setScene(Main.scene);
            Main.stage.setTitle(title);
            Main.stage.show();
//            Main.stage.getIcons().add(new Image("com/codecool/dungeoncrawl/img/gameIcon.jpg"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void setMenuView() {
        menuViewLoader = new FXMLLoader(Main.class.getResource("menu-view.fxml"));
        setView(menuViewLoader, "Main Menu");
    }

    public static void setGameView(){
        gameViewLoader = new FXMLLoader(Main.class.getResource("game-view.fxml"));
        setView(gameViewLoader, "Village wars");
    }
}
