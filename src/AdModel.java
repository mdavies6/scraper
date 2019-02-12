import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class AdModel {

    public String url;

    public String title;
    public double listedPrice;
    public String text;

    public int wordCount;

    public Document doc;

    public AdModel(String url) {
        this.url = url;

        doc = getDoc();

        listedPrice = getPrice();
        wordCount = getWordCount();
    }

    private Document getDoc() {
        try {
            return Jsoup.connect(url).get();
        } catch (IOException e) {
            System.out.println(e);
        }
        return null;
    }

    private double getPrice() {
        try {

            Element priceElement = doc.select("span[content]").first();
            String priceString = priceElement.attr("content");

            double price = Double.parseDouble(priceString);
            System.out.println(price);

            return price;

        } catch (NullPointerException e) {
            return -1;

        }//end try-catch

    }

    private String getText(){

    }

    private int getWordCount() {
        return text.split(" ").length;
    }

    @Override
    public String toString() {
        return title + " " + listedPrice + " " + url;
    }
}
