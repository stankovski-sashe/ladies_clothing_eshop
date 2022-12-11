package com.ladywears.emtproekt.service.impl;

import com.ladywears.emtproekt.model.Ladywear;
import com.ladywears.emtproekt.repository.LadywearRepository;
import com.ladywears.emtproekt.model.exceptions.LadywearNotFoundException;
import com.ladywears.emtproekt.service.LadywearService;

import com.ladywears.emtproekt.service.MarkaService;
import com.ladywears.emtproekt.model.Marka;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

@Service
public class LadywearServiceImpl implements LadywearService {

    private final LadywearRepository ladywearRepository;
    private final MarkaService markaService;

    public LadywearServiceImpl(LadywearRepository ladywearRepository ,MarkaService markaService) {
        this.ladywearRepository = ladywearRepository;
        this.markaService = markaService;
    }

    @Override
    public List<Ladywear> findAll() {
        return this.ladywearRepository.findAll();
    }

    @Override
    public Ladywear findById(Long id) {

        return this.ladywearRepository.findById(id)
                .orElseThrow(() -> new LadywearNotFoundException(id));
        //return this.ladywearRepository.getOne(id);
    }

    @Override
    public List<Ladywear> findAllByMarkaId(Long markaId) {
        return null;
    }

//    @Override
//    public Ladywear save(Ladywear ladywear, MultipartFile image) throws IOException {
//        return null;
//    }

    @Override
    public Ladywear save(Ladywear ladywear, MultipartFile image) throws IOException {
        Marka marka = this.markaService.findById(ladywear.getMarka().getId());
        ladywear.setMarka(marka);
        if (image != null) {
            byte[] imageBytes = image.getBytes();
            String base64Image = String.format("data:%s;base64,%s", image.getContentType(), Base64.getEncoder().encodeToString(imageBytes));
            ladywear.setBase64Image(base64Image);
        }
        return this.ladywearRepository.save(ladywear);
    }

//    @Override
//    public Ladywear update(Long id, Ladywear ladywear, MultipartFile image) throws IOException {
//        return null;
//    }

    @Override
    public Ladywear update(Long id, Ladywear ladywear, MultipartFile image) throws IOException {
        Ladywear updatedLadywear = this.findById(id);
        Marka marka = this.markaService.findById(ladywear.getMarka().getId());
        updatedLadywear.setMarka(marka);
        updatedLadywear.setName(ladywear.getName());
        updatedLadywear.setQuantity(ladywear.getQuantity());
        updatedLadywear.setPrice(ladywear.getPrice());
        if (image != null) {
            byte[] imageBytes = image.getBytes();
            String base64Image = String.format("data:%s;base64,%s", image.getContentType(), Base64.getEncoder().encodeToString(imageBytes));
            updatedLadywear.setBase64Image(base64Image);
        }
        return this.ladywearRepository.save(updatedLadywear);
    }

    @Override
    public void deleteById(Long id) {
        this.ladywearRepository.deleteById(id);
    }



}
