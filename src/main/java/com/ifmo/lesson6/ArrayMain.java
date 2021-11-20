package com.ifmo.lesson6;



public class ArrayMain {
    public static void main (String [] args){
        ArrayList arr = new ArrayList();


        arr.add(21);
        arr.add(22);
        arr.add(13);
        arr.add(41);

        for(Object o: arr){
            System.out.println(o);
        }


    }
}
