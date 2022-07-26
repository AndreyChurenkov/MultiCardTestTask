package com.example.multicardtesttask.repositories;

import com.example.multicardtesttask.models.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Integer> {

    List<Sale> findSaleById(int id);
}
