package SubImage;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class SubImage {
    public static void main(String[] args) throws IOException {
        BufferedImage bufferedImage = ImageIO.read(new File("D:/IEDAproject/Dinosaur/src/com/liangxiao/game"));

        BufferedImage background1 = bufferedImage.getSubimage(2,54,600,12);
        ImageIO.write(background1,"png",new File(""));
        BufferedImage background2 = bufferedImage.getSubimage(602,54,600,12);
        ImageIO.write(background2,"png",new File(""));

        // 云
        BufferedImage cloud = bufferedImage.getSubimage(86,2,46,14);
        ImageIO.write(cloud,"png",new File(""));

        // 数字
        BufferedImage num0 = bufferedImage.getSubimage(484,2,10,13);
        ImageIO.write(num0,"png",new File(""));
        BufferedImage num1 = bufferedImage.getSubimage(494,2,10,13);
        ImageIO.write(num1,"png",new File(""));
        BufferedImage num2 = bufferedImage.getSubimage(504,2,10,13);
        ImageIO.write(num2,"png",new File(""));
        BufferedImage num3 = bufferedImage.getSubimage(514,2,10,13);
        ImageIO.write(num3,"png",new File(""));
        BufferedImage num4 = bufferedImage.getSubimage(524,2,10,13);
        ImageIO.write(num4,"png",new File(""));
        BufferedImage num5 = bufferedImage.getSubimage(534,2,10,13);
        ImageIO.write(num5,"png",new File(""));
        BufferedImage num6 = bufferedImage.getSubimage(544,2,10,13);
        ImageIO.write(num6,"png",new File(""));
        BufferedImage num7 = bufferedImage.getSubimage(554,2,10,13);
        ImageIO.write(num7,"png",new File(""));
        BufferedImage num8 = bufferedImage.getSubimage(564,2,10,13);
        ImageIO.write(num8,"png",new File(""));
        BufferedImage num9 = bufferedImage.getSubimage(574,2,10,13);
        ImageIO.write(num9,"png",new File(""));

        // 恐龙
        BufferedImage jump1 = bufferedImage.getSubimage(677,2,44,47);
        ImageIO.write(jump1,"png",new File(""));
        BufferedImage jump2 = bufferedImage.getSubimage(721,2,44,47);
        ImageIO.write(jump2,"png",new File(""));

        // run
        BufferedImage run1 = bufferedImage.getSubimage(765,2,44,47);
        ImageIO.write(run1,"png",new File(""));
        BufferedImage run2 = bufferedImage.getSubimage(809,2,44,47);
        ImageIO.write(run2,"png",new File(""));

        // die
        BufferedImage die1 = bufferedImage.getSubimage(853,2,44,47);
        ImageIO.write(die1,"png",new File(""));
        BufferedImage die2 = bufferedImage.getSubimage(897,2,44,47);
        ImageIO.write(die2,"png",new File(""));

        // 俯冲
        BufferedImage trex1 = bufferedImage.getSubimage(939,2,59,47);
        ImageIO.write(trex1,"png",new File(""));
        BufferedImage trex2 = bufferedImage.getSubimage(998,2,59,47);
        ImageIO.write(trex2,"png",new File(""));

        // small cactus
        BufferedImage cactus_small1 = bufferedImage.getSubimage(228,2,17,35);
        ImageIO.write(cactus_small1,"png",new File(""));
        BufferedImage cactus_small2 = bufferedImage.getSubimage(245,2,17*2,35);
        ImageIO.write(cactus_small2,"png",new File(""));
        BufferedImage cactus_small3 = bufferedImage.getSubimage(279,2,17*3,35);
        ImageIO.write(cactus_small3,"png",new File(""));

        // large cactus
        BufferedImage cactus_large1 = bufferedImage.getSubimage(332,2,25,50);
        ImageIO.write(cactus_large1,"png",new File(""));
        BufferedImage cactus_large2 = bufferedImage.getSubimage(357,2,25*2,50);
        ImageIO.write(cactus_large2,"png",new File(""));
        BufferedImage cactus_large3 = bufferedImage.getSubimage(407,2,25*3,50);
        ImageIO.write(cactus_large3,"png",new File(""));

        // 翼龙
        BufferedImage pterodactyl1 = bufferedImage.getSubimage(134,2,46,40);
        ImageIO.write(pterodactyl1,"png",new File(""));
        BufferedImage pterodactyl2 = bufferedImage.getSubimage(180,2,46,40);
        ImageIO.write(pterodactyl2,"png",new File(""));

        // restart
        BufferedImage gameOver = bufferedImage.getSubimage(484,15,191,11);
        ImageIO.write(gameOver,"png",new File(""));

        BufferedImage restart = bufferedImage.getSubimage(2,2,36,36);
        ImageIO.write(restart,"png",new File(""));

    }
}
