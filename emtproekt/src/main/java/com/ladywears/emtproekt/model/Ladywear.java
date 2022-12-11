package com.ladywears.emtproekt.model;

import javax.persistence.*;

@Entity
@Table(name="ladywears")
public class Ladywear {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Float price;
    private Integer quantity;
    @Lob
    @Column(name = "image")
    private String base64Image;

    @ManyToOne
    private Marka marka;

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

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getBase64Image() {
        return base64Image;
    }

    public void setBase64Image(String base64Image) {
        this.base64Image = base64Image;
    }

    public Marka getMarka() {
        return marka;
    }
    public void setMarka(Marka marka) {
        this.marka = marka;
    }
}
