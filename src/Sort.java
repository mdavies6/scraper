import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Sort extends JFrame{

    private JPanel panel2;
    private JButton sbp;

    public ArrayList<AdModel> modelList;
    private JTable table1;

    String[][] tableData1 = new String[10][3];
    String[][] temp = new String[1][3];
    String[] columnHeaders1 = {"Title", "Listed Price", "Description"};
     Sort(ArrayList<AdModel> modelList) {
        this.setTitle("Sort");
        this.modelList = modelList;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(200, 100);


        this.add(sbp);
        sbp.setVisible(true);
        revalidate();
        repaint();
        sbp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {



                for(int i=0;i<Math.min(modelList.size(),10); i++){
                    tableData1[i][0] = modelList.get(i).title;
                    tableData1[i][1] = "" + modelList.get(i).listedPrice;
                    tableData1[i][2] = modelList.get(i).body;

                }

                for(int i=0;i<Math.min(modelList.size(),10); i++){
                   for(int j=1;j<(Math.min(modelList.size(),10)-1); j++) {
                       if (Double.parseDouble(tableData1[j][1]) > Double.parseDouble(tableData1[j + 1][1])) {
                           temp[0][0] = tableData1[j][0];
                           temp[0][1] = "" + tableData1[j][1];
                           temp[0][2] = tableData1[j][2];


                           tableData1[j][0] = tableData1[j + 1][0];
                           tableData1[j][1] = "" + tableData1[j + 1][1];
                           tableData1[j][2] = tableData1[j + 1][2];

                           tableData1[j + 1][0] = temp[0][0];
                           tableData1[j + 1][1] = temp[0][1];
                           tableData1[j + 1][2] = temp[0][2];
                       }
                   }

                }
                 table1 = new JTable(tableData1,columnHeaders1);
                JScrollPane table11 = new JScrollPane(table1);
                setTable1(table11);
                }

        });


    }
    private void setTable1(JScrollPane temp){
        this.add(temp);
        revalidate();
        repaint();
    }
    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
