import javax.swing.*;

public class FinderGUI extends JFrame{
    public JButton searchButton;
    private JPanel backPanel;
    public JTextField brandField;
    public JTextField modelField;
    public JTextField yearField;
    public JProgressBar progressBar1;

    public FinderGUI(){
        this.setTitle("Search");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(600, 400);
        this.add(backPanel);
    }

    public void updateBar(int newValue){
        progressBar1.setValue(newValue);

    }
}
