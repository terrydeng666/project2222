package sample;

import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MenuController implements Initializable {
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //
    }
    @FXML
    private ImageView menu;
    @FXML
    private ImageView hotpot;
    private Stage prevStage;
    private int y=1;
    //一個選項的單位
    public void selected(){

    }
    public void nonselected(){

    }
    public int getHotpotY() {
        return y;
    }

    public void up() {
        //火鍋圖向上移動32
        TranslateTransition translate = new TranslateTransition();
        translate.setNode(hotpot);
        translate.setDuration(Duration.millis(1));
        translate.setByY(-32);
        translate.play();
        y--;

    }
    public void down() {
        //火鍋圖向下移動32
        TranslateTransition translate = new TranslateTransition();
        translate.setNode(hotpot);
        translate.setDuration(Duration.millis(1));
        translate.setByY(32);
        translate.play();
        y++;
    }
    public void toLevel1() {
        try {
            //產生level1的scene
            FXMLLoader loader = new FXMLLoader(getClass().getResource("level1.fxml"));
            Parent root = loader.load();
            Scene level1 = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(level1);
            stage.setTitle("Level 1");
            Level1Controller controller=loader.getController();
            controller.drawMap();
            prevStage.close();
            controller.setPrevStage(stage);
            stage.show();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void toLevel2() {
        try {
            //產生level1的scene
            FXMLLoader loader = new FXMLLoader(getClass().getResource("level2.fxml"));
            Parent root = loader.load();
            Scene level2 = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(level2);
            stage.setTitle("Level 2");
            Level2Controller controller=loader.getController();
            controller.drawMap();
            prevStage.close();
            controller.setPrevStage(stage);
            stage.show();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void toLevel3() {
        try {
            //產生level1的scene
            FXMLLoader loader = new FXMLLoader(getClass().getResource("level3.fxml"));
            Parent root = loader.load();
            Scene level3 = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(level3);
            stage.setTitle("Level 3");
            Level3Controller controller=loader.getController();
            controller.drawMap();
            prevStage.close();
            controller.setPrevStage(stage);
            stage.show();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void toLevel4() {
        try {
            //產生level1的scene
            FXMLLoader loader = new FXMLLoader(getClass().getResource("level4.fxml"));
            Parent root = loader.load();
            Scene level4 = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(level4);
            stage.setTitle("Level 4");
            Level4Controller controller=loader.getController();
            controller.drawMap();
            prevStage.close();
            controller.setPrevStage(stage);
            stage.show();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void toLevel5() {
        try {
            //產生level1的scene
            FXMLLoader loader = new FXMLLoader(getClass().getResource("level5.fxml"));
            Parent root = loader.load();
            Scene level5 = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(level5);
            stage.setTitle("Level 5");
            Level5Controller controller=loader.getController();
            controller.drawMap();
            prevStage.close();
            controller.setPrevStage(stage);
            stage.show();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void toLevel6() {
        try {
            //產生level1的scene
            FXMLLoader loader = new FXMLLoader(getClass().getResource("level6.fxml"));
            Parent root = loader.load();
            Scene level6 = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(level6);
            stage.setTitle("Level 6");
            Level6Controller controller=loader.getController();
            controller.drawMap();
            prevStage.close();
            controller.setPrevStage(stage);
            stage.show();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void toLevel7() {
        try {
            //產生level1的scene
            FXMLLoader loader = new FXMLLoader(getClass().getResource("level7.fxml"));
            Parent root = loader.load();
            Scene level7 = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(level7);
            stage.setTitle("Level 7");
            Level7Controller controller=loader.getController();
            controller.drawMap();
            prevStage.close();
            controller.setPrevStage(stage);
            stage.show();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void toLevel8() {
        try {
            //產生level1的scene
            FXMLLoader loader = new FXMLLoader(getClass().getResource("level8.fxml"));
            Parent root = loader.load();
            Scene level8 = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(level8);
            stage.setTitle("Level 8");
            Level8Controller controller=loader.getController();
            controller.drawMap();
            prevStage.close();
            controller.setPrevStage(stage);
            stage.show();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void toLevel9() {
        try {
            //產生level1的scene
            FXMLLoader loader = new FXMLLoader(getClass().getResource("level9.fxml"));
            Parent root = loader.load();
            Scene level9 = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(level9);
            stage.setTitle("Level 9");
            Level9Controller controller=loader.getController();
            controller.drawMap();
            prevStage.close();
            controller.setPrevStage(stage);
            stage.show();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void toLevel10() {
        try {
            //產生level1的scene
            FXMLLoader loader = new FXMLLoader(getClass().getResource("level10.fxml"));
            Parent root = loader.load();
            Scene level10 = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(level10);
            stage.setTitle("Level 10");
            Level10Controller controller=loader.getController();
            controller.drawMap();
            prevStage.close();
            controller.setPrevStage(stage);
            stage.show();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void setPrevStage(Stage stage){
        this.prevStage = stage;
    }
    @FXML
    private VBox menubox;
}
