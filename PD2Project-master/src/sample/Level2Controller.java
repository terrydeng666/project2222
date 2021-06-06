package sample;


import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.fxml.FXML;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.io.*;

public class Level2Controller implements Initializable {

    @FXML
    private GridPane gridpane;
    @FXML
    private Pane pane;
    //TODO

    int[][] map = new int[][]{
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0},
            {0, 0, 0, 1, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 3, 1, 0, 0, 0},
            {0, 0, 0, 1, 1, 3, 1, 1, 1, 1, 1, 1, 1, 1, 3, 1, 1, 0, 0, 0},
            {0, 0, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0},
            {0, 0, 0, 1, 1, 1, 1, 1, 0, 2, 1, 1, 1, 2, 0, 1, 1, 0, 0, 0},
            {0, 0, 0, 1, 1, 1, 1, 0, 2, 1, 5, 1, 2, 0, 1, 1, 1, 0, 0, 0},
            {0, 0, 0, 1, 1, 1, 0, 2, 1, 4, 1, 2, 0, 1, 1, 1, 1, 0, 0, 0},
            {0, 0, 0, 1, 1, 0, 2, 1, 1, 1, 2, 0, 1, 1, 1, 1, 1, 0, 0, 0},
            {0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0},
            {0, 0, 0, 1, 1, 3, 1, 1, 1, 1, 1, 1, 1, 1, 3, 1, 1, 0, 0, 0},
            {0, 0, 0, 1, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 3, 1, 0, 0, 0},
            {0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};
    int[][] map2 = new int[][]{
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0},
            {0, 0, 0, 1, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 3, 1, 0, 0, 0},
            {0, 0, 0, 1, 1, 3, 1, 1, 1, 1, 1, 1, 1, 1, 3, 1, 1, 0, 0, 0},
            {0, 0, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0},
            {0, 0, 0, 1, 1, 1, 1, 1, 0, 2, 1, 1, 1, 2, 0, 1, 1, 0, 0, 0},
            {0, 0, 0, 1, 1, 1, 1, 0, 2, 1, 5, 1, 2, 0, 1, 1, 1, 0, 0, 0},
            {0, 0, 0, 1, 1, 1, 0, 2, 1, 4, 1, 2, 0, 1, 1, 1, 1, 0, 0, 0},
            {0, 0, 0, 1, 1, 0, 2, 1, 1, 1, 2, 0, 1, 1, 1, 1, 1, 0, 0, 0},
            {0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0},
            {0, 0, 0, 1, 1, 3, 1, 1, 1, 1, 1, 1, 1, 1, 3, 1, 1, 0, 0, 0},
            {0, 0, 0, 1, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 3, 1, 0, 0, 0},
            {0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};
    int[][] map3 = new int[][]{
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0},
            {0, 0, 0, 1, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 3, 1, 0, 0, 0},
            {0, 0, 0, 1, 1, 3, 1, 1, 1, 1, 1, 1, 1, 1, 3, 1, 1, 0, 0, 0},
            {0, 0, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0},
            {0, 0, 0, 1, 1, 1, 1, 1, 0, 2, 1, 1, 1, 2, 0, 1, 1, 0, 0, 0},
            {0, 0, 0, 1, 1, 1, 1, 0, 2, 1, 5, 1, 2, 0, 1, 1, 1, 0, 0, 0},
            {0, 0, 0, 1, 1, 1, 0, 2, 1, 4, 1, 2, 0, 1, 1, 1, 1, 0, 0, 0},
            {0, 0, 0, 1, 1, 0, 2, 1, 1, 1, 2, 0, 1, 1, 1, 1, 1, 0, 0, 0},
            {0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0},
            {0, 0, 0, 1, 1, 3, 1, 1, 1, 1, 1, 1, 1, 1, 3, 1, 1, 0, 0, 0},
            {0, 0, 0, 1, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 3, 1, 0, 0, 0},
            {0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};
    private int playerX;
    private int playerY;
    public int direct;//1up 2left 3down 4right
    public int iceX1, iceY1, iceX2, iceY2,firex=0,firey=0;
    public Stage prevStage;
    private boolean gameOver = true;
    private boolean playerRight=true;
    private boolean fire=false;
    private boolean restart =false;
    private final int tube=50;

