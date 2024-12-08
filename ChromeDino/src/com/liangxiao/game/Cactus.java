package com.liangxiao.game;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.util.Objects;

public class Cactus {
    private Image cactusImage;
    private final Image[] cactusSImage;
    int x;
    int y;
    int distance;
    int size;
    public Cactus(int num) throws IOException {
        distance =  (int)(Math.random() * (600 - 150 + 1)) + 150;
        x = 600 + num * distance;
        size = (int)(Math.random() * (5 + 1)) ;
        switch (size){
            case 0:
            case 1:
            case 2:
                y = 52;
                break;
            case 3:
            case 4:
            case 5:
                y = 67;
                break;
            default:
                break;
        }

        cactusSImage = new Image[6];
        cactusSImage[0] = ImageIO.read(Objects.requireNonNull(getClass().getResource("cactus_large1.png")));
        cactusSImage[1] = ImageIO.read(Objects.requireNonNull(getClass().getResource("cactus_large2.png")));
        cactusSImage[2] = ImageIO.read(Objects.requireNonNull(getClass().getResource("cactus_large3.png")));
        cactusSImage[3] = ImageIO.read(Objects.requireNonNull(getClass().getResource("cactus_small1.png")));
        cactusSImage[4] = ImageIO.read(Objects.requireNonNull(getClass().getResource("cactus_small2.png")));
        cactusSImage[5] = ImageIO.read(Objects.requireNonNull(getClass().getResource("cactus_small3.png")));
        cactusImage = cactusSImage[size];
    }
    public void paint(Graphics g){
        g.drawImage(cactusImage,x,y,null);
    }
    public void move(int speed){
        x = x - speed;
        if (x <= -75){
            x = 600 + (int)(Math.random() * (25 + 1));
            size = (int)(Math.random() * (5 + 1)) ;
            switch (size){
                case 0:
                case 1:
                case 2:
                    y = 52;
                    break;
                case 3:
                case 4:
                case 5:
                    y = 67;
                    break;
                default:
                    break;
            }
            cactusImage = cactusSImage[size];
        }

    }
}
