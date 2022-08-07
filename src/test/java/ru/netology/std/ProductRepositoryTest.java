package ru.netology.std;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductRepositoryTest {
    Product item1 = new Book(1, "Название 1", 1_000, "Автор 1");
    Product item2 = new Book(2, "Название 2", 2_000, "Автор 2");
    Product item3 = new Book(3, "Название 3", 3_000, "Автор 3");
    Product item4 = new Smartphone(4, "Название 4", 20_000, "Производитель 1");
    Product item5 = new Smartphone(5, "Название 5", 50_000, "Производитель 2");

    @Test
    public void shouldTryToRemoveProductFromArrayIfItemIsPresent() {
        ProductRepository repository = new ProductRepository();
        repository.save(item1);
        repository.save(item2);
        repository.save(item3);
        repository.removeById(3);

        Product[] expected = {item1, item2};
        Product[] actual = repository.getProducts();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldTryToAddProductToArrayIfItemIsNotAlreadyPresent() {
        ProductRepository repository = new ProductRepository();
        repository.save(item1);
        repository.save(item2);
        repository.save(item5);

        Product[] expected = {item1, item2, item5};
        Product[] actual = repository.getProducts();

        Assertions.assertArrayEquals(expected, actual);
    }

}
