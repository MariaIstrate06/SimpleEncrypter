import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Base64;

/*import jasy.pt;*/


public class GeneralPanel extends JPanel {
    final MainFrame frame;
    JTextArea textAreaInput = new JTextArea(5, 30);
    JTextArea textAreaOutput = new JTextArea(5,30);
    JButton decodeButton = new JButton("Decode");
    JButton encodeButton = new JButton("Encode");
    String inputMessage;
    public GeneralPanel(MainFrame frame){
        this.frame = frame;
        init();
        /*textAreaOutput.setText("salut!");*/
    }
    public void init(){
        setLayout(new BoxLayout(this,BoxLayout.X_AXIS));
        add(textAreaInput);
        add(encodeButton);
        add(decodeButton);
        add(textAreaOutput);

        //action listeners

        encodeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                inputMessage = textAreaInput.getText();
                textAreaOutput.setText(encrypt(inputMessage));
            }
        });
        decodeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                inputMessage = textAreaInput.getText();
                textAreaOutput.setText(decrypt(inputMessage));
            }
        });
    }
    public String encrypt(String string){
        String b64encoded = Base64.getEncoder().encodeToString(string.getBytes());
        String reverse = new StringBuffer(b64encoded).reverse().toString();
        StringBuilder temp = new StringBuilder();
        final int OFFSET = 4;
        for(int i = 0; i<reverse.length();i++){
            temp.append((char)(reverse.charAt(i)+OFFSET));
        }
        return temp.toString();
    }
    public String decrypt(String string){
        StringBuilder temp = new StringBuilder();
        final int OFFSET = 4;
        for(int i=0;i<string.length();i++){
            temp.append((char)(string.charAt(i)-OFFSET));
        }
        String reversed = new StringBuffer(temp.toString()).reverse().toString();
        return new String(Base64.getDecoder().decode(reversed));
    }

}
