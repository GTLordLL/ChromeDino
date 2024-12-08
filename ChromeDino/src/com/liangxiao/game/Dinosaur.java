package com.liangxiao.game;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.util.Objects;

public class Dinosaur {
    private Image dinosaurImage;
    private final Image dieImage;
    private final Image[] dinosaursImage;
    private final Image[] jumpsImage;
    private final Image[] ducksImage;
    int x;
    int y;
    double v0;
    double speed;
    int g;
    double t;
    int hide = 0;

    public Dinosaur() throws IOException {
        x = 0;
        y = 55;
        v0 = 17;
        g = 1;
        t = 0.2;

        dinosaursImage = new Image[8];
        jumpsImage = new Image[2];
        ducksImage = new Image[8];

        for (int i = 0; i<8;i+=2){
            dinosaursImage[i] = ImageIO.read(Objects.requireNonNull(getClass().getResource("run1.png")));
            dinosaursImage[i+1] = ImageIO.read(Objects.requireNonNull(getClass().getResource("run2.png")));
        }
        jumpsImage[0] = ImageIO.read(Objects.requireNonNull(getClass().getResource("stand1.png")));
        jumpsImage[1] = ImageIO.read(Objects.requireNonNull(getClass().getResource("stand2.png")));

        for (int i = 0; i<8;i+=2){
            ducksImage[i] = ImageIO.read(Objects.requireNonNull(getClass().getResource("duck1.png")));
            ducksImage[i+1] = ImageIO.read(Objects.requireNonNull(getClass().getResource("duck2.png")));
        }
        dieImage = ImageIO.read(Objects.requireNonNull(getClass().getResource("die1.png")));

        dinosaurImage = jumpsImage[0];
    }
    public void paint(Graphics g){
        g.drawImage(dinosaurImage,x,y,null);
    }
    double index = 0;
    public void run(boolean duck){
        index = index + 0.25;
        if (y == 55){
            if (duck){
                dinosaurImage = ducksImage[(int) (index/8)%8];
                hide = 20;
            }
            else {
                dinosaurImage = dinosaursImage[(int) (index/8)%8];
            }
        }
    }
    public void jump(){
        double v0 = speed;
        double v = v0 - g*t;
        speed = v;
        double s = v0 * t - 0.5 * g * t * t;

        y = (int) (y - s);
        if (y >= 55){
            y = 55;
        }
        dinosaurImage = jumpsImage[0];
    }
    public void ju(){
        if (y == 55){
            speed = v0;
        }
    }
    public void gameStart(){
        dinosaurImage = jumpsImage[0];
    }

    public boolean gameOver(Cactus cactus1,Cactus cactus2,Pterodactyl pterodactyl){
        int c1 = 0;
        switch (cactus1.size){
            case 0:
                c1 = 25;
                break;
            case 1:
                c1 = 50;
                break;
            case 2:
                c1 = 75;
                break;
            case 3:
                c1 = 17;
                break;
            case 4:
                c1 = 34;
                break;
            case 5:
                c1 = 51;
                break;
            default:
                break;
        }
        int c2 = 0;
        switch (cactus1.size){
            case 0:
                c2 = 25;
                break;
            case 1:
                c2 = 50;
                break;
            case 2:
                c2 = 75;
                break;
            case 3:
                c2 = 17;
                break;
            case 4:
                c2 = 34;
                break;
            case 5:
                c2 = 51;
                break;
            default:
                break;
        }
        if (this.x + 22>= pterodactyl.x +5 && this.x + 22 <= pterodactyl.x + 46 -5){
            if (this.y + 20 >= pterodactyl.y +5 && this.y + 20 + hide<= pterodactyl.y + 40 -5){
                dinosaurImage = dieImage;
                return true;
            }
        }
        if ((this.x + 22 >= cactus1.x+5)&&(this.x +22<= cactus1.x + c1-5)){
            if (this.y + 23 >= cactus1.y-5){
                dinosaurImage = dieImage;
                return true;
            }
        }
        if ((this.x + 22 >= cactus2.x+5)&&(this.x +22<= cactus2.x + c2-5)){
            if (this.y + 23 >= cactus2.y-5){
                dinosaurImage = dieImage;
                return true;
            }
        }
        return false;
    }
}
