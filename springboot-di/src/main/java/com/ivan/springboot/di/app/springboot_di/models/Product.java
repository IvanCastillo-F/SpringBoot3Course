package com.ivan.springboot.di.app.springboot_di.models;

public class Product implements Cloneable {

    private Long id;
    private String name;
    private Long price;
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Long getPrice() {
        return price;
    }
    public void setPrice(Long price) {
        this.price = price;
    }
    
    public Product(Long id, String name, Long price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Product() {
    }

    @Override
    public Object clone() {
        // TODO Auto-generated method stub
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            // TODO Auto-generated catch block
            return new Product(this.getId(),this.getName(),this.getPrice());
        }
    }
    

}
