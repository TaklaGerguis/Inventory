package com.ecommerce.demo.controller;

import com.ecommerce.demo.entity.QuantityUnit;
import com.ecommerce.demo.entity.Sku;
import com.ecommerce.demo.service.QuantityUnitService;
import com.ecommerce.demo.service.SkuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/QuantityUnits")
public class QuantityUnitController {

    private QuantityUnitService quantityUnitService;
    private SkuService skuService;

    @Autowired
    public QuantityUnitController(QuantityUnitService quantityUnitService, SkuService skuService) {
        this.quantityUnitService = quantityUnitService;
        this.skuService = skuService;
    }

    @GetMapping("/details")
    public String getQuantityUnits(@RequestParam("skuId") Long id, Model model) {

        Sku sku = skuService.getSkuBuId(id);

        System.out.println(sku);

        List<QuantityUnit> quantityUnits = sku.getUnits();

        System.out.println(quantityUnits);

        System.out.println(sku);

//        List<QuantityUnit> quantityUnits = quantityUnitService.findBySku(sku);

        System.out.println(quantityUnits);

        model.addAttribute("quantityUnits", quantityUnits);

        return "unit/sku-details";
    }

    @GetMapping("/unitForm")
    public String addQuantityUnits(@RequestParam("skuId") Long id, Model model) {

        System.out.println(id);

        QuantityUnit quantityUnit = new QuantityUnit();

        model.addAttribute("quantityUnit", quantityUnit);

       Sku sku = skuService.getSkuBuId(id);

        quantityUnit.setSku(sku);
//
//        quantityUnit.setName("Temp");

      quantityUnitService.save(quantityUnit);
//
//        System.out.println(sku.getName());

        System.out.println(quantityUnit);

        return "unit/unit-form";
    }


    //    @GetMapping("/showFormForAdd")
//    public String showFormForAdd(Model model) {
//
//        Sku sku = new Sku();
//
//        model.addAttribute("sku", sku);
//
//        return "sku/sku-form";
//    }
//
    @PostMapping("/saveQuantityUnit")
    public String saveQuantityUnit( //@RequestParam("skuId") Long id,
                                   @ModelAttribute("quantityUnit") QuantityUnit quantityUnit) {


        System.out.println(quantityUnit);

       // Sku sku = skuService.getSkuBuId(id);

       // quantityUnit.setSku(sku);

        quantityUnitService.save(quantityUnit);

        System.out.println(quantityUnit);

        return "redirect:/skues/list";
    }


}
