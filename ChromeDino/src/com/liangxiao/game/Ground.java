package com.liangxiao.game;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.util.Objects;

public class Ground {
    private final Image groundImage;
    int x;
    int y;
    int distance = 600;
    public Ground(int num) throws IOException {
        x = num * distance;
        y = 90;
        Image[] groundsImage = new Image[2];
        groundsImage[0] = ImageIO.read(Objects.requireNonNull(getClass().getResource("ground1.png")));
        groundsImage[1] = ImageIO.read(Objects.requireNonNull(getClass().getResource("ground2.png")));
        groundImage = groundsImage[num];

    }
    public void paint(Graphics g){
        g.drawImage(groundImage,x,y,null);

    }
    public void move(int speed){
        x = x - speed;
        if (x <= -600){
            x = 600;
        }
    }
}
