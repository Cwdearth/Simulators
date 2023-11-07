package cdearth.systems;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class Grapher extends JPanel {

    Double[] values = new Double[25];
    double latitude = 0.0;
    int day = 0;

    public Grapher() {
    }

    public void updateValues(Double[] values, double latitude, int day) {
        this.values = values;
        this.latitude = latitude - 90;
        this.day = day;
        repaint();
    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        Color rgb;
        g2.setColor(Color.BLACK);
        g2.setColor(new Color(10,0,77));
        g2.fillRect(0,400,1980,1080);
        g2.setColor(new Color(135, 206, 235));
        g2.fillRect(0,0,1980,400);
        g.setFont(new Font("Arial Black", Font.BOLD, 40));

        Shape point;

        for(int i=0; i < 24; i++) {
            point = new Ellipse2D.Float(1889.5F - ((i) * 82.5F), (float) ((400 - ((int) Math.round(values[i]) * 4))), 32, 32);

            System.out.println(values[i]);
            if (values[i] > 0) {
                rgb = new Color(253, 184, 19);
            } else
                rgb = new Color(246, 241, 213);
            g2.setColor(new Color(135, 206, 235));
            g2.fillRect(0, 0, 300, 300);
            g2.setColor(Color.BLACK);
            g2.drawString("Day Of The Year: " + day, 20, 200);
            g2.drawString("Latitude: " + latitude + " N'", 20, 300);
            g.drawLine(0, 400, 1980, 400);
            g2.setColor(rgb);
            g2.fill(point);
            g2.draw(point);
            System.out.println();
        }
    }
}
