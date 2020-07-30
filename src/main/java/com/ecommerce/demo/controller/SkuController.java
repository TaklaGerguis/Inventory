package com.ecommerce.demo.controller;

import com.ecommerce.demo.entity.Sku;
import com.ecommerce.demo.service.SkuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/skues")
public class SkuController {

    private SkuService skuService;

    @Autowired
    public SkuController(SkuService skuService) {
        this.skuService = skuService;
    }

    @GetMapping("/list")
    public String listSkues(Model model) {

        List<Sku> skues = skuService.getSkues();

        model.addAttribute("skues", skues);

        return "sku/list-skues";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model) {

        Sku sku = new Sku();

        model.addAttribute("sku", sku);

        return "sku/sku-form";
    }

    @PostMapping("/saveSku")
    public String saveSku(@ModelAttribute("sku") Sku sku) {

        skuService.save(sku);

        return "redirect:/skues/list";
    }


    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("skuId") Long id, Model model) {

        Sku sku = skuService.getSkuBuId(id);

        model.addAttribute("sku", sku);

        System.out.println(sku.getUnits());

        return "sku/sku-form";
    }

    @GetMapping("/delete")
    public String updateSku(@RequestParam("skuId") Long id) {

        skuService.deleteById(id);

        return "redirect:/skues/list";
    }

    @GetMapping("/search")
    public String searchCustomers(@RequestParam("searchName") String searchName, Model model) {

        List<Sku> skues = skuService.searchSkues(searchName);

        model.addAttribute("skues", skues);

        return "sku/list-skues";
    }


}
