
import javax.swing.*;
import java.awt.*;
import java.awt.Color;

/**
 * Created by eric on 3/8/2017.
 */
public class PictureFrame extends JInternalFrame {
    int height, width, xc, yc, xr, yr, radius;
    PictureFrame(){
        super("Picture Frame", true, true, true, true);
        this.setBackground(Color.BLUE);
        //calcuate coordinates and size for rectangle
        height = getHeight();
        width = getWidth();
        DrawPanel circle = new DrawPanel();
        this.add(circle);
        circle.setSize(width, height);
        circle.setVisible(true);
        circle.repaint();
        this.repaint();
    }
    private class DrawPanel extends JPanel{
        @Override
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            this.setBackground(Color.blue);
            height = getHeight();
            width = getWidth();
            g.setColor(Color.YELLOW);
            if(height > width)
                radius = width / 4;
            else
                    radius = height / 4;
            g.drawOval((int)(width * 0.7), (int)(height *0.1), radius, radius);
            g.fillOval((int)(width * 0.7), (int)(height * 0.1), radius, radius);

            g.setColor(new Color(165, 91, 7));
            g.drawRect(0, height - height/10, width, height / 10);
            g.fillRect(0, height - height/10, width, height / 10);

        }
    }
    // paint circle and rectangle
}
