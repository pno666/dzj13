package ru.netology.std;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductManagerTest {
    Product item1 = new Book(1, "Название 1", 1_000, "Автор 1");
    Product item2 = new Book(2, "Название 2", 2_000, "Автор 2");
    Product item3 = new Book(3, "Название 3", 3_000, "Автор 3");
    Product item4 = new Smartphone(4, "Название 4", 20_000, "Производитель 1");
    Product item5 = new Smartphone(5, "Название 5", 50_000, "Производитель 2");
    @Test
    public void shouldAddNewProducts() {
        ProductManager manager = new ProductManager(new ProductRepository());
        manager.add(item1);
        manager.add(item2);
        manager.add(item4);

        Product[] expected = {item1, item2, item4};
        Product[] actual = manager.getProducts();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddNewProductsAndRemove() {
        ProductManager manager = new ProductManager(new ProductRepository());
        manager.add(item1);
        manager.add(item2);
        manager.add(item5);
        manager.removeById(item2.getId());

        Product[] expected = {item1, item5};
        Product[] actual = manager.getProducts();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchedItemByRequestIfNoProductsInArray() {
        ProductManager manager = new ProductManager(new ProductRepository());

        Product[] expected = {};
        Product[] actual = manager.searchBy("Автор 2");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchedItemByRequestIfOneProductInArrayAndOneItemIsPresent() {
        ProductManager manager = new ProductManager(new ProductRepository());
        manager.add(item1);

        Product[] expected = {item1};
        Product[] actual = manager.searchBy("Название 1");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchedItemByRequestIfOneProductInArrayAndNoItemIsPresent() {
        ProductManager manager = new ProductManager(new ProductRepository());
        manager.add(item1);

        Product[] expected = {};
        Product[] actual = manager.searchBy("Название 2");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchedItemByRequestIfSomeProductsInArrayAndOneItemIsPresent() {
        ProductManager manager = new ProductManager(new ProductRepository());
        manager.add(item1);
        manager.add(item2);
        manager.add(item3);

        Product[] expected = {item2};
        Product[] actual = manager.searchBy("Название 2");

        Assertions.assertArrayEquals(expected, actual);
    }


    @Test
    public void shouldSearchedItemByRequestIfSomeProductsInArrayButItemIsNotPresent() {
        ProductManager manager = new ProductManager(new ProductRepository());
        manager.add(item1);
        manager.add(item2);
        manager.add(item3);

        Product[] expected = {};
        Product[] actual = manager.searchBy("Война и мир");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchSimilarTitles (){
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);

        Product item1 = new Book(1, "Супер", 100, "Суперов");
        Product item2 = new Book(2, "Молодец", 200, "Молодцов");
        Product item3 = new Smartphone(3, "Iphone13", 300, "AppleReplica");
        Product item4 = new Smartphone(4, "Iphone13", 1300, "Apple");

        manager.add(item1);
        manager.add(item2);
        manager.add(item3);
        manager.add(item4);
        Product[] expected = {item3, item4};
        Product[] actual = manager.searchBy("Iphone13");
        Assertions.assertArrayEquals(expected, actual);
    }

}
