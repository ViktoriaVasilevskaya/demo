package com.ifmo.lesson4;

public class Main {
    public static void main (String [] args){
        Library library = new Library(4);
        boolean added = library.put(new Book("Stephen King","Shining"),3);
        boolean added2 = library.put(new Book("Tolstoy", "War and peace"),4);
        boolean added3 = library.put(new Book("Stephen King", "Dark Tower"), 3);
        System.out.println(added);
        System.out.println(added2);
        System.out.println(added3);
        int taken = library.take(new Book("Stephen King","Shining"),5);
        int taken2 = library.take(new Book("Tolstoy", "War and peace"),4);
        int taken3 = library.take(new Book("Stephen King", "Dark Tower"),3);
        System.out.println(taken);
        System.out.println(taken2);
        System.out.println(taken3);

    }
}
