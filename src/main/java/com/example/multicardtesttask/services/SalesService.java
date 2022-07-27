package com.example.multicardtesttask.services;

import com.example.multicardtesttask.models.Sale;
import com.example.multicardtesttask.repositories.SaleRepository;
import com.example.multicardtesttask.util.error.SaleNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalesService {

    private final SaleRepository repository;

    @Autowired
    public SalesService(SaleRepository repository) {
        this.repository = repository;
    }

    public List<Sale> findAll() {
        return repository.findAll();
    }

    public List<Sale> findSaleById(int id) {
        return repository.findSaleById(id);
    }

    public Sale findById(int id) {
        return repository.findById(id).orElseThrow(SaleNotFoundException::new);
    }

    public List<Sale> findSalesByWeek() {
        return repository.findSalesByWeek();
    }

    public String findTopBuyerBySixMonth() {
        return repository.findTopBuyerBySixMonth();
    }

    public void save(Sale sale) {
        repository.save(sale);
    }

    public void deleteById(int id) {
        repository.deleteById(id);
    }
}
