import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ResultsGUI extends JFrame {
    private JPanel panel1;
    public JTable table1;
    private JButton searchButton;
    public ArrayList<AdModel> modelList;


    public ResultsGUI(ArrayList<AdModel> modelList) {
        this.setTitle("Results");
        this.modelList = modelList;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 800);

        String[] columnHeaders = {"Title", "Listed Price", "Description"};
        ArrayList data = new ArrayList();
        data = objToDoubleArr(modelList);
        String[][] tableData = new String[10][3];
        for(int i=0;i<Math.min(modelList.size(),10); i++){
            tableData[i][0] = modelList.get(i).title;
            tableData[i][1] = "" + modelList.get(i).listedPrice;
            tableData[i][2] = modelList.get(i).body;

        }
        table1 = new JTable(tableData,columnHeaders);
        this.add(panel1);
        this.add(new JScrollPane(table1));





}
    private ArrayList<Object> objToDoubleArr (ArrayList<AdModel> arrList){
        //Title
        //ListedPrice
        //Description
        ArrayList objArrList = new ArrayList();
        Object[] resultArr = new Object[3];

        for (int i = 0; i<arrList.size(); i++){
            resultArr[0] = arrList.get(i).title;
            resultArr[1] = arrList.get(i).listedPrice;
            resultArr[2] = arrList.get(i).body;
            objArrList.add(resultArr);
        }
        return objArrList;
    }

}
