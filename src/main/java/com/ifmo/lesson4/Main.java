package com.ifmo.lesson4;

public class Main {
public static void main(String[] args) {
    LinkedList list = new LinkedList();
    System.out.println("Empty list");
    printList(list, 3);
        // null
        // null
        // null

        list.add("row 1");
        list.add("row 2");
        list.add("row 3");

        System.out.println("3 items in list");
        printList(list, 3);
        // row 1
        // row 2
        // row 3

        System.out.println("1 item removed");
        Object removed = list.remove(1);
        System.out.println("Removed: " + removed); // row 2
        printList(list, 3);
        // row 1
        // row 3
        // null
     }

private static void printList(LinkedList list, int len) {
        for (int i = 0; i < len; i++) {
        System.out.println(list.get(i));
        }
        }
        }

