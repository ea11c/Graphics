import javax.swing.*;
import java.awt.*;

/**
 * Created by eric on 3/8/2017.
 */
public class ChangeablePictureFrame extends JInternalFrame {
    ChangeablePictureFrame(){
        super("Changeable Picture Frame", true, true, true, true);
        JPanel panel = new JPanel();
        this.add(panel);
        this.pack();
    }
}
