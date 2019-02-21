import javax.swing.*;

public class SearchGUI extends JPanel {
    public JTextField searchTextField;
    private JPanel panel1;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTable resultsTable;

    private void createUIComponents() {
        // TODO: place custom component creation code here
        String[] columnHeaders = {"Title", "Listed Price", "Description"};
        Object [][] data = {};

        this.add(panel1);
    }
}
