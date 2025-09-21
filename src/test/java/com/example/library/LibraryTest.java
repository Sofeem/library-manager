package com.example.library;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LibraryTest {

    private Library library;

    @BeforeEach
    void setup() {
        library = new Library();
        library.addBook(new Book(1, "Java Basics", "Alice", 150));
        library.addBook(new Book(2, "Advanced Java", "Bob", 300));
        library.addBook(new Book(3, "Spring Boot", "Alice", 250));
    }

    @Test
    void testAddBook() {
        int sizeBefore = library.size();
        library.addBook(new Book(4, "Kubernetes Guide", "Charlie", 200));
        assertEquals(sizeBefore + 1, library.size());
    }

    @Test
    void testRemoveBook() {
        assertTrue(library.removeBook(1));
        assertFalse(library.removeBook(99));
    }

    @Test
    void testFindByAuthor() {
        List<Book> books = library.findByAuthor("Alice");
        assertEquals(2, books.size());
    }

    @Test
    void testGetAllTitlesUppercase() {
        List<String> titles = library.getAllTitlesUppercase();
        assertTrue(titles.contains("JAVA BASICS"));
    }

    @Test
    void testGetBooksSortedByTitle() {
        List<Book> sorted = library.getBooksSortedByTitle();
        assertEquals("Advanced Java", sorted.get(0).getTitle());
    }
}
