package com.david.restful_crud_db.ws;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Products")
public class Product {

    private int id;
    private String name;
    private String descriptions;
    private int price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
