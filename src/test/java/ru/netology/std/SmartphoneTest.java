package ru.netology.std;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SmartphoneTest {

    @Test
    public void shouldFindItemByNameOfSmartphone() {
        Smartphone smartphone = new Smartphone(1, "Название 1", 13_000, "Производитель 1");

        boolean expected = true;
        boolean actual = smartphone.matches(smartphone, "Название 1");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindItemByManufacturer() {
        Smartphone smartphone = new Smartphone(5, "Название 2", 100_000, "Производитель 2");

        boolean expected = true;
        boolean actual = smartphone.matches(smartphone, "Производитель 2");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindItemByTextIfNoOneItemPresent() {
        Smartphone smartphone = new Smartphone(5, "Название 3", 500_000, "Производитель");

        boolean expected = false;
        boolean actual = smartphone.matches(smartphone, "Писатель");

        Assertions.assertEquals(expected, actual);
    }
}
