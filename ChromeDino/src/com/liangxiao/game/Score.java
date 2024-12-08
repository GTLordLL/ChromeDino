package com.liangxiao.game;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.sql.*;
import java.util.Objects;

public class Score {
    private Image oneDigitImage;
    private Image tensDigitImage;
    private Image hundredsDigitImage;
    private Image kilobitImage;
    private Image myriabitImage;
    private Image maxScoreImage;
    private final Image HIImage;
    private final Image[] numsImage;
    private final String url = "jdbc:mysql://localhost:3306/chormedino?serverTimezone=UTC";
    private final String username = "root";
    private final String passwd = "200312";
    public Score() throws IOException {
        numsImage = new Image[10];
        for (int i = 0; i<10;i++){
            numsImage[i] = ImageIO.read(Objects.requireNonNull(getClass().getResource("num"+i+".png")));
        }
        HIImage = ImageIO.read(Objects.requireNonNull(getClass().getResource("HI.png")));

        oneDigitImage = numsImage[0];
        tensDigitImage = numsImage[0];
        hundredsDigitImage = numsImage[0];
        kilobitImage = numsImage[0];
        myriabitImage = numsImage[0];
        maxScoreImage = numsImage[0];
    }
    public void paint(Graphics g){
        g.drawImage(oneDigitImage,570,1,null);
        g.drawImage(tensDigitImage,560,1,null);
        g.drawImage(hundredsDigitImage,550,1,null);
        g.drawImage(kilobitImage,540,1,null);
        g.drawImage(myriabitImage,530,1,null);
    }
    public void paintMax(Graphics g,int point){
        int counter = point;
        g.drawImage(HIImage,440,1,null);

        maxScoreImage = numsImage[counter%10];
        counter/=10;
        g.drawImage(maxScoreImage,510,1,null);

        maxScoreImage = numsImage[counter%10];
        counter/=10;
        g.drawImage(maxScoreImage,500,1,null);
        maxScoreImage = numsImage[counter%10];
        counter/=10;
        g.drawImage(maxScoreImage,490,1,null);
        maxScoreImage = numsImage[counter%10];
        counter/=10;
        g.drawImage(maxScoreImage,480,1,null);
        maxScoreImage = numsImage[counter%10];
        g.drawImage(maxScoreImage,470,1,null);
    }
    public void count(int point){
        int counter = point;
        oneDigitImage = numsImage[counter%10];
        counter/=10;
        tensDigitImage = numsImage[counter%10];
        counter/=10;
        hundredsDigitImage = numsImage[counter%10];
        counter/=10;
        kilobitImage = numsImage[counter%10];
        counter/=10;
        myriabitImage = numsImage[counter%10];
    }
    public void save(int score){
        try {
            Connection conn = DriverManager.getConnection(url,username,passwd);
            String sql = "insert into point value(default,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,"LL");
            ps.setInt(2,score);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public int getMaxScore() {
        try (Connection conn = DriverManager.getConnection(url, username, passwd)) {
            String sql = "SELECT MAX(score) AS max_score FROM point";
            try (PreparedStatement ps = conn.prepareStatement(sql);
                 ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("max_score");
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return 0; // 如果表为空，返回0
    }
}
