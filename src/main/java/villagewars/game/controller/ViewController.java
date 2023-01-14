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

    private static FXMLLoader mapViewLoader;

    private static FXMLLoader loginViewLoader;

    private static FXMLLoader registerViewLoader;


    public static void closeView() {
        Main.stage.close();
    }

    private static void setView(FXMLLoader view, String title) {
        try {
            Main.scene = new Scene(view.load());
            Main.stage.setScene(Main.scene);
            Main.stage.setTitle(title);
            Main.stage.show();
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

    public static void setMapView(){
        mapViewLoader=new FXMLLoader(Main.class.getResource("map-view.fxml"));
        setView(mapViewLoader, "Village wars2");
    }
    public static void setLoginView(){
        loginViewLoader=new FXMLLoader(Main.class.getResource("login-view.fxml"));
        setView(loginViewLoader, "Login");
    }
    public static void setRegisterView(){
        registerViewLoader=new FXMLLoader(Main.class.getResource("register-view.fxml"));
        setView(registerViewLoader, "Register");
    }
}
