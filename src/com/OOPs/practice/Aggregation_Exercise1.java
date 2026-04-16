package com.OOPs.practice;

import java.util.ArrayList;
import java.util.List;

class Book{
    private String title;
    private String author;
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }
    public String toString(){
        return title+" by "+author;
    }
}
class Library{
    private List<Book> books; // Library "has-a" Book
    public Library(){
        books = new ArrayList<>();
    }
    public void addBooks(Book book){
        books.add(book);
    }
    public void removeBooks(Book book){
        books.remove(book);
    }

    public List<Book> getBooks() {
        return books;
    }
}
public class Aggregation_Exercise1 {
    public static void main(String[] args) {
        Library l = new Library();
        Book b1 = new Book("Java- The Complete Reference, Eleventh Edition","Herbert Schildt");
        Book b2 = new Book("COMPUTER NETWORKS-FIFTH EDITION", "ANDREW S.TANENBAUM");
        l.addBooks(b1);
        l.addBooks(b2);
        System.out.println("Available Books\n***************");
        l.getBooks().forEach(System.out::println);
        l.removeBooks(b2);
        System.out.println("Available Books\n***************");
        l.getBooks().forEach(System.out::println);
    }
}