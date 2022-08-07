package ru.netology.std;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BookTest {

    @Test
    public void shouldFindItemByName() {
        Book book = new Book(1, "Название 1", 800, "Писатель 1");

        boolean expected = true;
        boolean actual = book.matches(book, "Название 1");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindItemByAuthor() {
        Book book = new Book(2, "Название 2", 300, "Писатель 2");

        boolean expected = true;
        boolean actual = book.matches(book, "Писатель");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindItemByTextIfNoOneItemPresent() {
        Book book = new Book(3, "Название 3", 555, "Писатель 3");

        boolean expected = false;
        boolean actual = book.matches(book, "Художник");

        Assertions.assertEquals(expected, actual);
    }
}
