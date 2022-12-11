package com.ladywears.emtproekt.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "marki")
public class Marka{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;


    @OneToMany(mappedBy = "marka")
    List<Ladywear> ladywears;

    public Marka() {
    }

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


}
