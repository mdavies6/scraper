import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import javax.swing.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.*;
import org.jsoup.select.Elements;

public class ScraperMain {

    //TODO connect main and gui

    public static void main(String[] args) {

        ArrayList<AdModel> adList = new ArrayList();

        ArrayList<AdModel> favList = new ArrayList();
        loadFile("favList.csv", favList);

        ScraperGUI gui = new ScraperGUI();

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.getContentPane().add(gui);
                frame.pack();
                frame.setVisible(true);
            }
        });

//        gui.searchButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                System.out.println(gui.scraperTextField.getText());
//            }
//        });

        QueryModel myCar = new QueryModel(2017, "nissan", "rogue");

        //Connect to url from QueryModel and iterate through ads, generate adModels and add to adList
        try {
            Document doc;
            doc = Jsoup.connect(myCar.toQueryUrl()).get();

            Elements regularAds = doc.select("div.search-item.regular-ad");

            for (Element ad : regularAds) {
                String url = "https://www.kijiji.ca" + ad.attr("data-vip-url");
                AdModel tempAdModel = new AdModel(url);
                // Check to make sure the ad has a price before appending it to arrayList
                if (tempAdModel.listedPrice > 0) {
                    adList.add(tempAdModel);
                }

            }
            //System.out.println("Ad 0: " + adList.get(0));

        } catch (IOException e) {
            System.err.println(e);
        }

        saveFile("favList.csv", adList);

    }//end main

    public static void loadFile(String filename, ArrayList tempList) {
        String temp = "";
        try {
            BufferedReader file = new BufferedReader(new FileReader(filename));
            while (file.ready()) {
                temp = file.readLine();
                String tempArray[] = temp.split(",");

                tempList.add(new AdModel(tempArray[0], tempArray[1], Double.parseDouble(tempArray[2]), tempArray[3], Integer.parseInt(tempArray[4])));

            }
        } catch (IOException e) {
            System.out.println(e);
        }

    }//end loadFile


    public static void saveFile(String filename, ArrayList<AdModel> tempList) {
        try {
            PrintWriter file = new PrintWriter(new FileWriter(filename));

            for (int i = 0; i < tempList.size(); i++) {

                String toSave = "";
                toSave = tempList.get(i).url;
                toSave += "," + tempList.get(i).title;
                toSave += "," + tempList.get(i).listedPrice;
                toSave += "," + tempList.get(i).body;
                toSave += "," + tempList.get(i).wordCount;

                file.println(toSave);

            }
            file.close();
        } catch (IOException ex) {
            System.out.println(ex.toString());
        }

    }//end saveFile


}