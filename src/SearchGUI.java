import javax.swing.*;
import java.util.ArrayList;

public class SearchGUI {
    private JTable table1;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;

    private void createUIComponents() {
        // TODO: place custom component creation code here

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
