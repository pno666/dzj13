package ru.netology.std;

public class Book extends Product {

    private String author;

    public String getAuthor() {
        return author;
    }


    public Book(int id, String name, int price, String author) {
        super(id, name, price);
        this.author = author;
    }

    @Override
    public boolean matches(Product product, String search) {
        if (super.matches(product, search)) {
            return true;
        }
        return getAuthor().contains(search);
    }
}
