import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class AdModel {

    // Properties to display
    public String url;
    public String title;
    public double listedPrice;
    public String body;
    public int wordCount;

    private Document doc;

    public AdModel(String url) {
        this.url = url;

        doc = getDoc();

        title = getTitle();
        listedPrice = getPrice();
        body = getBody();
        wordCount = getWordCount();
        removeCommas();
    }

    public AdModel(String url, String title, double listedPrice, String body, int wordCount) {
        this.url = url;
        this.title = title;
        this.listedPrice = listedPrice;
        this.body = body;
        this.wordCount = wordCount;

    }

    private Document getDoc() {
        try {
            return Jsoup.connect(url).get();
        } catch (IOException e) {
            System.out.println(e);
        }
        return null;
    }

    private String getTitle() {
        Element div = doc.selectFirst("div[class*=mainColumn]");
        Element textElement = div.selectFirst("h1[itemprop=name]");
        String title = textElement.text();
        return title;
    }

    private double getPrice() {
        try {

            Element priceElement = doc.selectFirst("span[content]");
            String priceString = priceElement.attr("content");

            double price = Double.parseDouble(priceString);
//            System.out.println(price);

            return price;

        } catch (NullPointerException e) {
            System.out.println(e);
            return -1;

        }//end try-catch

    }

    private String getBody() {
        Element textElement = doc.selectFirst("div[itemprop=description]");
        String body = textElement.text();
        return body;
    }

    private int getWordCount() {
        return body.split(" ").length;
    }

    private void removeCommas(){
        title = title.replaceAll(",","");
        body = body.replaceAll(",","");

    }

    @Override
    public String toString() {
        return title + " " + listedPrice + " " + url;
    }
}
