package com.ifmo.lesson6;

import java.util.Iterator;

public class MainList {
    public static void main(String [] args){
        List list = new LinkedList();

        final Iterator iterator = list.iterator();
        while (iterator.hasNext()){
            final Object value = iterator.next();
            System.out.println(value);
        }
    }
}
