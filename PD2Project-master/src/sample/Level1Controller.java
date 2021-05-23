package sample;


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
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.stage.Stage;

import java.io.*;

public class Level1Controller implements Initializable {

    @FXML
    private GridPane gridpane;
    int[][] map = new int[][]{
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
            {0, 8, 1, 1, 1, 1, 1, 9, 3, 1, 0},
            {0, 1, 1, 1, 1, 1, 1, 5, 1, 1, 0},
            {0, 8, 1, 1, 1, 1, 3, 1, 3, 1, 0},
            {0, 1, 1, 1, 1, 2, 1, 1, 1, 1, 0},
            {0, 1, 1, 1, 3, 1, 1, 1, 1, 1, 0},
            {0, 1, 1, 3, 1, 1, 1, 1, 1, 1, 0},
            {0, 1, 3, 1, 4, 1, 1, 1, 1, 1, 0},
            {0, 7, 1, 1, 1, 1, 1, 1, 1, 6, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};
    int[][] map2 = new int[][]{
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
            {0, 8, 1, 1, 1, 1, 1, 9, 3, 1, 0},
            {0, 1, 1, 1, 1, 1, 1, 5, 1, 1, 0},
            {0, 8, 1, 1, 1, 1, 3, 1, 3, 1, 0},
            {0, 1, 1, 1, 1, 2, 1, 1, 1, 1, 0},
            {0, 1, 1, 1, 3, 1, 1, 1, 1, 1, 0},
            {0, 1, 1, 3, 1, 1, 1, 1, 1, 1, 0},
            {0, 1, 3, 1, 4, 1, 1, 1, 1, 1, 0},
            {0, 7, 1, 1, 1, 1, 1, 1, 1, 6, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};
    int[][] map3 = new int[][]{
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
            {0, 8, 1, 1, 1, 1, 1, 9, 3, 1, 0},
            {0, 1, 1, 1, 1, 1, 1, 5, 1, 1, 0},
            {0, 8, 1, 1, 1, 1, 3, 1, 3, 1, 0},
            {0, 1, 1, 1, 1, 2, 1, 1, 1, 1, 0},
            {0, 1, 1, 1, 3, 1, 1, 1, 1, 1, 0},
            {0, 1, 1, 3, 1, 1, 1, 1, 1, 1, 0},
            {0, 1, 3, 1, 4, 1, 1, 1, 1, 1, 0},
            {0, 7, 1, 1, 1, 1, 1, 1, 1, 6, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};
    private final int mapHeight = map.length - 2;
    private final int mapWidth = map[1].length - 2;
    private int playerX;
    private int playerY;
    private boolean iceOnPlayer=false;
    public void drawMap() {
        for (int i = 0; i < map.length; i++) {//h
            for (int j = 0; j < map[0].length; j++) {//w
                int tube = 50;
                switch (map[i][j]) {
                    case 1://road
                        Image landImage = new Image(getClass().getResourceAsStream("/image/land.jpg"), tube, tube, false, false);
                        ImageView land = new ImageView(landImage);
                        GridPane.setConstraints(land, j, i);
                        gridpane.getChildren().add(land);
                        break;
                    case 2://fire
                        Image fireImage = new Image(getClass().getResourceAsStream("/image/fire.png"), tube, tube, false, false);
                        ImageView fire = new ImageView(fireImage);
                        GridPane.setConstraints(fire, j, i);
                        gridpane.getChildren().add(fire);
                        break;
                    case 3://ice
                        Image iceImage = new Image(getClass().getResourceAsStream("/image/ice.png"), tube, tube, false, false);
                        ImageView ice = new ImageView(iceImage);
                        GridPane.setConstraints(ice, j, i);
                        gridpane.getChildren().add(ice);
                        break;
                    case 4://player
                        Image playerImage = new Image(getClass().getResourceAsStream("/image/player.png"), tube, tube, false, false);
                        ImageView player = new ImageView(playerImage);
                        GridPane.setConstraints(player, j, i);
                        gridpane.getChildren().add(player);
                        playerY = i;
                        playerX = j;
                        break;
                    case 5:
                        Image goldIceImage = new Image(getClass().getResourceAsStream("/image/Au.jpg"), tube, tube, false, false);
                        ImageView goldIce = new ImageView(goldIceImage);
                        GridPane.setConstraints(goldIce, j, i);
                        gridpane.getChildren().add(goldIce);
                        break;
                    case 9://ArrowLeft
                        Image ArrowLeft = new Image(getClass().getResourceAsStream("/image/arrowLeft.png"), tube, tube, false, false);
                        ImageView ArrowL = new ImageView(ArrowLeft);
                        GridPane.setConstraints(ArrowL, j, i);
                        gridpane.getChildren().add(ArrowL);
                        break;
                    case 6://ArrowUp
                        Image ArrowUp = new Image(getClass().getResourceAsStream("/image/arrowUp.png"), tube, tube, false, false);
                        ImageView ArrowU = new ImageView(ArrowUp);
                        GridPane.setConstraints(ArrowU, j, i);
                        gridpane.getChildren().add(ArrowU);
                        break;
                    case 7://ArrowRight
                        Image ArrowRight = new Image(getClass().getResourceAsStream("/image/arrowRight.png"), tube, tube, false, false);
                        ImageView ArrowR = new ImageView(ArrowRight);
                        GridPane.setConstraints(ArrowR, j, i);
                        gridpane.getChildren().add(ArrowR);
                        break;
                    case 8://ArrowDown
                        Image ArrowDown = new Image(getClass().getResourceAsStream("/image/arrowDown.png"), tube, tube, false, false);
                        ImageView ArrowD = new ImageView(ArrowDown);
                        GridPane.setConstraints(ArrowD, j, i);
                        gridpane.getChildren().add(ArrowD);
                        break;
                    case 0:
                        Image wallImage = new Image(getClass().getResourceAsStream("/image/wall.png"), tube, tube, false, false);
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
                            Image landImage = new Image(getClass().getResourceAsStream("/image/land.jpg"), tube, tube, false, false);
                            ImageView land = new ImageView(landImage);
                            GridPane.setConstraints(land, j, i);
                            gridpane.getChildren().add(land);
                            map[i][j] = map2[i][j];
                        }
                        break;
                    case 2://fire
                        if (map2[i][j] != map[i][j]) {
                            Image fireImage = new Image(getClass().getResourceAsStream("/image/fire.png"), tube, tube, false, false);
                            ImageView fire = new ImageView(fireImage);
                            GridPane.setConstraints(fire, j, i);
                            gridpane.getChildren().add(fire);
                            map[i][j] = map2[i][j];
                        }
                        break;
                    case 3://ice
                        if (map2[i][j] != map[i][j]) {
                            Image iceImage = new Image(getClass().getResourceAsStream("/image/ice.png"), tube, tube, false, false);
                            ImageView ice = new ImageView(iceImage);
                            GridPane.setConstraints(ice, j, i);
                            gridpane.getChildren().add(ice);
                            map[i][j] = map2[i][j];
                        }
                        break;
                    case 4://player
                        if (map2[i][j] != map[i][j]) {
                            Image playerImage = new Image(getClass().getResourceAsStream("/image/player.png"), tube, tube, false, false);
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
                            Image goldIceImage = new Image(getClass().getResourceAsStream("/image/Au.jpg"), tube, tube, false, false);
                            ImageView goldIce = new ImageView(goldIceImage);
                            GridPane.setConstraints(goldIce, j, i);
                            gridpane.getChildren().add(goldIce);
                            map[i][j] = map2[i][j];
                        }
                        break;
                    case 9://ArrowLeft
                        if(map2[i][j] != map[i][j]) {
                            Image ArrowLeft = new Image(getClass().getResourceAsStream("/image/arrowLeft.png"), tube, tube, false, false);
                            ImageView ArrowL = new ImageView(ArrowLeft);
                            GridPane.setConstraints(ArrowL, j, i);
                            gridpane.getChildren().add(ArrowL);
                            map[i][j] = map2[i][j];
                        }
                        break;
                    case 6://ArrowUp
                        if(map2[i][j] != map[i][j]) {
                            Image ArrowUp = new Image(getClass().getResourceAsStream("/image/arrowUp.png"), tube, tube, false, false);
                            ImageView ArrowU = new ImageView(ArrowUp);
                            GridPane.setConstraints(ArrowU, j, i);
                            gridpane.getChildren().add(ArrowU);
                            map[i][j] = map2[i][j];
                        }
                        break;
                    case 7://ArrowRight
                        if(map2[i][j] != map[i][j]) {
                            Image ArrowRight = new Image(getClass().getResourceAsStream("/image/arrowRight.png"), tube, tube, false, false);
                            ImageView ArrowR = new ImageView(ArrowRight);
                            GridPane.setConstraints(ArrowR, j, i);
                            gridpane.getChildren().add(ArrowR);
                            map[i][j] = map2[i][j];
                        }
                        break;
                    case 8://ArrowDown
                        if(map2[i][j] != map[i][j]) {
                            Image ArrowDown = new Image(getClass().getResourceAsStream("/image/arrowDown.png"), tube, tube, false, false);
                            ImageView ArrowD = new ImageView(ArrowDown);
                            GridPane.setConstraints(ArrowD, j, i);
                            gridpane.getChildren().add(ArrowD);
                            map[i][j] = map2[i][j];
                        }
                        break;
                    case 0:
                        if (map2[i][j] != map[i][j]) {
                            Image wallImage = new Image(getClass().getResourceAsStream("/image/wall.png"), tube, tube, false, false);
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
                int icetype=0;
                if(map2[playerY-1][playerX]==0)//底線
                    return;
                if(map2[playerY-1][playerX]==2)//碰到火
                    return;
                if(map2[playerY-1][playerX]>=6 &&map2[playerY-1][playerX]<=9) {
                    return;
                }
                if(map2[playerY-1][playerX]==3){//碰到冰塊
                    if(map2[playerY-2][playerX]==0||map2[playerY-2][playerX]==3)
                        return;
                    if(map2[playerY-2][playerX]==5)
                        return;
                    IceMove(1,3);
                    icetype=3;
                }
                if(map2[playerY-1][playerX]==5){//碰到冰塊
                    if(map2[playerY-2][playerX]==0||map2[playerY-2][playerX]==5)
                        return;
                    if(map2[playerY-2][playerX]==3)
                        return;
                    IceMove(1,5);
                    icetype=5;
                }
                if(iceOnPlayer) {
                    map2[playerY][playerX] = icetype;
                    iceOnPlayer=false;
                }
                else {
                    map2[playerY][playerX] = 1;
                }
                map2[playerY-1][playerX] = 4;
                System.out.println("up");
                drawMap2();
//                if(playerY.equals(GridPane.getRowIndex(ice)) && playerX.equals(GridPane.getColumnIndex(ice))) {
//
//                    if (GridPane.getColumnIndex(fire).equals(GridPane.getColumnIndex(ice)) && GridPane.getRowIndex(fire) < GridPane.getRowIndex(ice)) {
//
//                        fire.setVisible(false);
//                        ice.setVisible(false);
//                    }
//                    else {
//                        GridPane.setRowIndex(ice, 1);
//                    }
//                }
                break;
            case A:
                icetype=0;
                if (map2[playerY][playerX - 1] == 0)
                    return;
                if (map2[playerY][playerX - 1] == 2)
                    return;
                if (map2[playerY][playerX - 1] >= 6 &&map2[playerY][playerX - 1] <= 9)
                    return;
//                if(playerY.equals(GridPane.getRowIndex(fire)) &&playerX==GridPane.getColumnIndex(fire)+1&&fire.isVisible())//邊線
//                    return;
//                GridPane.setColumnIndex(player,playerX-1);
                if (map2[playerY][playerX - 1] == 3) {//碰到冰塊
                    if (map2[playerY][playerX - 2] == 0 || map2[playerY][playerX - 2] == 3)
                        return;
                    if (map2[playerY][playerX - 2] == 5)
                        return;
                    IceMove(2,3);
                    icetype=3;
                }
                if (map2[playerY][playerX - 1] == 5) {//碰到冰塊
                    if (map2[playerY][playerX - 2] == 0 || map2[playerY][playerX - 2] == 3)
                        return;
                    if (map2[playerY][playerX - 2] == 5)
                        return;
                    IceMove(2,5);
                    icetype=5;
                }
                map2[playerY][playerX - 1] = 4;
                if(iceOnPlayer) {
                    map2[playerY][playerX] = icetype;
                    iceOnPlayer=false;
                }
                else {
                    map2[playerY][playerX] = 1;
                }
                drawMap2();
                System.out.println("left");

//                if(playerY.equals(GridPane.getRowIndex(ice)) && playerX.equals(GridPane.getColumnIndex(ice))) {
//                    if (GridPane.getRowIndex(fire).equals(GridPane.getRowIndex(ice)) && GridPane.getColumnIndex(fire) < GridPane.getColumnIndex(ice)) {
//                        fire.setVisible(false);
//                        ice.setVisible(false);
//                    }
//                    else {
//                        GridPane.setColumnIndex(ice, 1);
//                    }
//                }
                break;
            case S:
                icetype=0;
                if (map2[playerY + 1][playerX] == 0)
                    return;
                if (map2[playerY + 1][playerX] == 2)
                    return;
                if (map2[playerY + 1][playerX] >= 6 &&map2[playerY + 1][playerX] <= 9)
                    return;
//                if (playerY==GridPane.getRowIndex(fire)-1&& playerX.equals(GridPane.getColumnIndex(fire)) &&fire.isVisible())
//                    return;
//                GridPane.setRowIndex(player,playerY+1);
                if (map2[playerY + 1][playerX] == 3) {//碰到冰塊
                    if (map2[playerY + 2][playerX] == 0 || map2[playerY + 2][playerX] == 3)
                        return;
                    if (map2[playerY + 2][playerX] == 5)
                        return;
                    IceMove(3,3);
                    icetype=3;
                }
                if (map2[playerY + 1][playerX] == 5) {//碰到冰塊
                    if (map2[playerY + 2][playerX] == 0 || map2[playerY + 2][playerX] == 3)
                        return;
                    if (map2[playerY + 2][playerX] == 5)
                        return;
                    IceMove(3,5);
                    icetype=5;
                }
                if(iceOnPlayer) {
                    map2[playerY][playerX] = icetype;
                    iceOnPlayer=false;
                }
                else {
                    map2[playerY][playerX] = 1;
                }
                map2[playerY + 1][playerX] = 4;
                drawMap2();
                System.out.println("down");
//                if(playerY.equals(GridPane.getRowIndex(ice)) && playerX.equals(GridPane.getColumnIndex(ice))) {
//                    if (GridPane.getColumnIndex(fire).equals(GridPane.getColumnIndex(ice)) && GridPane.getRowIndex(fire) > GridPane.getRowIndex(ice)) {
//                        // && GridPane.getRowIndex(fire) < GridPane.getRowIndex(ice)
//                        fire.setVisible(false);
//                        ice.setVisible(false);
//                    }
//                    else {
//                        GridPane.setRowIndex(ice, mapHeight);
//                    }
//                }
                break;
            case D:
                icetype=0;
                if (map2[playerY][playerX + 1] == 0)
                    return;
                if (map2[playerY][playerX + 1] == 2)
                    return;
                if (map2[playerY][playerX + 1] >= 6&& map2[playerY][playerX + 1] <= 9)
                    return;
//                if(playerY.equals(GridPane.getRowIndex(fire)) &&playerX==GridPane.getColumnIndex(fire)-1&&fire.isVisible())//邊線
//                    return;
                if (map2[playerY][playerX + 1] == 3) {//碰到冰塊
                    if (map2[playerY][playerX + 2] == 0 || map2[playerY][playerX + 2] == 3)
                        return;
                    if (map2[playerY][playerX + 2] == 5)
                        return;
                    IceMove(4,3);
                    icetype=3;
                }
                if (map2[playerY][playerX + 1] == 5) {//碰到冰塊
                    if (map2[playerY][playerX + 2] == 0 || map2[playerY][playerX + 2] == 5)
                        return;
                    if (map2[playerY][playerX + 2] == 5)
                        return;
                    IceMove(4,5);
                    icetype=5;
                }
                map2[playerY][playerX + 1] = 4;
                if(iceOnPlayer) {
                    map2[playerY][playerX] = icetype;
                    iceOnPlayer=false;
                }
                else {
                    map2[playerY][playerX] = 1;
                }
                drawMap2();
//                GridPane.setColumnIndex(player,playerX+1);
                System.out.println("right");
//                if(playerY.equals(GridPane.getRowIndex(ice)) && playerX.equals(GridPane.getColumnIndex(ice))) {
//                    if (GridPane.getRowIndex(fire).equals(GridPane.getRowIndex(ice)) && GridPane.getColumnIndex(fire) > GridPane.getColumnIndex(ice)) {
//                        fire.setVisible(false);
//                        ice.setVisible(false);
//                    }
//                    else {
//                        GridPane.setColumnIndex(ice, mapWidth);
//                    }
//                }
                break;
            case R: //重新開始
                for (int i = 1; i <= 9; i++){
                    for (int j = 1; j <= 9; j++){
                        map2[i][j]=map3[i][j];
                        /*if (10 - j == i && i != j && j <= 8 && j >= 2){
                        if (i == 8 && j == 2)
                                map2[i][j] = 5;
                            else
                                map2[i][j] = 3;
                        }
                        else if (i == j && i == 5){
                            map2[i][j] = 2;
                        }
                        else if (i == 8 && j == 4){
                            map2[i][j] = 4;
                        }
                        else {
                            map2[i][j] = 1;
                        }*/
                    }
                }
                drawMap2();
                break;
            default:
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
            StringBuffer ib = new StringBuffer();
            String s;

            while ((s = br.readLine()) != null) {
                s="1";
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
    private void ChangeDirect(int tempX,int tempY,int Direction,int IceType) {
        switch (Direction){
            case 9://左
                map2[tempY][tempX]=9;
                int temp=0;
                boolean changeDirection=false;
                for (int i = tempX; i >= 1; i--) {
                    if (map2[tempY][i-1] == 2) {
                        if(IceType==3) {
                            map2[tempY][i] = 1;
                            map2[tempY][i-1] = 1;
                            break;
                        }
                        else {
                            map2[tempY][i-1]=1;
                        }
                    }
                    if ((map2[tempY][i-1] == 3 || map2[tempY][i-1] == 0) && i != tempX) {//冰塊跟牆壁(還沒寫)
                        System.out.println("YES");
                        map2[tempY][i] = IceType;
                        break;
                    }
                    if (map2[tempY][i-1] == 5 && i != tempX) {//冰塊跟牆壁(還沒寫)
                        System.out.println("YES");
                        map2[tempY][i] = IceType;
                        break;
                    }
                    if (map2[tempY][i-1] == 4 && map2[tempY][i-2]==3) {//冰塊跟牆壁(還沒寫)
                        iceOnPlayer=true;
                        break;
                    }
                    if (map2[tempY][i-1] == 4 && map2[tempY][i-2]==0) {//冰塊跟牆壁(還沒寫)
                        iceOnPlayer=true;
                        break;
                    }
                    if (map2[tempY][i-1] == 4 && map2[tempY][i-2]==5) {//冰塊跟牆壁(還沒寫)
                        iceOnPlayer=true;
                        break;
                    }
                    if (map2[tempY][i-1] == 4 &&map2[tempY][i-2]==2) {//冰塊跟牆壁(還沒寫)
                        map2[tempY][i-2] = 1;
                        break;
                    }
                    if(map2[tempY][i-1]>=6 && map2[tempY][i-1]<=9) {
                        temp=i-1;
                        changeDirection=true;
                        break;
                    }
                }
                if(changeDirection) {
                    ChangeDirect(temp,tempY,map2[tempY][temp],IceType);
                }

                break;
            case 6://上
                map2[tempY][tempX]=6;
                temp=0;
                changeDirection=false;
                for (int i = tempY; i >= 1; i--) {
                    if (map2[i-1][tempX] == 2) {
                        if(IceType==3) {
                            map2[i][tempX] = 1;
                            map2[i -1][tempX] = 1;
                            break;
                        }
                        else {
                            map2[i-1][tempX]=1;
                        }
                    }
                    if ((map2[i-1][tempX] == 3 || map2[i-1][tempX] == 0) && i != tempY) {//冰塊跟牆壁(還沒寫)
                        System.out.println("YES");
                        map2[i][tempX] = IceType;
                        break;
                    }
                    if (map2[i-1][tempX] == 5 && i != tempY) {//冰塊跟牆壁(還沒寫)
                        System.out.println("YES");
                        map2[i][tempX] = IceType;
                        break;
                    }
                    if (map2[i-1][tempX] == 4 && map2[i-2][tempX] == 0) {//冰塊跟牆壁(還沒寫)
                        iceOnPlayer=true;
                        break;
                    }
                    if (map2[i-1][tempX] == 4 && map2[i-2][tempX] == 3) {//冰塊跟牆壁(還沒寫)
                        iceOnPlayer=true;
                        break;
                    }
                    if (map2[i-1][tempX] == 4 && map2[i-2][tempX] == 5) {//冰塊跟牆壁(還沒寫)
                        iceOnPlayer=true;
                        break;
                    }
                    if (map2[i-1][tempX] == 4 && map2[i-2][tempX] == 2) {//冰塊跟牆壁(還沒寫)
                        map2[i-2][tempX] = 1;
                        break;
                    }
                    if(map2[i-1][tempX]>=6 && map2[i-1][tempX] <=9) {
                        temp=i-1;
                        changeDirection=true;
                        break;
                    }
                }
                if(changeDirection) {
                    ChangeDirect(tempX,temp,map2[temp][tempX],IceType);
                }
                break;
            case 7://右
                map2[tempY][tempX]=7;
                temp=0;
                changeDirection=false;
                for (int i = tempX;i <= mapWidth; i++) {
                    if (map2[tempY][i+1] == 2) {
                        if(IceType==3) {
                            map2[playerY][i] = 1;
                            map2[playerY][i + 1] = 1;
                            break;
                        }
                        else {
                            map2[playerY][i+1] = 1;
                        }
                    }
                    if ((map2[tempY][i+1] == 3 || map2[tempY][i+1] == 0) && i != tempX) {//冰塊跟牆壁(還沒寫)
                        System.out.println("YES");
                        map2[tempY][i] = IceType;
                        break;
                    }
                    if (map2[tempY][i+1] == 5 && i != tempX) {//冰塊跟牆壁(還沒寫)
                        System.out.println("YES");
                        map2[tempY][i] = IceType;
                        break;
                    }
                    if (map2[tempY][i+1] == 4 &&map2[tempY][i+2]==3) {//冰塊跟牆壁(還沒寫)
                        iceOnPlayer=true;
                        break;
                    }
                    if (map2[tempY][i+1] == 4 &&map2[tempY][i+2]==0) {//冰塊跟牆壁(還沒寫)
                        iceOnPlayer=true;
                        break;
                    }
                    if (map2[tempY][i+1] == 4 &&map2[tempY][i+2]==5) {//冰塊跟牆壁(還沒寫)
                        iceOnPlayer=true;
                        break;
                    }
                    if (map2[tempY][i+1] == 4 &&map2[tempY][i+2]==2) {//冰塊跟牆壁(還沒寫)
                        map2[tempY][i+2] = 1;
                        break;
                    }
                    if(map2[tempY][i+1]>=6 && map2[tempY][i+1]<=9) {
                        temp=i+1;
                        changeDirection=true;
                        break;
                    }
                }
                if(changeDirection) {
                    ChangeDirect(temp,tempY,map2[tempY][temp],IceType);
                }
                break;
            case 8://下
                map2[tempY][tempX]=8;
                temp=0;
                changeDirection=false;
                for (int i = tempY; i <= mapHeight; i++) {
                    if (map2[i+1][tempX] == 2) {
                        if(IceType==3) {
                            map2[i][tempX] = 1;
                            map2[i + 1][tempX] = 1;
                            break;
                        }
                        else {
                            map2[i+1][tempX] = 1;
                        }
                    }
                    if ((map2[i+1][tempX] == 3 || map2[i+1][tempX] == 0) && i != tempY) {//冰塊跟牆壁(還沒寫)
                        System.out.println("YES");
                        map2[i][tempX] = IceType;
                        break;
                    }
                    if (map2[i+1][tempX] == 5 && i != tempY) {//冰塊跟牆壁(還沒寫)
                        System.out.println("YES");
                        map2[i][tempX] = IceType;
                        break;
                    }
                    if (map2[i+1][tempX] == 4 &&map2[i+2][tempX]==3) {//冰塊跟牆壁(還沒寫)
                        iceOnPlayer=true;
                        break;
                    }
                    if (map2[i+1][tempX] == 4 &&map2[i+2][tempX]==0) {//冰塊跟牆壁(還沒寫)
                        iceOnPlayer=true;
                        break;
                    }
                    if (map2[i+1][tempX] == 4 &&map2[i+2][tempX]==5) {//冰塊跟牆壁(還沒寫)
                        iceOnPlayer=true;
                        break;
                    }
                    if (map2[i+1][tempX] == 4 &&map2[i+2][tempX]==2) {//冰塊跟牆壁(還沒寫)
                        map2[i+2][tempX] = 1;
                        break;
                    }
                    if(map2[i+1][tempX]>=6 && map2[i+1][tempX] <=9) {
                        temp=i+1;
                        changeDirection=true;
                        break;
                    }
                }
                if(changeDirection) {
                    ChangeDirect(tempX,temp,map2[temp][tempX],IceType);
                }
                break;
            default:
                break;

        }
    }
    private void IceMove(int dir,int Icetype) {
        switch (dir) {
            case 1://w
                int temp=0;
                boolean changeDirection=false;
                for(int i=playerY-1;i>=1;i--){
                    if(map2[i][playerX]==2) {//冰塊碰到火
                        if(Icetype==3) {
                            map2[i][playerX] = 1;
                            map2[i + 1][playerX] = 1;
                            break;
                        }
                        else {
                            map2[i][playerX]=1;
                        }
                    }

                    if(map2[i][playerX]==5&&i!=playerY-1) {//黃金
                        map2[i + 1][playerX] = Icetype;
                        break;
                    }
                    if((map2[i][playerX]==3||map2[i][playerX]==0)&&i!=playerY-1){//冰塊跟牆壁
                        map2[i+1][playerX]=Icetype;
                        break;
                    }
                    if(map2[i][playerX]>=6 && map2[i][playerX]<=9) {
                        temp=i;
                        changeDirection=true;
                        map2[i+1][playerX]=1;
                        break;
                    }
                    map2[i+1][playerX]=1;
                    map2[i][playerX]=Icetype;
                }
                if(changeDirection) {
                    ChangeDirect(playerX,temp,map2[temp][playerX],Icetype);
                }
                break;
            case 2://a
                temp=0;
                changeDirection=false;
                for (int i = playerX - 1; i >= 1; i--) {
                    if (map2[playerY][i] == 2) {
                        if(Icetype==3) {
                            map2[playerY][i] = 1;
                            map2[playerY][i+1] = 1;
                            break;
                        }
                        else {
                            map2[playerY][i]=1;
                        }
                    }
                    if(map2[playerY][i] == 5&& i != playerX - 1) {
                        map2[playerY][i + 1] = Icetype;
                    }
                    if ((map2[playerY][i] == 3 || map2[playerY][i] == 0) && i != playerX - 1) {//冰塊跟牆壁(還沒寫)
                        map2[playerY][i + 1] = Icetype;
                        break;
                    }
                    if(map2[playerY][i]>=6 &&map2[playerY][i]<=9) {
                        temp=i;
                        changeDirection=true;
                        map2[playerY][i + 1] = 1;
                        break;
                    }
                    map2[playerY][i + 1] = 1;
                    map2[playerY][i] = Icetype;
                }
                if(changeDirection) {
                    ChangeDirect(temp,playerY,map2[playerY][temp],Icetype);
                }
                break;
            case 3://s
                temp=0;
                changeDirection=false;
                for (int i = playerY + 1; i <= mapHeight; i++) {
                    if (map2[i][playerX] == 2) {
                        if(Icetype==3) {
                            map2[i][playerX] = 1;
                            map2[i - 1][playerX] = 1;
                            break;
                        }
                        else {
                            map2[i][playerX] = 1;
                        }
                    }
                    if (map2[i][playerX] ==5 && i != playerY + 1) {//冰塊跟牆壁(還沒寫)
                        map2[i - 1][playerX] = Icetype;
                        break;
                    }
                    if ((map2[i][playerX] == 3 || map2[i][playerX] == 0) && i != playerY + 1) {//冰塊跟牆壁(還沒寫)
                        map2[i - 1][playerX] = Icetype;
                        break;
                    }
                    if(map2[i][playerX]>=6 && map2[i][playerX]<=9) {
                        temp=i;
                        changeDirection=true;
                        map2[i - 1][playerX] = 1;
                        break;
                    }

                    map2[i - 1][playerX] = 1;
                    map2[i][playerX] = Icetype;
                }
                if(changeDirection) {
                    ChangeDirect(playerX,temp,map2[temp][playerX],Icetype);
                }
                break;
            case 4:
                temp=0;
                changeDirection=false;
                for (int i = playerX + 1; i <= mapWidth; i++) {
                    if (map2[playerY][i] == 2) {
                        if(Icetype==3) {
                            map2[playerY][i] = 1;
                            map2[playerY][i - 1] = 1;
                            break;
                        }
                        else {
                            map2[playerY][i] = 1;
                        }
                    }
                    if (map2[playerY][i] == 5 && i != playerX + 1) {
                        map2[playerY][i - 1] = Icetype;
                        break;
                    }
                    if ((map2[playerY][i] == 3 || map2[playerY][i] == 0) && i != playerX + 1) {
                        map2[playerY][i - 1] = Icetype;
                        break;
                    }
                    if(map2[playerY][i]>=6 &&map2[playerY][i]<=9) {
                        temp=i;
                        changeDirection=true;
                        map2[playerY][i - 1] = 1;
                        break;
                    }
                    map2[playerY][i - 1] = 1;
                    map2[playerY][i] = Icetype;
                }
                if(changeDirection) {
                    ChangeDirect(temp,playerY,map2[playerY][temp],Icetype);
                }
                break;
        }
    }
}
