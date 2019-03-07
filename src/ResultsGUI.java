import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.util.ArrayList;

public class ResultsGUI extends JFrame {
    private JPanel panel1;
    private JTable table1;
    public ArrayList<AdModel> modelList;

    public ResultsGUI(ArrayList<AdModel> modelList) {
        this.setTitle("Results");
        this.modelList = modelList;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 800);
        this.add(panel1);

        String[] columnHeaders = {"Title", "Listed Price", "Description"};
        ArrayList data = new ArrayList();
        data = objToDoubleArr(modelList);
        String[][] tableData = new String[3][10];
        for(int i=0;i<Math.min(modelList.size(),10); i++){
            tableData[0][i] = modelList.get(i).title;
            tableData[1][i] = "" + modelList.get(i).listedPrice;
            tableData[2][i] = modelList.get(i).body;

        }
        table1 = new JTable(tableData,columnHeaders);
        this.add(table1);
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
