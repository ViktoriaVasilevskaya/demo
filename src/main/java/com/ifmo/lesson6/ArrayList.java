package com.ifmo.lesson6;



import java.util.Iterator;

/**
 * Этот класс должен реализовывать следующие методы: add(), get(), remove() и iterator() из интерфейса List.
 * Если при выполнении add() в массиве нет свободных элементов, то создать новый - вдвое больше,
 * скопировать в него все значения из старого и + 1, который сейчас добавляется.
 * Удаление должно сдвинуть все элементы влево, если это требуется.
 * Например, если список с такими элементами:
 * |0|1|2|3|4|5|
 * Удаляем элемент по индексу 2:
 * |0|1|_|3|4|5|
 * Перемещаем все элементы влево:
 * |0|1|3|4|5|_|
 * Теперь при итерации по ним после 1 будет идти сразу 3, как в связном списке.
 */
public class ArrayList implements List {
    private static final int DEFAULT_SIZE = 10;
    private int size;

    private Object[] values;

    /**
     * Создаёт новый {@link #ArrayList} с размером внутреннего массива по умолчанию.
     */
    public ArrayList() {
        this(DEFAULT_SIZE);
    }

    /**
     * Создаёт новый {@link #ArrayList} с размером внутреннего массива,
     * равного {@code initialSize}.
     *
     * @param initialSize Начальный размер внутреннего массива.
     */
    public ArrayList(int initialSize) {
        values = new Object[initialSize];
    }

    /** {@inheritDoc} */
    @Override
    public void add(Object val) {
        if(size < values.length){
            values[size] = val;
        } else {
            new_size();
        }
        size++;

    }

    public void new_size(){
        Object [] New_values = new Object[values.length *2];
        System.arraycopy(values,0,New_values,0,size);
        values = New_values;
    }

    /** {@inheritDoc} */
    @Override
    public Object get(int i) {
        if (i < size){
            return values[i];
        }else{
            return null;
        }
    }

    /** {@inheritDoc} */
    @Override
    public Object remove(int i) {

        if (i < size){
            Object rem = values[i];
            System.arraycopy(values,i+1,values,i,size - 1);
            size--;
            return rem;
        }else{
            return null;
        }
    }

    /** {@inheritDoc} */
    @Override
    public Iterator iterator() {
        Iterator iterator = new Iterator() {
            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public Object next() {
                return null;
            }
        };
        return iterator;
    }
}
