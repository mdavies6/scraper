import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ScraperMain {

    public static void main(String[] args) {

        ArrayList<AdModel> adList = new ArrayList();

        QueryModel myCar = new QueryModel(2017, "nissan", "rogue");

        //Connect to url from QueryModel and iterate through ads, generate adModels and add to adList
        try {
            Document doc;
            doc = Jsoup.connect(myCar.toQueryUrl()).get();

            Elements regularAds = doc.select("div.search-item.regular-ad");

            for (Element ad : regularAds) {
                String url = "https://www.kijiji.ca" + ad.attr("data-vip-url");

               adList.add(new AdModel(url));

            }
            System.out.println("Ad 0: " + adList.get(0));

        } catch (IOException e) {
            System.err.println(e);
        }
    }

}