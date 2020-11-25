package man.kuke.transaction.core;

import java.util.HashMap;

public class Transaction {
    private String name;
    private int time;
    private int price;
    private String city;
    private boolean isAddBad;
    private String info;


    public Transaction() {
    }

    public Transaction(String name, int time, int price, String city) {
        setName(name);
        setTime(time);
        setPrice(price);
        setCity(city);
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public boolean isAddBad() {
        return isAddBad;
    }


    public String getName() {
        return name;
    }

    public void setAddBad(boolean addBad) {
        isAddBad = addBad;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }


    @Override
    public String toString() {
        return  info;
    }
}