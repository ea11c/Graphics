import javafx.scene.paint.*;
import javafx.scene.shape.Circle;

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
        this.pack();
        repaint();
    }
    // paint circle and rectangle
    public void paintComponent( Graphics g )
    {
        super.paintComponent( g ); // call superclass's paint method

        this.setBackground( Color.BLUE);
        if(height > width){
            radius = width / 4;
        }
        else{
            radius = height / 4;
        }
        xc = width / 3;
        yc = height / 10;
        g.setColor( Color.YELLOW );
        g.drawOval( xc, yc, radius, radius );
        g.fillOval( xc, yc, radius, radius );
    }
}
