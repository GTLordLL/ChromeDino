package com.liangxiao.game;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.Objects;

public class World extends JPanel {
    Image bgWhiteImage;
    Image gameoverImage;
    Image restartImage;
    private Dinosaur dinosaur;
    private Ground ground1;
    private Ground ground2;
    private Cloud cloud1;
    private Cloud cloud2;
    private Cactus cactus1;
    private Cactus cactus2;
    private Pterodactyl pterodactyl;
    private Score score;
    private  boolean duck;
    private boolean start;
    private boolean over;
    private int speed;
    int point;
    int maxPoint;


    public void init() throws IOException {
        point = 0;
        duck = false;
        start = true;
        over = false;
        speed = 1;
        dinosaur = new Dinosaur();
        ground1 = new Ground(0);
        ground2 = new Ground(1);
        cloud1 = new Cloud(0);
        cloud2 = new Cloud(1);
        cactus1 = new Cactus(0);
        cactus2 = new Cactus(1);
        pterodactyl = new Pterodactyl();
        score = new Score();
    }

    public World() throws IOException {
        bgWhiteImage = ImageIO.read(Objects.requireNonNull(getClass().getResource("bgWhite.png")));
        gameoverImage = ImageIO.read(Objects.requireNonNull(getClass().getResource("gameOver.png")));
        restartImage = ImageIO.read(Objects.requireNonNull(getClass().getResource("restart.png")));

        init();
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(bgWhiteImage,0,0,null);
        ground1.paint(g);
        ground2.paint(g);
        cloud1.paint(g);
        cloud2.paint(g);
        cactus1.paint(g);
        cactus2.paint(g);
        pterodactyl.paint(g);
        score.paint(g);
        dinosaur.paint(g);
        score.paintMax(g,maxPoint);

        if (over){
            g.drawImage(gameoverImage,204,10,null);
            g.drawImage(restartImage,282,40,null);
        }
    }

    public void action(){
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();
                if (keyCode == KeyEvent.VK_SPACE){
                    System.out.println("SPACE Pressed");
                    start = false;
                    dinosaur.ju();
                    if (over){
                        try {
                            score.save(point/10);
                            System.out.println("Get Point: "+point/10);
                            maxPoint = score.getMaxScore();
                            System.out.println("MAX Point: "+maxPoint);
                            init();
                            over = false;
                            dinosaur.gameStart();
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                }
                if (keyCode == KeyEvent.VK_DOWN){
                    duck = true;
                }
            }
            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    System.out.println("ARROW DOWN Released");
                    duck = false;
                }
            }
        });
        // 设置焦点策略，使 JPanel 能够接收键盘事件
        setFocusable(true);
        requestFocusInWindow();

        while (true){
            repaint();// 重新绘制，无限刷新

            if (!start && !over){
                ground1.move(speed);
                ground2.move(speed);
                cloud1.move(speed);
                cloud2.move(speed);
                cactus1.move(speed);
                cactus2.move(speed);
                pterodactyl.fly();
                pterodactyl.move(speed+1);

                dinosaur.jump();
                dinosaur.run(duck);
                point = point + speed;

                if (point/10 >= 500 && speed == 1){
                    speed++;
                }
                score.count(point/10);
            }
            if (dinosaur.gameOver(cactus1,cactus2,pterodactyl)){
                over = true;
            }


            try {
                Thread.sleep(3);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }


    }
    public static void main(String[] args) throws IOException {
        JFrame frame = new JFrame();

        World world = new World();

        frame.add(world);
        frame.setSize(600,150);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setTitle("T-Rex Chrome Dino Game");

        // 显示窗口
        frame.setVisible(true);
        world.action();
    }
}
