package com.example.astro.recyclerviewexpand.Model;

import java.io.Serializable;

/**
 * Created by vitinhHienAnh on 13-04-18.
 */

public class IsExpandItems implements Serializable {
//    public String firstName;
    public int position;
    public boolean isExpand;

//    public String getFirstName() {
//        return firstName;
//    }
//
//    public void setFirstName(String firstName) {
//        this.firstName = firstName;
//    }


    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public IsExpandItems(int position) {
//        this.firstName = firstName;
        this.position = position;
        this.isExpand = false;
    }
}
