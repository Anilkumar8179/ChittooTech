package com.example.chittootech;

public class User {
    private String name;
    private int age;
    private boolean premium;

    public User() {
    }

    public User(String name, int age, boolean premium) {
        this.name = name;
        this.age = age;
        this.premium = premium;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isPremium() {
        return premium;
    }

    public void setPremium(boolean premium) {
        this.premium = premium;
    }
}
