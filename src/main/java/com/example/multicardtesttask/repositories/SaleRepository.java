package com.example.multicardtesttask.repositories;

import com.example.multicardtesttask.models.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Integer> {

    List<Sale> findSaleById(int id);

    // Покупки за неделю
    @Query(value = "SELECT * FROM sales\n" +
            "WHERE sales.purchase_date BETWEEN(current_date - interval'1 week') AND (current_date)\n" +
            "ORDER BY sales.purchase_date DESC",  nativeQuery = true)
    List<Sale> findSalesByWeek();

    // Покупатель совершивший больше покупок за полгода
    @Query(value = "SELECT concat(name, ' ', lastname) as name_lastname\n" +
            "FROM sales\n" +
            "WHERE purchase_date BETWEEN(current_date - interval'6 month') AND (current_date)\n" +
            "GROUP BY name_lastname\n" +
            "ORDER BY count(concat(name, lastname)) DESC\n" +
            "LIMIT 1", nativeQuery = true)
    String findTopBuyerBySixMonth();

}
