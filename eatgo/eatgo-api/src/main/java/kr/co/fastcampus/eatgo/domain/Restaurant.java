package kr.co.fastcampus.eatgo.domain;

public class Restaurant {
    private String bob_zip;
    private String seoul;

    public Restaurant(String bob_zip) {
        this.bob_zip = bob_zip;
    }

    public Restaurant(String bob_zip, String seoul) {
       this.bob_zip = bob_zip;
       this.seoul = seoul;
    }

    public String getBob_zip() {
        return bob_zip;
    }

    public void setBob_zip(String bob_zip) {
        this.bob_zip = bob_zip;
    }

    public String getSeoul() {
        return seoul;
    }

    public void setSeoul(String seoul) {
        this.seoul = seoul;
    }
}
