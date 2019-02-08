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

public AdModel(String url){
    this.url = url;

    listedPrice = getPrice();
    //calcWordCount();
}

private double getPrice(){
    try {

        Document doc;
        doc = Jsoup.connect(url).get();

        Element priceElement = doc.select("span[content]").first();
        String priceString = priceElement.attr("content");

        double price = Double.parseDouble(priceString);
        System.out.println(price);

        return price;

    } catch (IOException | NullPointerException e) {
        if(e instanceof NullPointerException){

        }else{
            System.err.println(e);
        }

    }//end try-catch
    return -1.0;
}

    private void calcWordCount() {
        wordCount = text.split(" ").length;
    }
}
