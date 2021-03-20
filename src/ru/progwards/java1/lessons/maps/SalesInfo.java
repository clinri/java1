package ru.progwards.java1.lessons.maps;
//Информация по продажам
//
//Во входном файле находятся данные в CSV формате, CSV - Comma Separated Values, значения разделенные запятыми.
// Каждая строка - данные об одной покупке. Входные данные
//
//ФИ покупателя, наименование товара, количество, сумма
//
//String, String, int, double
//
//
//Пример
//
//
//Иванов Сергей, iPhone 10X, 2, 150000
//Петрова Анна, наушники JBL, 2, 7000
//Иванов Сергей, чехол для iPhone, 1, 1000
//Петрова Анна, пакет пластиковый, 1, 3
//Радж Кумар, батарейка ААА, 1, 150
//Михаил Цикло, iPhone 10X, 1, 75000
//Радж Кумар, пакет пластиковый, 1, 3
//Михаил Цикло, пакет пластиковый, 1, 3
//Иванов Сергей, стекло защитное, 1, 1000
//Василий Пупкин, спички, 10, 10
//
//…

import java.io.File;
import java.util.*;

public class SalesInfo {
    ArrayList<SalesInfo> listSales;
    String fio;
    String product;
    Integer volume;
    Double sum;

    SalesInfo(String fio, String product, Integer volume, Double sum) {
        this.fio = fio;
        this.product = product;
        this.volume = volume;
        this.sum = sum;
    }

    public SalesInfo() {
    }

    //3.1 Реализовать метод public int loadOrders(String fileName) - вернуть количество успешно загруженных строк.
    // Если в строке более или менее 4-x полей, или количество и сумма не преобразуются в числа - эту строку не загружаем.
    public int loadOrders(String fileName) {
        listSales = new ArrayList<>();
        List<String> vals;
        try (Scanner scanner = new Scanner(new File(fileName))) {
            while (scanner.hasNextLine()) {
                vals = Arrays.asList(scanner.nextLine().split(","));
                if (vals.size() == 4)
                    listSales.add(new SalesInfo(
                            vals.get(0),
                            vals.get(1),
                            Integer.parseInt(vals.get(2).replace(" ","")),
                            Double.parseDouble(vals.get(3).replace(" ",""))));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        listSales.trimToSize();
        return listSales.size();
    }

    //3.2 Реализовать метод public Map<String, Double> getGoods() - вернуть список товаров,
    // отсортированный по наименованию товара. В String - наименование товара, в Double - общая сумма продаж по товару
    public Map<String, Double> getGoods() {
        Map<String, Double> sortSales = new TreeMap<>();
        for (SalesInfo sales : listSales) {
            sortSales.put(sales.product, sales.sum);
        }
        return sortSales;
    }

    //3.3 Реализовать метод public Map<String, AbstractMap.SimpleEntry<Double, Integer>> getCustomers() - вернуть
    // список покупателей, отсортированный по алфавиту. В String  - ФИ, в Double - сумма всех покупок покупателя,
    // в Integer - количество покупок
    public Map<String, AbstractMap.SimpleEntry<Double, Integer>> getCustomers() {
        Map<String, AbstractMap.SimpleEntry<Double, Integer>> sortSales = new TreeMap<>();
        for (SalesInfo sales : listSales) {
            sortSales.put(sales.fio, new AbstractMap.SimpleEntry<>(sales.sum, sales.volume));
        }
        return sortSales;
    }

    public static void main(String[] args) {
        SalesInfo newSales = new SalesInfo();
        System.out.println(newSales.loadOrders("src/sales"));
        System.out.println(newSales.getGoods());
        System.out.println(newSales.getCustomers());
    }

}

