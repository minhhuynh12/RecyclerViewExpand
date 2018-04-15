package com.example.astro.recyclerviewexpand.Model;

/**
 * Created by vitinhHienAnh on 04-04-18.
 */

public class MainDataItems {
    private String firstName;
    private String lastName;
    private String age;
    private String image;
    private int position;

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public MainDataItems(String firstName, String lastName, String age , String image ) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.image = image;
    }
}
