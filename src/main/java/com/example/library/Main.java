package com.example.library;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Library Manager ===");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. Find by Author");
            System.out.println("4. Show All Books");
            System.out.println("5. Exit");
            System.out.print("Choose: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter Author: ");
                    String author = sc.nextLine();
                    System.out.print("Enter Pages: ");
                    int pages = sc.nextInt();
                    sc.nextLine();
                    library.addBook(new Book(id, title, author, pages));
                    System.out.println("Book added!");
                    break;

                case 2:
                    System.out.print("Enter ID to remove: ");
                    int removeId = sc.nextInt();
                    sc.nextLine();
                    boolean removed = library.removeBook(removeId);
                    System.out.println(removed ? "Removed!" : "Not Found!");
                    break;

                case 3:
                    System.out.print("Enter Author: ");
                    String searchAuthor = sc.nextLine();
                    library.findByAuthor(searchAuthor).forEach(System.out::println);
                    break;

                case 4:
                    library.getBooksSortedByTitle().forEach(System.out::println);
                    break;

                case 5:
                    System.out.println("Goodbye!");
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
