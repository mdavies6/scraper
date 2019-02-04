public class DataModel {

    public int year;
    public String brand;
    public String model;
    public String color;

    public DataModel(int year, String brand, String model){

        checkYear(year);

        brand.toLowerCase();
        model.toLowerCase();

        this.year = year;
        this.brand = brand;
        this.model = model;
    }

    public DataModel(int year, String brand, String model, String color){

        checkYear(year);

        brand.toLowerCase();
        model.toLowerCase();
        color.toLowerCase();

        this.year = year;
        this.brand = brand;
        this.model = model;
        this.color = color;

    }

    public String toUrl(){
        String base = "https://www.kijiji.ca/b-edmonton/";
        String mid = base + year + "-" + brand + "-" + model;
        String end = "/k0l1700203?dc=true";


        return base + mid + end;
    }

    private static void checkYear(int year){
        if (year > 2021 || year < 1900){
            System.err.println("DataModel ERROR: Invalid year");
        }
    }

}
