package com.gray.mongodemo.model;

import lombok.Data;

/**
 * Created by IntelliJ IDEA Ultimate.
 * User: Pasindu Raveen
 * Date: 12-Dec-22
 * Time: 11:09 PM
 * MongoDemo
 */
@Data
public class Address {
    private String address;
    private String postalCode;
    private String city;
    private String country;

}
