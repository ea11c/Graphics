import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

/**
 * Created by eric on 3/8/2017.
 */
public class DesktopFrame extends JFrame {
    JDesktopPane desktop;

    DesktopFrame(){
        super("Homework 5");
        JMenuBar menuBar = new JMenuBar();
        //create menus in the menu bar
        JMenu createMenu = new JMenu("Create");  //creates the create menu
        createMenu.setMnemonic('c');

        JMenu quitMenu = new JMenu("Quit");  //creates Quit menu
        quitMenu.setMnemonic('q');

        JMenuItem pictureFrame = new JMenuItem("Picture");
        pictureFrame.setMnemonic('p');
        pictureFrame.addActionListener(createPicListen);


        JMenuItem changeableFrame = new JMenuItem("Changeable Picture");
        changeableFrame.setMnemonic('c');
        changeableFrame.addActionListener(createChangeListen);

        JMenuItem quitFrame = new JMenuItem("Exit Program");
        quitFrame.setMnemonic('x');
        quitFrame.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));  //adds ctrl + x quit shortcut
        quitFrame.addActionListener(exitListen);

        createMenu.add(pictureFrame);
        createMenu.add(changeableFrame);
        quitMenu.add(quitFrame);
        menuBar.add(createMenu);
        menuBar.add(quitMenu);
        setJMenuBar(menuBar);
        //create desktop pane
        desktop = new JDesktopPane();
        add(desktop);
    }
    ActionListener exitListen = new ActionListener() {  //listens for exit click
        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    };
    ActionListener createPicListen  = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            PictureFrame picture = new PictureFrame();
            desktop.add(picture);
            picture.setSize(200, 200);
            picture.setVisible(true);
            picture.repaint();
        }
    };
    ActionListener createChangeListen = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            ChangeablePictureFrame chpicture = new ChangeablePictureFrame();
            desktop.add(chpicture);
            chpicture.setVisible(true);
            chpicture.repaint();
        }
    };
}
