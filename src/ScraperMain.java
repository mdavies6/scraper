import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ScraperMain {

    public static void main(String[] args) {

        ArrayList<AdModel> adList = new ArrayList();

        try {

            QueryModel myCar = new QueryModel(2017, "nissan", "rogue");

            Document doc;
            doc = Jsoup.connect(myCar.toQueryUrl()).get();
            //System.out.println(myCar.toQueryUrl());

            Elements regularAds = doc.select("div.search-item.regular-ad");

            for (Element ad : regularAds) {
                String url = "https://www.kijiji.ca" + ad.attr("data-vip-url");
                System.out.println(" URL: " + url);

               AdModel am = new AdModel(url);

            }

        } catch (IOException e) {
            System.err.println(e);
        }
    }

//    public static AdModel getAdModelFromURL(String url){
//
//
//
//    }

}