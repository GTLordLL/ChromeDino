package com.liangxiao.game;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.util.Objects;

public class Pterodactyl {
    private Image pterodactylImage;
    private final Image[] pterodactylsImage;
    int x;
    int y;

    public Pterodactyl() throws IOException {
        x = (int)(Math.random() * (6000 - 1200 + 1)) + 1200;
        y = (int)(Math.random() * (50 + 1));
        pterodactylsImage = new Image[8];
        for (int i = 0; i<8;i+=2){
            pterodactylsImage[i] = ImageIO.read(Objects.requireNonNull(getClass().getResource("pterodactyl1.png")));
            pterodactylsImage[i+1] = ImageIO.read(Objects.requireNonNull(getClass().getResource("pterodactyl2.png")));
        }
        pterodactylImage = pterodactylsImage[0];
    }
    public void paint(Graphics g){
        g.drawImage(pterodactylImage,x,y,null);
    }
    double index = 0;
    public void fly(){
        index = index + 0.25;
        pterodactylImage = pterodactylsImage[(int) (index/8)%8];
    }
    public void move(int speed){
        x = x - speed;
        if (x <= -46){
            x = (int)(Math.random() * (8000 - 2000 + 1)) + 2000;
            y = (int)(Math.random() * (50 + 1));
        }
    }
}
