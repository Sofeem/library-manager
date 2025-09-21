package com.example.library;

import java.util.*;
import java.util.stream.Collectors;

public class Library {
    private List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public boolean removeBook(int id) {
        return books.removeIf(b -> b.getId() == id);
    }

    public List<Book> findByAuthor(String author) {
        return books.stream()
                .filter(b -> b.getAuthor().equalsIgnoreCase(author))
                .collect(Collectors.toList());
    }

    public List<String> getAllTitlesUppercase() {
        return books.stream()
                .map(b -> b.getTitle().toUpperCase())
                .collect(Collectors.toList());
    }

    public List<Book> getBooksSortedByTitle() {
        return books.stream()
                .sorted(Comparator.comparing(Book::getTitle))
                .collect(Collectors.toList());
    }

    public int size() {
        return books.size();
    }
}
