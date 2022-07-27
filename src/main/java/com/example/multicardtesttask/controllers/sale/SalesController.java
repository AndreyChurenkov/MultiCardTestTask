package com.example.multicardtesttask.controllers.sale;

import com.example.multicardtesttask.models.Sale;
import com.example.multicardtesttask.repositories.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


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
    public String getSaleById(@ModelAttribute("sale") Sale sale) {
        repository.findSaleById(sale.getId());

        return "main_page";
    }

    @GetMapping("/new")
    public String newSale(@ModelAttribute("sale") Sale sale) {
        return "new";
    }

    @PostMapping
    public String create(@ModelAttribute("sale") Sale sale) {
        repository.save(sale);

        return "redirect:/sales";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable("id") int id, Model model) {
        model.addAttribute("sale", repository.findById(id).orElse(null));

        return "edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("sale") Sale sale) {
        repository.save(sale);

        return "redirect:/sales";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        repository.deleteById(id);

        return "redirect:/sales";
    }

    // Покупки за неделю
    @GetMapping("/by_week")
    public String getSalesByWeek(Model model) {
        model.addAttribute("sales", repository.findSalesByWeek());

        return "report/sales_by_month";
    }

    // Покупатель совершивший больше покупок за полгода
    @GetMapping("/top_buyer_by_six_month")
    public String getTopBuyerBySixMonth(Model model) {

        model.addAttribute("buyer", repository.findTopBuyerBySixMonth());

        return "report/top_buyer_by_six_month";
    }

}
