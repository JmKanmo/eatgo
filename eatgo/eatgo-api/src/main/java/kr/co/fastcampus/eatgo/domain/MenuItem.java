package kr.co.fastcampus.eatgo.domain;

public class MenuItem {
    private long id;
    private String name;
    private int price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public MenuItem(long id, String name, int price){
        this.id = id;
        this.name = name;
        this.price =price;
    }

    public void setId(long id){
        this.id = id;
    }

    public long getId() {
        return id;
    }
}
