import javafx.stage.Screen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Created by eric on 3/8/2017.
 */
public class ChangeablePictureFrame extends JInternalFrame {
    ChangeablePictureFrame(){
        super("Changeable Picture Frame", true, true, true, true);
        OvalPanel oval = new OvalPanel();
        oval.setMinimumSize(new Dimension(100,100));
        oval.setPreferredSize(new Dimension(100, 100));
        oval.setBackground(Color.WHITE);
        JCheckBox moveable = new JCheckBox();
        moveable.setText("Move on Drag");
        this.getContentPane().setLayout(new GridBagLayout());
        GridBagConstraints M = new GridBagConstraints();
        M.gridx = 0;
        M.gridy = 0;
        M.weightx = 0.25;
        this.add(moveable, M);
        JRadioButtonMenuItem Green = new JRadioButtonMenuItem();
        Green.setText("Green");
        Green.setSelected(true);
        Green.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                oval.drawColor = Color.GREEN;
                oval.repaint();
            }
        });
        GridBagConstraints G = new GridBagConstraints();
        G.gridx = 1;
        G.gridy = 0;
        G.weightx = 0.25;
        this.add(Green, G);
        JRadioButtonMenuItem Red = new JRadioButtonMenuItem();
        Red.setText("Red");
        Red.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                oval.drawColor = Color.RED;
                oval.repaint();
            }
        });
        GridBagConstraints R = new GridBagConstraints();
        R.gridx = 2;
        R.gridy = 0;
        R.weightx = 0.25;
        this.add(Red, R);
        JRadioButtonMenuItem Blue = new JRadioButtonMenuItem();
        Blue.setText("Blue");
        Blue.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                oval.drawColor = Color.BLUE;
                oval.repaint();
            }
        });
        GridBagConstraints B = new GridBagConstraints();
        B.gridx = 3;
        B.gridy = 0;
        B.weightx = 0.25;
        this.add(Blue, B);
        ButtonGroup rgb = new ButtonGroup();
        rgb.add(Green);
        rgb.add(Red);
        rgb.add(Blue);
        GridBagConstraints O = new GridBagConstraints();
        O.gridx = 0;
        O.gridy = 1;
        O.gridwidth = GridBagConstraints.REMAINDER;
        O.gridheight = GridBagConstraints.REMAINDER;
        O.weighty = 1;
        O.weightx = 1;
        this.add(oval, O);
        oval.setVisible(true);
        this.pack();
        this.repaint();
        oval.repaint();
    }
    private class OvalPanel extends JPanel{
        Color drawColor;
        int Xcoord;
        int Ycoord;
        OvalPanel(){
            drawColor = Color.GREEN;
            Xcoord = getWidth()/2;
            Ycoord = getHeight()/2;
        }
        @Override
        public void paintComponent(Graphics g){
            this.setBackground(Color.WHITE);
            g.setColor(drawColor);
            g.drawOval(Xcoord, Ycoord, (int)(getWidth() * 0.3), (int)(getHeight() * 0.3));
            g.fillOval(Xcoord, Ycoord, (int)(getWidth() * 0.3), (int)(getHeight() * 0.3));
        }
    }
}
