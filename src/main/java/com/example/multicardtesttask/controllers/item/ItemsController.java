package com.example.multicardtesttask.controllers.item;

import com.example.multicardtesttask.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/items")
public class ItemsController {

    private final ItemRepository repository;

    @Autowired
    public ItemsController(ItemRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/{id}")
    public String getItems(@PathVariable int id, Model model) {
        model.addAttribute("items", repository.findAllBySale_Id(id));

        return "items";
    }
}
