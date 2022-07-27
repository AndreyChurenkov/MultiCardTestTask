package com.example.multicardtesttask.controllers.item;

import com.example.multicardtesttask.models.Item;
import com.example.multicardtesttask.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/items")
public class ItemsController {

    private final ItemRepository repository;

    @Autowired
    public ItemsController(ItemRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/{id}")
    public String getItems(Model model, @PathVariable("id") int id) {
        model.addAttribute("items", repository.findAllBySale_Id(id));

        return "items";
    }

    @PostMapping("/{id}")
    public void createOrUpdateItems(@ModelAttribute("item") Item item) {
        repository.save(item);
    }

    // Самый продаваемый товар за месяц
    @GetMapping("/top_by_month")
    public String getTopItemByMonth(Model model) {
        model.addAttribute("item", repository.findTopItemByMonth());

        return "report/top_item_by_month";
    }

    // Самый продаваемый товар у людей в возрасте 18 лет
    @GetMapping("/top_by_buyer18")
    public String getTopItemByBuyer18(Model model) {
        model.addAttribute("item", repository.findTopItemByBuyer18());

        return "report/top_item_by_buyer18";
    }
}
