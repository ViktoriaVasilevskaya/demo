package com.ifmo.lesson8;

public class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        LinkedListWithNullableHead list2 = new LinkedListWithNullableHead();
        LinkedListWithSupportElement list3 = new LinkedListWithSupportElement();
        System.out.println("Empty list");
        printList(list);
        printList(list2);
        printList(list3);

        addRows(list);
        addRows(list2);
        addRows(list3);

        System.out.println("3 items in list");
        printList(list);
        printList(list2);
        printList(list3);

        System.out.println("1 item removed");
        Object removed = list.remove(1);
        System.out.println("Removed: " + removed); // row 2
        Object removed2 = list2.remove(1);
        System.out.println("Removed: " + removed2); // row 2
        Object removed3 = list3.remove(1);
        System.out.println("Removed: " + removed3); // row 2
        printList(list);
        printList(list2);
        printList(list3);

    }

    private static void addRows(LinkedList list) {
        list.add("row 1");
        list.add("row 2");
        list.add("row 3");
    }

    private static void printList(LinkedList list) {
        System.out.println("LinkedList");
        for (int i = 0; i < 3; i++) {
            System.out.println(list.get(i));
        }
    }


    private static void addRows(LinkedListWithNullableHead list) {
        list.add("row 1");
        list.add("row 2");
        list.add("row 3");
    }

    private static void printList(LinkedListWithNullableHead list) {
        System.out.println("LinkedListWithNullableHead");
        for (int i = 0; i < 3; i++) {
            System.out.println(list.get(i));
        }
    }


    private static void addRows(LinkedListWithSupportElement list) {
        list.add("row 1");
        list.add("row 2");
        list.add("row 3");
    }

    private static void printList(LinkedListWithSupportElement list) {
        System.out.println("LinkedListWithSupportElement");
        for (int i = 0; i < 3; i++) {
            System.out.println(list.get(i));
        }
    }
}
