package com.example.recyclerviewchallange;

public class Person {

    private String model;
    private String name;
    private String logo;
    private String tel;

    public Person(String model, String name, String logo, String tel) {
        this.model = model;
        this.name = name;
        this.logo = logo;
        this.tel = tel;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }
}
