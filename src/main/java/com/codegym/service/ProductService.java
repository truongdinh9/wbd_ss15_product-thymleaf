package com.codegym.service;

import com.codegym.model.*;
import java.util.ArrayList;
import java.util.HashMap;

public class ProductService {
    private static HashMap products ;
    public int key=1;
    static {
        products = new HashMap<>();
        products.put(1, new Product(1, "candy", "add by Jone", 1.0));
        products.put(2, new Product(2, "Apple", "mail to bill@codegym.vn", 2.0));
        products.put(3, new Product(3, "computer", "ok", 3.0));

    }
    public ArrayList<Product> fillAll(){
        return new ArrayList<> (products.values());
    }
    public void save(Product product){
        products.put(product.getId(), product);
    }

    public Product findById(int id){
        return (Product) products.get(id);
    }

    public  void update(int id, Product product){
        products.put(id, product);

    }

    public void remove(int id){
        products.remove(id);
    }

}