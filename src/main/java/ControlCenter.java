import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class ControlCenter extends JPanel{
    final MainFrame frame;
    JButton exitButton = new JButton("Exit");
    public ControlCenter(MainFrame frame){
        super();
        this.frame = frame;
        initialize();
    }
    private void initialize(){
        setLayout(new GridLayout(1,1));
        add(exitButton);
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
}
