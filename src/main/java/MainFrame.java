import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

import static javax.swing.SpringLayout.SOUTH;
import static javax.swing.SwingConstants.CENTER;

public class MainFrame extends JFrame {
    GeneralPanel generalPanel;
    ControlCenter controlCenter;
    public MainFrame(){
        super("Decode my letter");
        initialize();
    }
    private void initialize(){
        this.setBounds(100,100,700,700);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        generalPanel = new GeneralPanel(this);
        controlCenter = new ControlCenter(this);

        setLayout(new BorderLayout());
        add(generalPanel, BorderLayout.NORTH);
        add(controlCenter, BorderLayout.SOUTH);

        pack();
    }
}
