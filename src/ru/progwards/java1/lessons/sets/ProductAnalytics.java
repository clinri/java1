package ru.progwards.java1.lessons.sets;

import java.util.*;

public class ProductAnalytics {
    class Product {
        private String code;

        public Product(String code) {
            this.code = code;
        }

        public String getCode() {
            return this.code;
        }

    }

    class Shop {
        private List<Product> products;

        public Shop(List<Product> products) {
            this.products = products;
        }

        public List<Product> getProducts() {
            return this.products;
        }
    }


    private List<Shop> shops;
    private List<Product> products;
    public ProductAnalytics(List<Product> products, List<Shop> shops) {
        this.shops=shops;
        this.products=products;
    }
    //2.13 Создать функцию public Set<Product> existInAll() - товары из products, которые имеются во всех магазинах
    public Set<Product> existInAll(){
        Set<Product> productInAllSops = new HashSet<>(this.products);
        for (Shop shop : shops)
            productInAllSops.retainAll(shop.products);
        return productInAllSops;
    }

    //2.14 Создать функцию public Set<Product> existAtListInOne() - товары из products,
    // которые имеются хотя бы в одном магазине
    public Set<Product> existAtListInOne(){
        Set<Product> productInOneShop = new HashSet<>();
        for (Shop shop : shops)
            productInOneShop.addAll(shop.products);
        Set<Product> result = new HashSet<>(this.products);
        result.retainAll(productInOneShop);
        return productInOneShop;
    }

    //2.15 Создать функцию public Set<Product> notExistInShops() - товары из products, которых нет ни в одном магазине
    public Set<Product> notExistInShops(){
        Set<Product> productInAllShop = new HashSet<>();
        for (Shop shop : shops)
            productInAllShop.addAll(shop.products);
        Set<Product> result = new HashSet<>(this.products);
        result.removeAll(productInAllShop);
        return result;
    }

    //2.16 Создать функцию public Set<Product> existOnlyInOne() - товары
    // из products, которые есть только в одном магазине
    public Set<Product> existOnlyInOne(){
        Set<Product> productsAllIntersection = new HashSet<>();
        Set<Product> productsAllShops = new HashSet<>();
        for (Shop shop : shops) {
            productsAllShops.addAll(shop.products);
            List<Shop> listShopsX = new ArrayList(shops);
            listShopsX.remove(shop);
            Set<Product> productsInTwoShop = new HashSet<>(); // пересечение одного с другими множествами
            for (Shop shopCut : listShopsX) {
                if (productsInTwoShop.size() == 0)
                    productsInTwoShop.addAll(shop.products);
                else
                    productsInTwoShop.retainAll(shop.products);
            }
            if (productsAllIntersection.size() == 0)
                productsAllIntersection.addAll(productsInTwoShop);
            else
                productsAllIntersection.addAll(productsInTwoShop); // объединение пересений множеств товаров которые есть в более чем одном магазине
        }
        productsAllShops.removeAll(productsAllIntersection); // исключаем продукты котоыре есть в более чем одном магазине
        productsAllShops.retainAll(products); // пересечение с products
        return productsAllShops;


    }
}
