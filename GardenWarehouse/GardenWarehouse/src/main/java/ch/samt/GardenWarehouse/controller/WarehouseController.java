package ch.samt.GardenWarehouse.controller;


import ch.samt.GardenWarehouse.data.WarehouseRepository;
import ch.samt.GardenWarehouse.model.Item;
import ch.samt.GardenWarehouse.service.WarehouseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class WarehouseController {
    private WarehouseService warehouseService;

    @Autowired
    public WarehouseController(WarehouseRepository warehouseRepository) {
        this.warehouseService = new WarehouseService(warehouseRepository);
    }

    @GetMapping("/items")
    public String loadItems(Model model) {
        model.addAttribute("items", warehouseService.getAllItems());
        return "itemsList";
    }
    @GetMapping("/items/{code}")
    public String loadItemsByCode(Model model, @PathVariable String code) {
        if(warehouseService.getItemByCode(code).isEmpty()) {
            model.addAttribute("error", "Item with code " + code + " doesn't exist");
        }
        else {
            model.addAttribute("items", List.of(warehouseService.getItemByCode(code).get())); // wrappo in una list senno thymeleaf bestemmia
            return "itemsList";
        }
        return "errorPage";
    }
    @GetMapping("/items/sell")
    public String sellItem(Model model, @RequestParam(value="code") String code) {
        if(warehouseService.getItemByCode(code).isEmpty()) {
            model.addAttribute("error", "Item with code " + code + " doesn't exist");
        }
        else {
            warehouseService.sellItemByCode(code);
            model.addAttribute("items", warehouseService.getItemByCode(code));
            return "redirect:/items/" + code;
        }
        return "errorPage";
    }
    @GetMapping("/items/add")
    public String addItem(Model model, @RequestParam(value="code") String code, @RequestParam(value="number", required=false) int number) {
        if(warehouseService.getItemByCode(code).isEmpty()) {
            model.addAttribute("error", "Item with code " + code + " doesn't exist");
        }
        else {
            warehouseService.addItemByCode(code, number);
            model.addAttribute("items", warehouseService.getItemByCode(code));
            return "redirect:/items/" + code;
        }
        return "errorPage";
    }
    @GetMapping("/items/insert")
    public String loadInsertPage(Model model) {
        model.addAttribute("item", new Item());
        return "insertItem";
    }
    @PostMapping("/insert")
    public String insertItem(@Valid @ModelAttribute("item") Item item, Errors errors) {
        if (errors.hasErrors()) {
            return "insertItem";
        }
        warehouseService.saveItem(item);
        return "redirect:/items";
    }
}
