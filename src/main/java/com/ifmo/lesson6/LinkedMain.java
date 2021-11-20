package com.ifmo.lesson6;

//import java.util.Iterator;

public class LinkedMain {
    public static void main (String [] args){

        List <Integer> list = new LinkedList <> ();

       //final Iterator<Integer> iterator = list.iterator();

        Stack <Integer> stack = (Stack) list;
        stack.push(1);
        stack.push(2);
        stack.push(3);

        for (Object o: list){
            System.out.println(o);
        }

//        while (iterator.hasNext()){
//            Integer next = iterator.next();
//            System.out.println(next);
//        }
        stack.pop(); // "3"
        stack.pop(); // "2"
        stack.pop(); // "1"
        stack.pop(); // null
//

    }
}
