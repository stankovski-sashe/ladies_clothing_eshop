package com.ladywears.emtproekt.service;

import java.io.IOException;
import java.util.List;

import com.ladywears.emtproekt.model.Marka;

public interface MarkaService {
    List<Marka> findAll();
    Marka findById(Long id);
    Marka save(Marka Marka);
    Marka update(Long id, Marka Marka);
    Integer deleteById(Long id);
}
