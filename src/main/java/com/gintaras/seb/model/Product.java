package com.gintaras.seb.model;

/**
 * Represents product offer. Holds needed information to display to the user.
 *
 * @author gintaras
 */
public class Product {

    /**
     * Product name.
     */
    private String name;
    /**
     * Image to display along with the product.
     */
    private String image;

    public Product() {
    }

    public Product(String name, String image) {
        this.name = name;
        this.image = image;
    }

    public Product(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
