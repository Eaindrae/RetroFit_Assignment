package com.padcmyanmar.padc9.home_rent_application.data.vos;

import com.google.gson.annotations.SerializedName;

public class HotelVO {
    @SerializedName("id")
    private int id;

    @SerializedName("house_image_url")
    private String houseimageurl;

    @SerializedName("name")
    private String name;

    @SerializedName("description")
    private String description;

    @SerializedName("price")
    private long price;

    @SerializedName("address")
    private String address;

    @SerializedName("square_feet")
    private int square_feet;

    @SerializedName("latitude")
    private double lattitude;

    @SerializedName("longitude")
    private double longitude;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHouseimageurl() {
        return houseimageurl;
    }

    public void setHouseimageurl(String houseimageurl) {
        this.houseimageurl = houseimageurl;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getSquare_feet() {
        return square_feet;
    }

    public void setSquare_feet(int square_feet) {
        this.square_feet = square_feet;
    }

    public double getLattitude() {
        return lattitude;
    }

    public void setLattitude(double lattitude) {
        this.lattitude = lattitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
