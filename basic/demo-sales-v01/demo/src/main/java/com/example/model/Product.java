package com.example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String qrcode;
    private String name;
    private String description;
    private double price;
    private double purchase_price;
    private double discount_sell_value;
    
    public Product(Long id, String qrcode, String name, String description, double price, double purchase_price,
            double discount_sell_value) {
        this.id = id;
        this.qrcode = qrcode;
        this.name = name;
        this.description = description;
        this.price = price;
        this.purchase_price = purchase_price;
        this.discount_sell_value = discount_sell_value;
    } 

    /**
     * @return Long return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return String return the qrcode
     */
    public String getQrcode() {
        return qrcode;
    }

    /**
     * @param qrcode the qrcode to set
     */
    public void setQrcode(String qrcode) {
        this.qrcode = qrcode;
    }

    /**
     * @return String return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return String return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return double return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * @return double return the purchase_price
     */
    public double getPurchase_price() {
        return purchase_price;
    }

    /**
     * @param purchase_price the purchase_price to set
     */
    public void setPurchase_price(double purchase_price) {
        this.purchase_price = purchase_price;
    }

    /**
     * @return double return the discount_sell_value
     */
    public double getDiscount_sell_value() {
        return discount_sell_value;
    }

    /**
     * @param discount_sell_value the discount_sell_value to set
     */
    public void setDiscount_sell_value(double discount_sell_value) {
        this.discount_sell_value = discount_sell_value;
    }

}
