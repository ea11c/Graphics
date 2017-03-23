

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Created by eric on 3/8/2017.
 */
public class ChangeablePictureFrame extends JInternalFrame {
    //initialize all frame elements and ecent listeners
    OvalPanel oval;
    ChangeablePictureFrame(){
        super("Changeable Picture Frame", true, true, true, true);
        oval = new OvalPanel();
        oval.setBackground(Color.WHITE);
        JPanel pane = new JPanel();
        pane.setLayout(new GridLayout(1, 4));
        JCheckBox moveable = new JCheckBox();
        moveable.setText("Move on Drag");
        moveable.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(moveable.isSelected()) {
                    oval.draggable = true;
                }
                else {
                    oval.draggable = false;
                    oval.centerCircle();
                }
            }
        });
        pane.add(moveable);
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
        pane.add(Green);
        JRadioButtonMenuItem Red = new JRadioButtonMenuItem();
        Red.setText("Red");
        Red.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                oval.drawColor = Color.RED;
                oval.repaint();
            }
        });
        pane.add(Red);
        JRadioButtonMenuItem Blue = new JRadioButtonMenuItem();
        Blue.setText("Blue");
        Blue.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                oval.drawColor = Color.BLUE;
                oval.repaint();
            }
        });
        pane.add(Blue);
        ButtonGroup rgb = new ButtonGroup();
        rgb.add(Green);
        rgb.add(Red);
        rgb.add(Blue);
        this.add(pane, BorderLayout.NORTH);
        this.add(oval, BorderLayout.CENTER);
        pane.setVisible(true);
        oval.setVisible(true);
        this.pack();
        oval.centerCircle();
        this.repaint();
    }
    private class OvalPanel extends JPanel{
        Color drawColor = Color.GREEN;
        boolean draggable = false;

        private final class MouseDrag extends MouseAdapter {
            Point last;
            boolean dragging = false;
            @Override
            public void mousePressed(MouseEvent m) {
                last = m.getPoint();
                if(draggable) {
                    centerCircle(last.x, last.y);
                }
                repaint();
            }

            @Override
            public void mouseReleased(MouseEvent m) {
                last = null;
                repaint();
            }

            @Override
            public void mouseDragged(MouseEvent m) {
                int dx = m.getX() - last.x;
                int dy = m.getY() - last.y;
                x += dx;
                y += dy;
                last = m.getPoint();
                repaint();
            }
        }

        int x;
        int y;
        MouseDrag mouseDrag;

        public OvalPanel() {
            setBackground(Color.WHITE);
            mouseDrag = new MouseDrag();
            addMouseListener(mouseDrag);
            addMouseMotionListener(mouseDrag);
            centerCircle();
        }

        public void centerCircle(){
            x = (getWidth() - (int)(getWidth() * 0.3))/2;
            y = (getHeight() - (int)(getHeight() * 0.3))/2;
            repaint();
        }
        public void centerCircle(int width, int height){
            x = width;
            y = height;
            repaint();
        }


        @Override
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            setBackground(Color.WHITE);
            g.setColor(drawColor);
            g.drawOval(x, y, (int) (getWidth() * 0.3), (int) (getHeight() * 0.3));
            g.fillOval(x, y, (int) (getWidth() * 0.3), (int) (getHeight() * 0.3));

        }
    }
}
