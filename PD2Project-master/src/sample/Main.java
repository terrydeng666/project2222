package sample;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import java.io.*;
public class Main extends Application {
    private String level="";

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("menu.fxml"));
        Parent root = loader.load();
        MenuController menuController = loader.getController();
        stage.setTitle("Asia God Tone Hot Pot");
        Scene menu = new Scene(root);
        //存檔
        try {
            BufferedReader br=new BufferedReader(new FileReader("PD2Project-master/src/sample/level.txt"));
            level=br.readLine();
            br.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
        //主選單的scene
        menu.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                switch (keyEvent.getCode()) {
                    //一個選項單位是y 上下移動
                    case W:
                        if (menuController.getHotpotY() <= 1) break;
                        menuController.up();
                        break;
                    case S:
                        if (menuController.getHotpotY() >= 4) break;
                        menuController.down();
                        break;
                    case D:
                        //如果選new game(第一個選項) 就跳到level1的畫面
                        if (menuController.getHotpotY() == 1){
                            menuController.toLevel1();
                            stage.close();
                        }
                        else if(menuController.getHotpotY()==2){
                            //讀檔 看上次第幾關就從第幾關開始
                            switch (level) {
                                case"1":
                                    menuController.toLevel1();
                                    stage.close();
                                    break;
                                case "2":
                                    System.out.println("level2");
                                    break;
                            }
                        }
                        //Exit
                        if (menuController.getHotpotY() == 4)
                            System.exit(0);
                        break;
                    default:
                        break;
                }
            }
        });
        stage.setScene(menu);
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
