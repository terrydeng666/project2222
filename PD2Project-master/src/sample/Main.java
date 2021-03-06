package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;
import java.io.*;
import java.util.Objects;

public class Main extends Application {
    private String level="";
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("menu.fxml"));
        Parent root = loader.load();
        MenuController menuController = loader.getController();
        stage.setTitle("Asia God Tone Hot Pot");
        Scene menu = new Scene(root);
        menuController.setPrevStage(stage);

        //存檔
        try {
            BufferedReader br=new BufferedReader(new FileReader("PD2Project-master/src/sample/level.txt"));
            level=br.readLine();
            br.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
        //主選單的scene
        menu.setOnKeyPressed(keyEvent -> {
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
                                break;
                            case "2":
                                menuController.toLevel2();
                                break;
                            case "3":
                                menuController.toLevel3();
                                break;
                            case "4":
                                menuController.toLevel4();
                                break;
                            case "5":
                                menuController.toLevel5();
                                break;
                            case "6":
                                menuController.toLevel6();
                                break;
                            case "7":
                                menuController.toLevel7();
                                break;
                            case "8":
                                menuController.toLevel8();
                                break;
                            case "9":
                                menuController.toLevel9();
                                break;
                            case "10":
                                menuController.toLevel10();
                                break;
                            default:
                                break;
                        }
                    }
                    else if(menuController.getHotpotY()==3){
                        try {
                            FXMLLoader instruction = new FXMLLoader(getClass().getResource("howToPlay.fxml"));
                            Parent playRoot = instruction.load();
                            Scene howToPlayScene = new Scene(playRoot);
                            Stage howToPlayStage = new Stage();
                            String css = Objects.requireNonNull(this.getClass().getResource("howToPlaycss.css")).toExternalForm();
                            howToPlayStage.setScene(howToPlayScene);
                            howToPlayStage.setTitle("How To Play");
                            howToPlayScene.getStylesheets().add(css);
                            howToPlayStage.show();
                        }catch(IOException e){
                            e.printStackTrace();
                        }
                    }
                    //Exit
                    else if (menuController.getHotpotY() == 4)
                        System.exit(0);
                    break;
                default:
                    break;
            }
        });
        stage.setScene(menu);
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
