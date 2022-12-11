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
@RequestMapping("/cart")
public class CartController {

    private final LadywearService ladywearService;
    private final MarkaService markaService;

    public CartController(LadywearService ladywearService, MarkaService markaService) {

        this.ladywearService = ladywearService;
        this.markaService = markaService;
    }

    @GetMapping
    public String listCartPage(Marka marka,Model model) {
        List<Ladywear> ladywears = this.ladywearService.findAll();
        model.addAttribute("products", ladywears);
        model.addAttribute("edenBrand", marka);
        return "cart";
    }


}

