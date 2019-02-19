import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SearchGUI {
    private JTextField searchTextField;
    private JPanel panel1;
    private JTextField modelField;
    private JTextField brandField;
    private JTextField yearField;
    private JTable resultsTable;
    private JButton entryButton;

    public SearchGUI() {
        entryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        String[] columnHeaders = {"Title","Listed Price", "Description"};
        Object [][] data = {};
    }
    private ArrayList<Object> objToDoubleArr (ArrayList<AdModel> arrList){
        //Title
        //ListedPrice
        //Description
        ArrayList<Object> objArrList = new ArrayList();
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
