package com.ifmo.lesson6;

import java.util.Iterator;

public class Main {
    public static void main (String [] args){
        List<Integer> list = new LinkedList<>();

        Queue queue =(Queue) list;
        queue.add(1);
        queue.add(2);
        queue.add(3);

        queue.take();
        queue.take();
        queue.take();
//        for (Integer o: list){
//            System.out.println();
//        }


//        final Iterator<Integer> iterator = list.iterator();
//
//        Stack stack = (Stack) list;
//
//     stack.push("1");
//     stack.push("2");
//     stack.push("3");
//
//        while (iterator.hasNext()){
//            Integer next = iterator.next();
//            System.out.println(next);
//        }
//     stack.pop(); // "3"
//     stack.pop(); // "2"
//     stack.pop(); // "1"
//     stack.pop(); // null
//
//        while (iterator.hasNext()){
//            Integer next = iterator.next();
//            System.out.println(next);
//        }
    }
}
