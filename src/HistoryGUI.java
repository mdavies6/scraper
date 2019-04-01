import javax.swing.*;
import java.util.ArrayList;

public class HistoryGUI extends JFrame{
    private JList list1;
    private JPanel panel1;

    public HistoryGUI( ArrayList<Object> history){
        this.setTitle("Search History");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(600, 800);
        this.add(panel1);

        if (history.size() > 0) {
            Object[] listModel = new Object[history.size()];

            for (int i = 0; i < history.size(); i++){
                listModel[i] = history.get(i);
            }

            JList list = new JList(listModel); //data has type Object[]
            list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
            list.setLayoutOrientation(JList.VERTICAL);
            list1 = list;
            this.add(list1);
        }
    }
}
