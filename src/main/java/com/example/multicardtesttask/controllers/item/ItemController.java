package com.example.multicardtesttask.controllers.item;

import com.example.multicardtesttask.models.Item;
import com.example.multicardtesttask.repositories.ItemRepository;
import com.example.multicardtesttask.services.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/items")
public class ItemController {

    private final ItemsService service;

    @Autowired
    public ItemController(ItemsService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public String getItems(Model model, @PathVariable("id") int id) {
        model.addAttribute("items", service.findAllBySale_Id(id));

        return "sales/items";
    }

    // Самый продаваемый товар за месяц
    @GetMapping("/top_by_month")
    public String getTopItemByMonth(Model model) {
        model.addAttribute("item", service.findTopItemByMonth());

        return "report/top_item_by_month";
    }

    // Самый продаваемый товар у людей в возрасте 18 лет
    @GetMapping("/top_by_buyer18")
    public String getTopItemByBuyer18(Model model) {
        model.addAttribute("item", service.findTopItemByBuyer18());

        return "report/top_item_by_buyer18";
    }
}
