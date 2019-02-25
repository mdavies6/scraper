import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class ScraperGUI extends JFrame{
    public JTextField scraperTextField;
    public JPanel panel1;
    public JButton searchButton;
    public JButton favouritesButton;
    public JButton button2;
    public JButton button3;

    public ScraperGUI() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 400);
        this.add(panel1);

//        searchButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//
//            }
//        });
    }
}