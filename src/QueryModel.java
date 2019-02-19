public class QueryModel {

    public int year;
    public String brand;
    public String model;
    public String color;

    public QueryModel(int year, String brand, String model){

        checkYear(year);

        brand.toLowerCase();
        model.toLowerCase();

        this.year = year;
        this.brand = brand;
        this.model = model;
    }

    public QueryModel(int year, String brand, String model, String color){

        checkYear(year);

        brand.toLowerCase();
        model.toLowerCase();
        color.toLowerCase();

        this.year = year;
        this.brand = brand;
        this.model = model;
        this.color = color;

    }

    public String toQueryUrl(){
        String base = "https://www.kijiji.ca/b-edmonton/";
        String mid =  year + "-" + brand + "-" + model;
        String end = "/k0l1700203?dc=true";


        return base + mid + end;
    }

    private static void checkYear(int year){
        if (year < 1885 || year > 2021){
            Error yearError = new Error("QueryModel ERROR: Invalid year");
            throw yearError;
        }
    }

}
