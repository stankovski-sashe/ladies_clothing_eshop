package com.ladywears.emtproekt.web.rest;

import com.ladywears.emtproekt.model.Marka;
import com.ladywears.emtproekt.service.MarkaService;
import org.springframework.web.bind.annotation.*;

//import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/brands")
public class MarkaRestController {


    private final MarkaService markaService;

    public MarkaRestController(MarkaService markaService) {
        this.markaService = markaService;
    }


    @GetMapping
    public List<Marka> findAll() {
        return this.markaService.findAll();
    }


    @GetMapping("/{id}")
    public Marka findById(@PathVariable Long id) {
        return this.markaService.findById(id);
    }

    @PostMapping
    public Marka save(/*@Valid*/ Marka marka) {
        return this.markaService.save(marka);
    }

    @PutMapping("/{id}")
    public Marka update(@PathVariable Long id, /*@Valid*/ Marka marka) {
        return this.markaService.update(id, marka);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        this.markaService.deleteById(id);
    }
}
