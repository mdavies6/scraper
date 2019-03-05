import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.util.ArrayList;

public class ResultsGUI extends JFrame {
    private JPanel panel1;
    private JTable table1;
    public ArrayList<AdModel> modelList;

    public ResultsGUI(ArrayList<AdModel> modelList) {
        this.modelList = modelList;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 800);
        this.add(panel1);

    }

}
