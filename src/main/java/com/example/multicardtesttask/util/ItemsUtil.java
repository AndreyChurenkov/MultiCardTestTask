package com.example.multicardtesttask.util;

import com.example.multicardtesttask.models.Item;
import com.example.multicardtesttask.models.Sale;

import java.util.List;

public class ItemsUtil {

    public static List<Item> prepareToSave(Sale saleFromDb) {
        List<Item> items = saleFromDb.getPurchaseItem();

        for (Item item : items)
            item.setSale(saleFromDb);

        return items;
    }
}
