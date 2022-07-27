package com.example.multicardtesttask.repositories;

import com.example.multicardtesttask.models.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {

    List<Item> findAllBySale_Id(int id);

    // Самый продаваемый товар за месяц
    @Query(value = "SELECT items.name\n" +
            "FROM items\n" +
            "WHERE items.sale_id IN (SELECT sales.id\n" +
            "FROM sales\n" +
            "WHERE sales.purchase_date BETWEEN(current_date - interval'1 month') " +
            "AND (current_date))\n" +
            "GROUP BY items.name\n" +
            "ORDER BY COUNT(items.name) DESC\n" +
            "LIMIT 1", nativeQuery = true)
    String findTopItemByMonth();

    // Самый продаваемый товар у людей в возрасте 18 лет
    @Query(value = "SELECT name\n" +
            "FROM items\n" +
            "WHERE sale_id IN (SELECT sales.id FROM sales\n" +
            "                 WHERE sales.age = '18')\n" +
            "GROUP BY name\n" +
            "ORDER BY count(name) DESC\n" +
            "LIMIT 1", nativeQuery = true)
    String findTopItemByBuyer18();

}
