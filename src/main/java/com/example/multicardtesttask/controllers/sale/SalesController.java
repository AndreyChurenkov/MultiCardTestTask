package com.example.multicardtesttask.controllers.sale;

import com.example.multicardtesttask.models.Sale;
import com.example.multicardtesttask.repositories.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/sales")
public class SalesController {

    private final SaleRepository repository;

    @Autowired
    public SalesController(SaleRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public String getAllSales(Model model) {
        model.addAttribute("sales", repository.findAll());

        return "main_page";
    }

    @GetMapping("/{id}")
    public String getSaleById(@PathVariable("id") int id, Model model) {

        model.addAttribute("sales",  repository.findSaleById(id));

        return "main_page";
    }
}
