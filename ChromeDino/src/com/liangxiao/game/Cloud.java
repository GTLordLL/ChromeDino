package com.liangxiao.game;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.util.Objects;

public class Cloud {
    private final Image cloudImage;
    int x;
    int y;
    int distance;
    public Cloud(int num) throws IOException {
        distance =  (int)(Math.random() * (600 - 150 + 1)) + 150;
        x = 600 + num * distance;
        y = (int)(Math.random() * (30 + 1)) ;
        cloudImage = ImageIO.read(Objects.requireNonNull(getClass().getResource("cloud.png")));
    }
    public void paint(Graphics g){
        g.drawImage(cloudImage,x,y,null);
    }
    public void move(int speed){
        x = x - speed;
        if (x <= -46){
            x = 600 + (int)(Math.random() * (100 + 1));
            y = (int)(Math.random() * (30 + 1));
        }
    }
}
