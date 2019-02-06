import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ScraperMain {

    public static void main(String[] args) {

        try {

            DataModel myCar = new DataModel(2001, "nissan", "rogue");

            Document doc;
            doc = Jsoup.connect(myCar.toUrl()).get();

//            String title = doc.title();
//            System.out.println("Title: " + title);
//            System.out.println("");

            Elements prices = doc.select(".price");

            int total = 0;

            for (Element price : prices) {
                System.out.println("Price: " + price.text());

            }

        } catch (IOException e) {
            System.err.println(e);
        }
    }
}