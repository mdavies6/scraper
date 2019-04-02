import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import javax.swing.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.jsoup.Jsoup;
import org.jsoup.nodes.*;
import org.jsoup.select.Elements;

public class ScraperMain {

    public static double max = 11.0;

    public static void main(String[] args) {

        ArrayList<AdModel> adList = new ArrayList();

        ArrayList<AdModel> favList = new ArrayList();
        ArrayList<Object> historyList = new ArrayList();
       // loadFile("favList.csv", favList);
        loadFile("historyList.csv", historyList, true);

        ScraperGUI gui = new ScraperGUI();
        FinderGUI fGui = new FinderGUI();

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {

                gui.setVisible(true);
            }
        });

        gui.searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        fGui.setVisible(true);
                    }
                });
            }
        });

        gui.historyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        HistoryGUI hGui = new HistoryGUI(historyList);
                      hGui.setVisible(true);
                    }
                });
            }
        });

        gui.settingsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        String ans = JOptionPane.showInputDialog("Enter the maximum number of search results");
                        if (!ans.equals(null)){
                            double maxR = Double.parseDouble(ans);
                            max = maxR;
                        }
                    }
                });
            }
        });

        fGui.searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                fGui.searchButton.setEnabled(false);
                String model = fGui.modelField.getText();
                String brand = fGui.brandField.getText();
                int year = Integer.parseInt(fGui.yearField.getText());

                QueryModel myCar = new QueryModel(year, brand, model);

                DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                Date date = new Date();
                String dateString = dateFormat.format(date); //2016/11/16 12:08:43

                historyList.add(year + " " + brand + " " + model + "    at: " + dateString);
                saveFile("historyList.csv", historyList, true);

                // Connect to url from QueryModel and iterate through ads, generate adModels and add to adList
                try {
                    Document doc;
                    doc = Jsoup.connect(myCar.toQueryUrl()).get();

                    Elements regularAds = doc.select("div.search-item.regular-ad");
                    System.out.println(regularAds.size());

                    double limit = 1.0;
                    double userResultLimit = max;
                    double searchResultLimit = Math.min(userResultLimit, regularAds.size());

                    for (Element ad : regularAds) {
                        System.out.println(limit);
                        if (limit <= searchResultLimit) {
                            // Progress bar
                            int progress = (int) ((100.0 / searchResultLimit) * limit);
                            System.out.println(progress);

                            SwingUtilities.invokeLater(new Runnable() {
                                public void run() {
                                    fGui.progressBar1.setValue(progress);
                                    fGui.progressBar1.update(fGui.progressBar1.getGraphics());
                                }

                            });

                            // Create adModel
                            String url = "https://www.kijiji.ca" + ad.attr("data-vip-url");
                            AdModel tempAdModel = new AdModel(url);

                            // Check to make sure the ad has a price before appending it to arrayList
                            if (tempAdModel.listedPrice > 0) {
                                adList.add(tempAdModel);
                            }
                            limit++;
                        } else {
                            break;
                        }
                    }
                    System.out.println("AdList size: " + adList.size());
                    System.out.println("save");
                    //saveFile("favList.csv", adList);

                    ResultsGUI rg = new ResultsGUI(adList);
                    Sort sg = new Sort(adList);
                    SwingUtilities.invokeLater(new Runnable() {
                        public void run() {
                            rg.setVisible(true);
                            sg.setVisible(true);
                        }
                    });

                } catch (IOException e) {
                    System.err.println(e);
                }
            }
        });

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

            for (AdModel adModel : tempList) {

                String toSave = "";
                toSave = adModel.url;
                toSave += "," + adModel.title;
                toSave += "," + adModel.listedPrice;
                toSave += "," + adModel.body;
                toSave += "," + adModel.wordCount;

                file.println(toSave);

            }
            file.close();
        } catch (IOException ex) {
            System.out.println(ex.toString());
        }

    }//end saveFile

    public static void loadFile(String filename, ArrayList tempList, Boolean isHistory) {
        String temp = "";
        try {
            BufferedReader file = new BufferedReader(new FileReader(filename));
            while (file.ready()) {
                temp = file.readLine();

                tempList.add(temp);

            }
        } catch (IOException e) {
            System.out.println(e);
        }

    }//end loadFile


    public static void saveFile(String filename, ArrayList<Object> tempList, Boolean isHistory) {
        try {
            PrintWriter file = new PrintWriter(new FileWriter(filename));

            for (Object str : tempList) {

                String toSave = "";
                toSave += str;

                file.println(toSave);

            }
            file.close();
        } catch (IOException ex) {
            System.out.println(ex.toString());
        }

    }//end saveFile
}