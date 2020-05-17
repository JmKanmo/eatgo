package kr.co.fastcampus.eatgo.domain;

public class Restaurant {
    private long id;
    private String name;
    private String location;

    public Restaurant(String name, String location) {
        this.name = name;
        this.location = location;
    }

    public Restaurant(long id, String bob_zip, String seoul) {
        this.id = id;
        this.name = bob_zip;
        this.location = seoul;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
