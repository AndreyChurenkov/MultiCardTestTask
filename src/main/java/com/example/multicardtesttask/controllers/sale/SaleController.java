package com.example.multicardtesttask.controllers.sale;

import com.example.multicardtesttask.exceptions.NotFoundException;
import com.example.multicardtesttask.models.Sale;
import com.example.multicardtesttask.services.SalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/sales")
public class SaleController {

    private final SalesService service;

    @Autowired
    public SaleController(SalesService service) {
        this.service = service;
    }

    @GetMapping
    public String getAllSales(Model model) {
        model.addAttribute("sales", service.findAll());

        return "sales/sales";
    }

    @GetMapping("/{id}")
    public String getSaleById(@PathVariable("id") int id, Model model) {
        model.addAttribute("sale", service.getSaleById(id));

        return "sales/sale";
    }

    @GetMapping("/new")
    public String newSale(@ModelAttribute("sale") Sale sale) {
        return "sales/new";
    }

    @PostMapping
    public String create(@ModelAttribute("sale") Sale sale) {
        service.save(sale);

        return "redirect:";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable("id") int id, Model model) {
        model.addAttribute("sale", service.getSaleById(id));

        return "sales/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("sale") Sale sale) {
        service.save(sale);

        return "redirect:";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        service.deleteById(id);

        return "redirect:";
    }

    // Покупки за неделю
    @GetMapping("/by_week")
    public String getSalesByWeek(Model model) {
        model.addAttribute("sales", service.findSalesByWeek());

        return "report/sales_by_month";
    }

    // Покупатель совершивший больше покупок за полгода
    @GetMapping("/top_buyer_by_six_month")
    public String getTopBuyerBySixMonth(Model model) {

        model.addAttribute("buyer", service.findTopBuyerBySixMonth());

        return "report/top_buyer_by_six_month";
    }

}
