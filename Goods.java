public class Goods {
    private String name;
    private String country;
    private int number;

    Goods() {
        this.name = "";
        this.country = "";
        this.number = 0;
    }

    Goods(String name, String country, int number) {
        this.name = name;
        this.country = country;
        this.number = number;
    }

    String getName() {
        return this.name;
    }

    public String getCountry() {
        return this.country;
    }

    int getNumber() {
        return this.number;
    }

    void setName(String name) {
        this.name = name;
    }

    void setCountry(String country) {
        this.country = country;
    }

    void setNumber(int number) {
        this.number = number;
    }

    public String toString() {
        StringBuilder str = new StringBuilder(name);
        str.append(" to ");
        str.append(country);
        str.append(", value: ");
        str.append(number);
        return (str.toString());
    }
}
