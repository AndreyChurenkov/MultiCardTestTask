package com.example.multicardtesttask.services;

import com.example.multicardtesttask.models.Item;
import com.example.multicardtesttask.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemsService {

    private final ItemRepository repository;

    @Autowired
    public ItemsService(ItemRepository repository) {
        this.repository = repository;
    }

    public List<Item> findAllBySale_Id(int id){
        return repository.findAllBySale_Id(id);
    }

    public void save(Item item) {
        repository.save(item);
    }

    public String findTopItemByMonth() {
        return repository.findTopItemByMonth();
    }

    public String findTopItemByBuyer18() {
        return repository.findTopItemByBuyer18();
    }
}