    public void drawMap() {
        for (int i = 0; i < map.length; i++) {//h
            for (int j = 0; j < map[0].length; j++) {//w
                int tube = 50;
                switch (map[i][j]) {
                    case 1://road
                        Image landImage = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/image/land.jpg")), tube, tube, false, false);
                        ImageView land = new ImageView(landImage);
                        GridPane.setConstraints(land, j, i);
                        gridpane.getChildren().add(land);
                        break;
                    case 2://fire
                        Image fireImage = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/image/fire.png")), tube, tube, false, false);
                        ImageView fire = new ImageView(fireImage);
                        GridPane.setConstraints(fire, j, i);
                        gridpane.getChildren().add(fire);
                        break;
                    case 3://ice
                        Image iceImage = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/image/ice.png")), tube, tube, false, false);
                        ImageView ice = new ImageView(iceImage);
                        GridPane.setConstraints(ice, j, i);
                        gridpane.getChildren().add(ice);
                        break;
                    case 4://player
                        Image playerImage;
                        if(playerRight) {
                            playerImage=new Image(Objects.requireNonNull(getClass().getResourceAsStream("/image/player.png")), tube, tube, false, false);
                        }
                        else {
                            playerImage=new Image(Objects.requireNonNull(getClass().getResourceAsStream("/image/playerLeft.png")), tube, tube, false, false);
                        }
                        ImageView player = new ImageView(playerImage);
                        GridPane.setConstraints(player, j, i);
                        gridpane.getChildren().add(player);
                        playerY = i;
                        playerX = j;
                        map[i][j] = map2[i][j];
                        break;
                    case 5:
                        Image goldIceImage = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/image/Au.jpg")), tube, tube, false, false);
                        ImageView goldIce = new ImageView(goldIceImage);
                        GridPane.setConstraints(goldIce, j, i);
                        gridpane.getChildren().add(goldIce);
                        break;
                    case 0:
                        Image wallImage = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/image/wall.png")), tube, tube, false, false);
                        ImageView wall = new ImageView(wallImage);
                        GridPane.setConstraints(wall, j, i);
                        gridpane.getChildren().add(wall);
                        break;
                    default:
                        break;
                }
            }
        }
    }


    public void drawMap2() {
        for (int i = 0; i < map2.length; i++) {//h
            for (int j = 0; j < map2[0].length; j++) {//w
                int tube = 50;
                switch (map2[i][j]) {
                    case 1://road
                        if (map2[i][j] != map[i][j]) {
                            if(i==firey && j==firex) {
                                iceAnimation(3,i,j);
                                firex=0;
                                firey=0;
                            }
                            Image landImage = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/image/land.jpg")), tube, tube, false, false);
                            ImageView land = new ImageView(landImage);
                            GridPane.setConstraints(land, j, i);
                            gridpane.getChildren().add(land);
                            map[i][j] = map2[i][j];
                        }
                        break;
                    case 2://fire
                        gameOver = false;
                        if (map2[i][j] != map[i][j]) {
                            Image fireImage = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/image/fire.png")), tube, tube, false, false);
                            ImageView fire = new ImageView(fireImage);
                            GridPane.setConstraints(fire, j, i);
                            gridpane.getChildren().add(fire);
                            map[i][j] = map2[i][j];
                        }
                        break;
                    case 3://ice
                        if (map2[i][j] != map[i][j]) {
                            if(restart) {
                                Image iceImage = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/image/ice.png")), tube, tube, false, false);
                                ImageView ice = new ImageView(iceImage);
                                GridPane.setConstraints(ice, j, i);
                                gridpane.getChildren().add(ice);
                            }
                            else {
                                iceAnimation(3,i,j);
                            }
                            map[i][j] = map2[i][j];
                        }
                        break;
                    case 4://player
                        if (map2[i][j] != map[i][j]) {
                            Image playerImage;
                            if(playerRight) {
                                playerImage=new Image(Objects.requireNonNull(getClass().getResourceAsStream("/image/player.png")), tube, tube, false, false);
                            }
                            else {
                                playerImage=new Image(Objects.requireNonNull(getClass().getResourceAsStream("/image/playerLeft.png")), tube, tube, false, false);
                            }
                            ImageView player = new ImageView(playerImage);
                            GridPane.setConstraints(player, j, i);
                            gridpane.getChildren().add(player);
                            playerY = i;
                            playerX = j;
                            map[i][j] = map2[i][j];
                        }
                        break;
                    case 5:
                        if (map2[i][j] != map[i][j]) {
                            if(restart) {
                                Image goldIceImage = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/image/Au.jpg")), tube, tube, false, false);
                                ImageView goldIce = new ImageView(goldIceImage);
                                GridPane.setConstraints(goldIce, j, i);
                                gridpane.getChildren().add(goldIce);

                            }
                            else {
                                iceAnimation(5,i,j);
                            }
                            map[i][j] = map2[i][j];
                        }
                        break;
                    case 0:
                        if (map2[i][j] != map[i][j]) {
                            Image wallImage = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/image/wall.png")), tube, tube, false, false);
                            ImageView wall = new ImageView(wallImage);
                            GridPane.setConstraints(wall, j, i);
                            gridpane.getChildren().add(wall);
                            map[i][j] = map2[i][j];
                        }
                        break;
                    default:
                        break;
                }
            }
        }
    }

