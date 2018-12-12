package com.cheetah.client.beans;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "PRODUCTS")
public class Product implements Serializable {

    private String product_name;
    private String photo_url;
    private String barcode;
    private String price_cents;
    @Id
    private String sku;
    private String producer;

    public Product() {
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getPhoto_url() {
        return photo_url;
    }

    public void setPhoto_url(String photo_url) {
        this.photo_url = photo_url;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getPrice_cents() {
        return price_cents;
    }

    public void setPrice_cents(String price_cents) {
        this.price_cents = price_cents;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    @Override
    public String toString() {
        return "Product{" +
                "product_name='" + product_name + '\'' +
                ", photo_url='" + photo_url + '\'' +
                ", barcode='" + barcode + '\'' +
                ", price_cents='" + price_cents + '\'' +
                ", sku='" + sku + '\'' +
                ", producer='" + producer + '\'' +
                '}';
    }

}
