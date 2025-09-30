package week_08._0930.work0930;

public class Temperature {
    private String city;
    private int maxTemp;

    public Temperature(String city, int maxTemp) {
        this.city = city;
        this.maxTemp = maxTemp;
    }

    public String getCity() {
        return city;
    }

    public int getMaxTemp() {
        return maxTemp;
    }
}