package com.ladywears.emtproekt.service;

import java.io.IOException;
import java.util.List;

import com.ladywears.emtproekt.model.Ladywear;
import org.springframework.web.multipart.MultipartFile;



public interface LadywearService {

    List<Ladywear> findAll();
    Ladywear findById(Long id);
    List<Ladywear> findAllByMarkaId(Long markaId);
    Ladywear save(Ladywear ladywear, MultipartFile image) throws IOException;
    Ladywear update(Long id, Ladywear ladywear, MultipartFile image) throws IOException;
    void deleteById(Long id);

}
