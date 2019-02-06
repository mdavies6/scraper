

public class AdModel {

    public String title;
    public String url;
    public double listedPrice;
    public String text;

    public int wordCount;

public AdModel(String title, String url, double listedPrice, String text){
    this.title = title;
    this.url = url;
    this.listedPrice = listedPrice;
    this.text = text;

    calcWordCount();
}

    private void calcWordCount() {
        wordCount = text.split(" ").length;
    }
}
