package org.example;

class Laptop {
    private String brand;
    private int ram;
    private int hddCapacity;
    private String operatingSystem;
    private String color;

    public Laptop(String brand, int ram, int hddCapacity, String operatingSystem, String color) {
        this.brand = brand;
        this.ram = ram;
        this.hddCapacity = hddCapacity;
        this.operatingSystem = operatingSystem;
        this.color = color;
    }

    public String getBrand() {
        return brand;
    }

    public int getRam() {
        return ram;
    }

    public int getHddCapacity() {
        return hddCapacity;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public String getColor() {
        return color;
    }
}

