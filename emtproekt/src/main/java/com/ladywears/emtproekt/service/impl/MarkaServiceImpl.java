package com.ladywears.emtproekt.service.impl;

import com.ladywears.emtproekt.model.Marka;
import com.ladywears.emtproekt.service.MarkaService;

import com.ladywears.emtproekt.model.exceptions.MarkaNotFoundException;

import com.ladywears.emtproekt.repository.LadywearRepository;
import com.ladywears.emtproekt.repository.MarkaRepository;

import org.springframework.stereotype.Service;

//import com.ladywears.emtproekt.model.exceptions.ThereAreLadywearWithThisMarkaException;

import java.util.List;

@Service
public class MarkaServiceImpl implements MarkaService {

    private final MarkaRepository MarkaRepository;
    private final LadywearRepository LadywearRepository;

    public MarkaServiceImpl(MarkaRepository MarkaRepository, LadywearRepository LadywearRepository) {
        this.MarkaRepository = MarkaRepository;
        this.LadywearRepository = LadywearRepository;
    }

    @Override
    public List<Marka> findAll() {
        return this.MarkaRepository.findAll();
    }

    @Override
    public Marka findById(Long id) {
        return this.MarkaRepository.findById(id)
                .orElseThrow(() -> new MarkaNotFoundException(id));
    }

    @Override
    public Marka save(Marka Marka) {
        return this.MarkaRepository.save(Marka);
    }

    @Override
    public Marka update(Long id, Marka Marka) {
        Marka updatedMarka = this.findById(id);

        updatedMarka.setName(Marka.getName());
        return this.MarkaRepository.save(updatedMarka);
    }

    @Override
    public Integer deleteById(Long id) {

        return this.MarkaRepository.removeById(id);

    }

/*    @Override
    public void deleteById(Long id) {
        Marka Marka = this.findById(id);
//        if (this.LadywearRepository.existsByMarkaId(id)) {
//            throw new ThereAreLadywearWithThisMarkaException(id);
//        }
        if (Marka.getLadywears().size() > 0) {
            throw new ThereAreLadywearWithThisMarkaException(id);
        }
        this.MarkaRepository.removeById(id);
    }*/
}
