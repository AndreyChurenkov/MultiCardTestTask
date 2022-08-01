package com.example.multicardtesttask.services;

import com.example.multicardtesttask.exceptions.NotFoundException;
import com.example.multicardtesttask.models.Item;
import com.example.multicardtesttask.models.Sale;
import com.example.multicardtesttask.repositories.ItemRepository;
import com.example.multicardtesttask.repositories.SaleRepository;
import com.example.multicardtesttask.util.ItemsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class SalesService {

    private final SaleRepository saleRepository;
    private final ItemRepository itemRepository;

    @Autowired
    public SalesService(SaleRepository saleRepository, ItemRepository itemRepository) {
        this.saleRepository = saleRepository;
        this.itemRepository = itemRepository;
    }

    public List<Sale> findAll() {
        return saleRepository.findAll();
    }

    public Sale getSaleById(int id) {
        return saleRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    public Optional<Sale> findById(int id) {
        return saleRepository.findById(id);
    }

    public Sale createWithItems(Sale sale) {
        if (sale.getPurchaseItem().isEmpty())
            throw new IllegalArgumentException();

        sale.setPurchaseDate(LocalDate.now());

        Sale saleFromDb = saleRepository.save(sale);

        itemRepository.saveAll(ItemsUtil.prepareToSave(saleFromDb));

        return saleFromDb;
    }

    public List<Sale> findSalesByWeek() {
        return saleRepository.findSalesByWeek();
    }

    public String findTopBuyerBySixMonth() {
        return saleRepository.findTopBuyerBySixMonth();
    }

    public void save(Sale sale) {
        saleRepository.save(sale);
    }

    public void deleteById(int id) {
        saleRepository.deleteById(id);
    }
}
