package SubImage;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class SImage {
    public static void main(String[] args) throws IOException {
        BufferedImage bufferedImage = ImageIO.read(new File("D:/IEDAproject/ChromeDino/src/SubImage/offline-sprite-1x.png"));

        BufferedImage background1 = bufferedImage.getSubimage(584,2,20,13);
        ImageIO.write(background1,"png",new File("D:/IEDAproject/ChromeDino/src/SubImage/"));
    }
}
