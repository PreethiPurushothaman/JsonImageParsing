package com.example.hp.onlineflag;

public class ModelClass {
    public ModelClass(String rank, String country, String popu, String pic) {
        this.rank = rank;
        this.country = country;
        this.popu = popu;
        this.pic = pic;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPopu() {
        return popu;
    }

    public void setPopu(String popu) {
        this.popu = popu;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    String rank;
    String country;
    String popu;
    String pic;




}
