package com.ladywears.emtproekt.web.controller;

import com.ladywears.emtproekt.model.Ladywear;
import com.ladywears.emtproekt.service.LadywearService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;

import com.ladywears.emtproekt.model.Marka;
import com.ladywears.emtproekt.service.MarkaService;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

import java.io.IOException;

@Controller
@RequestMapping("/products")
public class LadywearController {

    private final LadywearService ladywearService;
    private final MarkaService markaService;

    public LadywearController(LadywearService ladywearService, MarkaService markaService) {

        this.ladywearService = ladywearService;
        this.markaService = markaService;
    }

    @GetMapping
    public String listLadywearsPage(Model model) {
        List<Ladywear> ladywears = this.ladywearService.findAll();
        model.addAttribute("products", ladywears);
        return "products";
    }
    @GetMapping("/add-new")
    public String addNewLadywearPage(Model model) {
        List<Marka> brands = this.markaService.findAll();
        model.addAttribute("product", new Ladywear());
        model.addAttribute("brendovi", brands);
        return "add-product";
    }

//    @PostMapping
//    public String saveOrUpdateLadywear(
//            Model model,
//            Ladywear ladywear
//    )throws IOException{
//        Ladywear newladywear = this.ladywearService.save(ladywear,null);
//        return "redirect:/products";
//    }

    @PostMapping
    public String saveOrUpdateLadywear(
            Model model,
            Ladywear ladywear,
            @RequestParam MultipartFile image) throws IOException {
        try {
            if (ladywear.getId() == null) {
                this.ladywearService.save(ladywear, image);
            } else {
                this.ladywearService.update(ladywear.getId(), ladywear, image);
            }
            return "redirect:/products";
        } catch (RuntimeException ex) {
            return "redirect:/products/add-new?error=" + ex.getLocalizedMessage();
        }
    }

    @GetMapping("/{id}/edit")
    public String editLadywearPage(@PathVariable Long id, Model model) {
        try {
            Ladywear ladywear = this.ladywearService.findById(id);
            List<Marka> brands = this.markaService.findAll();
            model.addAttribute("product", ladywear);
            model.addAttribute("brendovi", brands);
            return "add-product";
        } catch (RuntimeException ex) {
            return "redirect:/products?error="+ ex.getLocalizedMessage();
        }
    }

    @DeleteMapping("/{id}/delete")
    public String deleteWithDelete(@PathVariable Long id) {
        this.ladywearService.deleteById(id);
        return "redirect:/products";
    }

    @PostMapping("/{id}/delete")
    public String deleteLadywearWithPost(@PathVariable Long id) {
        this.ladywearService.deleteById(id);
        return "redirect:/products";
    }

}
