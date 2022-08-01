package com.example.multicardtesttask.controllers.sale;

import com.example.multicardtesttask.models.Sale;
import com.example.multicardtesttask.services.ItemsService;
import com.example.multicardtesttask.services.SalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/sales")
public class SaleRestController {

    private final SalesService salesService;

    @Autowired
    public SaleRestController(SalesService salesService) {
        this.salesService = salesService;
    }


    @GetMapping()
    public ResponseEntity<List<Sale>> getAll() {
        try {
            List<Sale> sales = new ArrayList<>();

            salesService.findAll().forEach(sales::add);

            if (sales.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(sales, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sale> getSaleById(@PathVariable("id") int id) {
        Optional<Sale> optional = salesService.findById(id);

        if (optional.isPresent()) {
            return new ResponseEntity<>(optional.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping()
    public ResponseEntity<Sale> createSale(@Valid @RequestBody Sale sale) {
        try {
            Sale saleFromDb = salesService.createWithItems(sale);


            return new ResponseEntity<>(saleFromDb, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }



}
