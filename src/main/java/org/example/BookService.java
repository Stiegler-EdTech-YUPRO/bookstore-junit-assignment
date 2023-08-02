package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BookService {
    private List<Book> bookDatabase = new ArrayList<>(); // A list to simulate a book database

    public List<Book> searchBook(String keyword) {
        // Search book by title, author, or genre
        if (keyword == null || keyword.isBlank()) {
            throw new IllegalArgumentException("Keyword cannot be null or blank.");
        }

        return bookDatabase.stream()
                .filter(book -> book.getTitle().contains(keyword) ||
                        book.getAuthor().contains(keyword) ||
                        book.getGenre().contains(keyword))
                .collect(Collectors.toList());
    }

    public boolean purchaseBook(User user, Book book) {
        // In real world, this should check user's balance, availability of the book, and then make a transaction
        // But for now, we just check if the book exists in our "database"
        if (book == null) {
            throw new IllegalArgumentException("Book cannot be null.");
        }
        if (user == null) {
            throw new IllegalArgumentException("User cannot be null.");
        }

        return bookDatabase.contains(book);
    }

    public boolean addBookReview(User user, Book book, String review) {
        // logic to add book review
        if (user == null) {
            throw new IllegalArgumentException("User cannot be null.");
        }
        if (book == null) {
            throw new IllegalArgumentException("Book cannot be null.");
        }
        if (review == null || review.isBlank()) {
            throw new IllegalArgumentException("Review cannot be null or blank.");
        }
        if (!user.getPurchasedBooks().contains(book)) {
            return false; // User has not purchased this book
        }

        book.getReviews().add(review);
        return true;
    }

    public boolean addBook(Book book) {
        if (book == null) {
            throw new IllegalArgumentException("Book cannot be null.");
        }
        if (bookDatabase.contains(book)) {
            return false; // Book is already in the database
        }

        bookDatabase.add(book);
        return true; // Book added successfully
    }

    public boolean removeBook(Book book) {
        if (book == null) {
            throw new IllegalArgumentException("Book cannot be null.");
        }
        return bookDatabase.remove(book); // Book removed successfully if it was in the database
    }
}
