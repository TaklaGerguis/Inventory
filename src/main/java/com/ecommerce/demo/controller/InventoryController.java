package com.ecommerce.demo.controller;

import com.ecommerce.demo.entity.Inventory;
import com.ecommerce.demo.entity.Sku;
import com.ecommerce.demo.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/inventories")
public class InventoryController {

    private InventoryService inventoryService;
    private SkuService skuService;
    private QuantityUnitService quantityUnitService;


    @Autowired
    public InventoryController(InventoryService inventoryService, SkuService skuService,
                               QuantityUnitService quantityUnitService) {

        this.inventoryService = inventoryService;
        this.skuService = skuService;
        this.quantityUnitService = quantityUnitService;
    }

    @GetMapping("/list")
    public String listInventories(Model model) {

        List<Inventory> inventories = inventoryService.findAll();

        model.addAttribute("inventories", inventories);

        return "Inventory/list-inventory";
    }

    @GetMapping("/inventoryForm")
    public String inventoryForm(@RequestParam("inventoryId") Long id, Model model) {

        Inventory inventory = inventoryService.findById(id);

        model.addAttribute("inventory", inventory);

        return "Inventory/inventory-form";
    }

    @PostMapping("/saveInventory")
    public String saveInventory(@ModelAttribute("inventory") Inventory inventory) {

        inventoryService.save(inventory);

        return "redirect:/inventories/list";
    }
}
