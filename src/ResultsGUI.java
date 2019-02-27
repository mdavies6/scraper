import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class ResultsGUI extends JFrame {
    private JPanel panel1;
    private JTable table1;

    public ResultsGUI(AdModel ad) {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 800);
        setupTable(ad);
        this.add(panel1);

    }

    public void setupTable(AdModel tempAd) {
        String column[] = {"Title", "Price", "Word Count"};
        TableModel tableModel = new DefaultTableModel(column, 0);

        Object[] obj = {tempAd.title, tempAd.listedPrice, tempAd.wordCount};
        ((DefaultTableModel) tableModel).addRow(obj);

        table1 = new JTable(tableModel);
    }
}
