package org.springframework.test.bean;

import org.springframework.beans.factory.annotation.Value;

import java.time.LocalDate;

public class CarConverter {

    private int price;

    private LocalDate produceDate;

    @Value("${brand}")
    private String brand;


    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public LocalDate getProduceDate() {
        return produceDate;
    }

    public void setProduceDate(LocalDate produceDate) {
        this.produceDate = produceDate;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "CarConverter{" +
                "price=" + price +
                ", produceDate=" + produceDate +
                ", brand='" + brand + '\'' +
                '}';
    }
}

