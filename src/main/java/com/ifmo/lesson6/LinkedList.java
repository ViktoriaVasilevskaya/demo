package com.ifmo.lesson6;

import java.util.Iterator;

/**
 * Односвязный список, где каждый предыдущий
 * элемент харнит ссылку на следующий. Список
 * оканчивается ссылкой со значением {@code null}.
 */
public class LinkedList<T> implements List<T>, Stack<T>, Queue<T> {
    /** Ссылка на первый элемент списка. */
    private Item<T> head;

    /** {@inheritDoc} */
    @Override
    public void add(T val) {
       Item<T> item = new Item<>(val);

        if (head == null) {
            head = item;
        } else {
            Item<T> current = head;

            while (current.next != null) {
                current = current.next;
            }
            current.next = item;
        }
    }

    /** {@inheritDoc} */
    @Override
    public T take() {
        if (head != null) {
            T t = head.value;
            head = head.next;
            return t;
        }
        return null;
    }
    /** {@inheritDoc} */
    @Override
    public T get(int i) {
        Item<T> current = head;
        for (int cnt = 0; current != null ; cnt++) {
            if (cnt == i){
                return current.value;
            }
            current = current.next;
        }
        return null;
    }
    /** {@inheritDoc} */
    @Override
    public T remove(int i) {
        if(head == null)
            return null;
        if(i == 0){ // первый элемент, те head
            T val = head.value; // берем его значение и записываем в следующее
            head = head.next;
            return val;
        }
       Item<T> previous = head;
        for (int cnt = 0; previous != null ; cnt++) {
            if (cnt + 1 == i){
                if(previous.next == null){
                    return null;
                }
                T val = previous.next.value;
                previous.next = previous.next.next;// берем из удаленного ссылку на следующий и перезаписываем в предыдущий
                return val;
            }
            previous = previous.next;
        }
        return null;
    }
    /** {@inheritDoc} */
    @Override
    public Iterator<T> iterator() {
        Iterator iterator = new Iterator() {

            Item current = head;
            @Override
            public boolean hasNext() {
                if (current != null){
                    return true;
                } else {
                    return false;
                }
            }

            @Override
            public Object next() {
                if(!this.hasNext()){
                    return null;
                } else {
                    Item current = this.current;
                    this.current = current.next;
                    return current.value;
                }
            }
        };
        return iterator;
    }
    /** {@inheritDoc} */
    @Override
    public void push (T value) {
        this.add(value);
    }
    //

    /** {@inheritDoc} */
    @Override
    public T pop() {
        if (head == null){
            return null;
        } else if (head.next == null){
            Item current = head;
            head = null;
            return (T) current.value;
        } else {
            Item current = head.next;
            Item last = head;
            while (current.next !=null){
                last = current;
                current = current.next;
            }
            last.next = null;
            return (T) current.value;
        }
    }

    private static class LinkedListIterator<T> implements Iterator<T>{
        private Item<T> cursor;
        @Override
        public boolean hasNext(){
           return cursor != null;
        }
        @Override
        public T next(){
            if(hasNext()){
                T result = cursor.value;
                cursor = cursor.next;
            }
            return null;
        }
    }
}
