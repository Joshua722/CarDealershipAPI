package com.pluralsight.dealership.models;

import java.text.DecimalFormat;

public class Vehicle {
    private String make,model,vehicleType,color;
    private int vin,year,odometer;
    private double price;
    private boolean isSold,isLeased;
    public static DecimalFormat df = new DecimalFormat("0.00");

    public Vehicle(int vin, int year, int odometer, double price, String make, String model, String vehicleType, String color,Boolean isSold,Boolean isLeased) {
        this.vin = vin;
        this.year = year;
        this.odometer = odometer;
        this.price = price;
        this.make = make;
        this.model = model;
        this.vehicleType = vehicleType;
        this.color = color;
        this.isSold = isSold;
        this.isLeased = isLeased;
    }

    public Vehicle() {

    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getVin() {
        return vin;
    }

    public void setVin(int vin) {
        this.vin = vin;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getOdometer() {
        return odometer;
    }

    public void setOdometer(int odometer) {
        this.odometer = odometer;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isSold() {
        return isSold;
    }

    public boolean isLeased() {
        return isLeased;
    }

    public void setLeased(boolean leased) {
        isLeased = leased;
    }

    public void setSold(boolean sold) {
        isSold = sold;
    }

    @Override
    public String toString() {
        return this.getVin() + "|" + this.getYear() + "|" + this.getMake() + "|" + this.getModel() + "|" + this.getVehicleType() + "|"
                + this.getColor() + "|" + this.getOdometer() + "|" + df.format(this.getPrice());
    }

}