    @FXML
    void keyPressed(KeyEvent event) throws IOException {
        switch (event.getCode()) {
            case W:
                direct = 1;
                playerMove(direct);
                drawMap2();
                if (gameOver)
                    toLevel3();
                gameOver = true;
                break;
            case A:
                direct = 2;
                playerRight=false;
                playerMove(direct);
                drawMap2();
                if (gameOver)
                    toLevel3();
                gameOver = true;
                break;
            case S:
                direct = 3;
                playerMove(direct);
                drawMap2();
                if (gameOver)
                    toLevel3();
                gameOver = true;
                break;
            case D:
                direct = 4;
                playerRight=true;
                playerMove(direct);
                drawMap2();
                if (gameOver)
                    toLevel3();
                gameOver = true;
                break;
            case R: //重新開始
                restart=true;
                for (int i = 0; i < map.length; i++) {
                    System.arraycopy(map3[i], 0, map2[i], 0, map[0].length);
                }
                drawMap2();
                restart=false;
                break;
            default:
                break;
        }
    }
    public void playerMove(int dir) {
        switch (dir) {
            case 1: //Go up
                if (map2[playerY - 1][playerX] == 0)//底線
                    return;
                if (map2[playerY - 1][playerX] == 2)//碰到火
                    return;
                if (map2[playerY - 1][playerX] == 3) {//碰到冰塊
                    if (map2[playerY - 2][playerX] == 0 || map2[playerY - 2][playerX] == 3 || map2[playerY - 2][playerX] == 5)
                        return;
                    iceMove(1, 3);
                }
                if (map2[playerY - 1][playerX] == 5) { //碰到冰塊
                    if (map2[playerY - 2][playerX] == 0 || map2[playerY - 2][playerX] == 3 || map2[playerY - 2][playerX] == 5)
                        return;
                    iceMove(1, 5);
                }
                map2[playerY][playerX] = 1;
                map2[playerY - 1][playerX] = 4;
                drawMap2();
                break;
            case 2: //Go left
                if (map2[playerY][playerX - 1] == 0)//底線
                    return;
                if (map2[playerY][playerX - 1] == 2)//碰到火
                    return;
                if (map2[playerY][playerX - 1] == 3) {//碰到冰塊
                    if (map2[playerY][playerX - 2] == 0 || map2[playerY][playerX - 2] == 3 || map2[playerY][playerX - 2] == 5)
                        return;
                    iceMove(2, 3);
                }
                if (map2[playerY][playerX - 1] == 5) { //碰到冰塊
                    if (map2[playerY][playerX - 2] == 0 || map2[playerY][playerX - 2] == 3 || map2[playerY][playerX - 2] == 5)
                        return;
                    iceMove(2, 5);
                }
                map2[playerY][playerX] = 1;
                map2[playerY][playerX - 1] = 4;
                drawMap2();
                break;
            case 3:
                if (map2[playerY + 1][playerX] == 0)
                    return;
                if (map2[playerY + 1][playerX] == 2)
                    return;
                if (map2[playerY + 1][playerX] == 3) {
                    if (map2[playerY + 2][playerX] == 0 || map2[playerY + 2][playerX] == 3 || map2[playerY + 2][playerX] == 5)
                        return;
                    iceMove(3, 3);
                }
                if (map2[playerY + 1][playerX] == 5) {
                    if (map2[playerY + 2][playerX] == 0 || map2[playerY + 2][playerX] == 3 || map2[playerY + 2][playerX] == 5)
                        return;
                    iceMove(3, 5);
                }
                map2[playerY][playerX] = 1;
                map2[playerY + 1][playerX] = 4;
                drawMap2();
                break;
            case 4:
                if (map2[playerY][playerX + 1] == 0)
                    return;
                if (map2[playerY][playerX + 1] == 2)
                    return;
                if (map2[playerY][playerX + 1] == 3) {//碰到冰塊
                    if (map2[playerY][playerX + 2] == 0 || map2[playerY][playerX + 2] == 3 || map2[playerY][playerX + 2] == 5)
                        return;
                    iceMove(4, 3);
                }
                if (map2[playerY][playerX + 1] == 5) { //碰到冰塊
                    if (map2[playerY][playerX + 2] == 0 || map2[playerY][playerX + 2] == 3 || map2[playerY][playerX + 2] == 5)
                        return;
                    iceMove(4, 5);
                }
                map2[playerY][playerX] = 1;
                map2[playerY][playerX + 1] = 4;
                drawMap2();
                break;
            default:
                break;
        }
    }
    public void iceMove(int dir, int type) {
        switch (type) {
            case 3:
                switch (dir) {
                    case 1: //Go up
                        iceY1 = playerY - 1;
                        iceX1 = playerX;
                        for (int i = playerY - 2; i >= 0; i--) {
                            if (map2[i][playerX] == 2) {//碰到火
                                firex=playerX;
                                firey=i;
                                map2[i][playerX] = 1;
                                map2[i+1][playerX] = 1;
                                iceY2=i;
                                iceX2=playerX;
                                fire=true;
                                break;
                            } else if ((map2[i][playerX] == 3 || map2[i][playerX] == 0 || map2[i][playerX] == 5)) {//碰到冰塊跟牆壁
                                map2[i + 1][playerX] = 3;
                                map2[playerY - 1][playerX] = 1;
                                iceY2 = i + 1;
                                iceX2 = playerX;
                                break;
                            } else {
                                map2[i + 1][playerX] = 1;
                                map2[i][playerX] = 3;
                            }
                        }
                        break;
                    case 2: //Go left
                        iceY1 = playerY;
                        iceX1 = playerX - 1;
                        for (int i = playerX - 2; i >= 0; i--) {
                            if (map2[playerY][i] == 2) {//碰到火
                                firex=i;
                                firey=playerY;
                                map2[playerY][i] = 1;
                                map2[playerY][i+1] = 1;
                                iceY2=playerY;
                                iceX2=i;
                                fire=true;
                                break;
                            } else if ((map2[playerY][i] == 3 || map2[playerY][i] == 0 || map2[playerY][i] == 5)) {//碰到冰塊跟牆壁
                                map2[playerY][i + 1] = 3;
                                map2[playerY][playerX - 1] = 1;
                                iceY2 = playerY;
                                iceX2 = i + 1;
                                break;
                            } else {
                                map2[playerY][i + 1] = 1;
                                map2[playerY][i] = 3;
                            }
                        }
                        break;
                    case 3: //Go down
                        iceY1 = playerY + 1;
                        iceX1 = playerX;
                        for (int i = playerY + 2; ; i++) {
                            if (map2[i][playerX] == 2) {//碰到火
                                firey=i;
                                firex=playerX;
                                map2[i][playerX] = 1;
                                map2[i - 1][playerX] = 1;
                                iceY2=i;
                                iceX2=playerX;
                                fire=true;
                                break;
                            } else if ((map2[i][playerX] == 3 || map2[i][playerX] == 0 || map2[i][playerX] == 5)) {//碰到冰塊跟牆壁
                                map2[i - 1][playerX] = 3;
                                map2[playerY + 1][playerX] = 1;
                                iceY2 = i - 1;
                                iceX2 = playerX;
                                break;
                            } else {
                                map2[i - 1][playerX] = 1;
                                map2[i][playerX] = 3;
                            }
                        }
                        break;
                    case 4: //Go right
                        iceY1 = playerY;
                        iceX1 = playerX + 1;
                        for (int i = playerX + 2; ; i++) {
                            if (map2[playerY][i] == 2) {//碰到火
                                firex=i;
                                firey=playerY;
                                map2[playerY][i] = 1;
                                map2[playerY][i - 1] = 1;
                                iceX2=i;
                                iceY2=playerY;
                                fire=true;
                                break;
                            } else if ((map2[playerY][i] == 3 || map2[playerY][i] == 0 || map2[playerY][i] == 5)) {//碰到冰塊跟牆壁
                                map2[playerY][i - 1] = 3;
                                map2[playerY][playerX + 1] = 1;
                                iceY2 = playerY;
                                iceX2 = i - 1;
                                break;
                            } else {
                                map2[playerY][i - 1] = 1;
                                map2[playerY][i] = 3;
                            }
                        }
                        break;
                    default:
                        break;
                }
                break;
            case 5:
                switch (dir) {
                    case 1: //Go up
                        iceY1 = playerY - 1;
                        iceX1 = playerX;
                        for (int i = playerY - 2; i >= 0; i--) {
                            if (map2[i][playerX] == 2) {//碰到火
                                map2[i][playerX] = 1;//fire->land
                                map2[i + 1][playerX] = 1;
                            } else if ((map2[i][playerX] == 3 || map2[i][playerX] == 0 || map2[i][playerX] == 5)) {//碰到冰塊跟牆壁
                                map2[i + 1][playerX] = 5;
                                map2[playerY - 1][playerX] = 1;
                                iceY2 = i + 1;
                                iceX2 = playerX;
                                break;
                            } else {
                                map2[i + 1][playerX] = 1;
                                map2[i][playerX] = 5;
                            }
                        }
                        break;
                    case 2: //Go left
                        iceY1 = playerY;
                        iceX1 = playerX - 1;
                        for (int i = playerX - 2; i >= 0; i--) {
                            if (map2[playerY][i] == 2) {//碰到火
                                map2[playerY][i] = 1;//fire->land
                                map2[playerY][i + 1] = 1;
                            } else if ((map2[playerY][i] == 3 || map2[playerY][i] == 0 || map2[playerY][i] == 5)) {//碰到冰塊跟牆壁
                                map2[playerY][i + 1] = 5;
                                map2[playerY][playerX - 1] = 1;
                                iceY2 = playerY;
                                iceX2 = i + 1;
                                break;
                            } else {
                                map2[playerY][i + 1] = 1;
                                map2[playerY][i] = 5;
                            }
                        }
                        break;
                    case 3:
                        iceY1 = playerY + 1;
                        iceX1 = playerX;
                        for (int i = playerY + 2; ; i++) {
                            if (map2[i][playerX] == 2) {//碰到火
                                map2[i][playerX] = 1;//fire->land
                                map2[i - 1][playerX] = 1;
                            } else if ((map2[i][playerX] == 3 || map2[i][playerX] == 0 || map2[i][playerX] == 5)) {//碰到冰塊跟牆壁
                                map2[i - 1][playerX] = 5;
                                map2[playerY + 1][playerX] = 1;
                                iceY2 = i - 1;
                                iceX2 = playerX;
                                break;
                            } else {
                                map2[i - 1][playerX] = 1;
                                map2[i][playerX] = 5;
                            }
                        }
                        break;
                    case 4:
                        iceY1 = playerY;
                        iceX1 = playerX + 1;
                        for (int i = playerX + 2; ; i++) {
                            if (map2[playerY][i] == 2) {//碰到火
                                map2[playerY][i] = 1;//fire->land
                                map2[playerY][i - 1] = 1;
                            } else if ((map2[playerY][i] == 3 || map2[playerY][i] == 0 || map2[playerY][i] == 5)) {//碰到冰塊跟牆壁
                                map2[playerY][i - 1] = 5;
                                map2[playerY][playerX + 1] = 1;
                                iceY2 = playerY;
                                iceX2 = i - 1;
                                break;
                            } else {
                                map2[playerY][i - 1] = 1;
                                map2[playerY][i] = 5;
                            }
                        }
                        break;
                    default:
                        break;
                }
                break;
            default:
                break;
        }
    }
    private void iceAnimation(int iceType ,int i,int j) {
        Image iceImage;
        ImageView ice;
        if (iceType == 3) {
            iceImage = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/image/ice.png")), tube, tube, false, false);
            ice = new ImageView(iceImage);
        } else {
            iceImage = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/image/Au.jpg")), tube, tube, false, false);
            ice = new ImageView(iceImage);
        }
        switch (direct) {
            case 1: //ice up
                pane.getChildren().add(ice);
                ice.setX(iceX1 * tube);
                ice.setY(iceY1 * tube);
                int sleep = 10;//ms 停幾秒
                Timeline t = new Timeline();
                KeyFrame kf = new KeyFrame(Duration.millis(sleep), new EventHandler<>() {
                    @Override
                    public void handle(ActionEvent event) {
                        ice.setY(ice.getY() - 10);
                        if (ice.getY() == tube * iceY2) {
                            pane.getChildren().remove(ice);
                            GridPane.setConstraints(ice, j, i);
                            gridpane.getChildren().add(ice);
                            t.pause();
                            if (fire) {
                                Image landImage = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/image/land.jpg")), tube, tube, false, false);
                                ImageView land = new ImageView(landImage);
                                GridPane.setConstraints(land, j, i);
                                gridpane.getChildren().add(land);
                                fire = false;
                            }
                        }
                    }
                });

                t.getKeyFrames().add(kf);
                t.setCycleCount(Timeline.INDEFINITE);
                t.play();

                break;
            case 3:
                pane.getChildren().add(ice);
                ice.setX(iceX1 * tube);
                ice.setY(iceY1 * tube);
                sleep = 10;//ms 停幾秒
                t = new Timeline();
                kf = new KeyFrame(Duration.millis(sleep), new EventHandler<>() {
                    @Override
                    public void handle(ActionEvent event) {
                        ice.setY(ice.getY() + 10);
                        if (ice.getY() == tube * iceY2) {
                            pane.getChildren().remove(ice);
                            GridPane.setConstraints(ice, j, i);
                            gridpane.getChildren().add(ice);
                            t.pause();
                            if (fire) {
                                Image landImage = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/image/land.jpg")), tube, tube, false, false);
                                ImageView land = new ImageView(landImage);
                                GridPane.setConstraints(land, j, i);
                                gridpane.getChildren().add(land);
                                fire = false;
                            }
                        }
                    }
                });
                t.getKeyFrames().add(kf);
                t.setCycleCount(Timeline.INDEFINITE);
                t.play();
                break;
            case 2:
                pane.getChildren().add(ice);
                ice.setX(iceX1 * tube);
                ice.setY(iceY1 * tube);
                sleep = 10;//ms 停幾秒
                t = new Timeline();
                kf = new KeyFrame(Duration.millis(sleep), new EventHandler<>() {
                    @Override
                    public void handle(ActionEvent event) {
                        ice.setX(ice.getX() - 10);
                        if (ice.getX() == tube * iceX2) {
                            pane.getChildren().remove(ice);
                            GridPane.setConstraints(ice, j, i);
                            gridpane.getChildren().add(ice);
                            t.pause();
                            if (fire) {
                                Image landImage = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/image/land.jpg")), tube, tube, false, false);
                                ImageView land = new ImageView(landImage);
                                GridPane.setConstraints(land, j, i);
                                gridpane.getChildren().add(land);
                                fire = false;
                            }
                        }
                    }
                });
                t.getKeyFrames().add(kf);
                t.setCycleCount(Timeline.INDEFINITE);
                t.play();
                break;
            case 4:
                pane.getChildren().add(ice);
                ice.setX(iceX1 * tube);
                ice.setY(iceY1 * tube);
                sleep = 10;//ms 停幾秒
                t = new Timeline();
                kf = new KeyFrame(Duration.millis(sleep), new EventHandler<>() {
                    @Override
                    public void handle(ActionEvent event) {
                        ice.setX(ice.getX() + 10);
                        if (ice.getX() == tube * iceX2) {
                            pane.getChildren().remove(ice);
                            GridPane.setConstraints(ice, j, i);
                            gridpane.getChildren().add(ice);
                            t.pause();
                            if (fire) {
                                Image landImage = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/image/land.jpg")), tube, tube, false, false);
                                ImageView land = new ImageView(landImage);
                                GridPane.setConstraints(land, j, i);
                                gridpane.getChildren().add(land);
                                fire = false;
                            }
                        }
                    }
                });
                t.getKeyFrames().add(kf);
                t.setCycleCount(Timeline.INDEFINITE);
                t.play();
                break;

        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        SetLevel();

    }



    private void SetLevel() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("PD2Project-master/src/sample/level.txt"));
            StringBuilder ib = new StringBuilder();
            String s;

            while (br.readLine() != null) {
                s="2";
                ib.append(s);
            }
            br.close();

            FileOutputStream fo = new FileOutputStream("PD2Project-master/src/sample/level.txt");
            fo.write(ib.toString().getBytes());
            fo.close();

        } catch (Exception e) {
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
            Level3Controller controller = loader.getController();
            controller.drawMap();
            prevStage.close();
            controller.setPrevStage(stage);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setPrevStage(Stage stage) {
        this.prevStage = stage;
    }

}
