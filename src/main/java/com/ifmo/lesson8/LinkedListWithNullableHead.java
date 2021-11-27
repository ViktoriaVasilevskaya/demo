package com.ifmo.lesson8;

/**
 * Односвязный список, где каждый предыдущий
 * элемент харнит ссылку на следующий. Список
 * оканчивается ссылкой со значением {@code null}.
 */
public class LinkedListWithNullableHead {
    /** Ссылка на первый элемент списка. */
    private Item head;

    /**
     * Добавляет значение в конец списка.
     *
     * @param val Значение, которое будет добавлено.
     */
    public void add(Object val) {
        if (head == null) {
            head = new Item(val);

            return;
        }

        //noinspection ConstantConditions
        find(-1).next = new Item(val); // -1 означает, что мы ищем последний элемент
    }

    /**
     * Извлекает значение из списка по индексу.
     *
     * @param i Индекс значения в списке.
     * @return Значение, которое находится по индексу
     * или {@code null}, если не найдено.
     */
    public Object get(int i) {
        Item item = find(i);

        return item == null ? null : item.value;
    }

    /**
     * Удаляет значение по индексу и возвращает
     * удаленный элемент.
     *
     * @param i Индекс, по которому будет удален элемент.
     * @return Удаленное значение или {@code null}, если не найдено.
     */
    public Object remove(int i) {
        if (head == null)
            return null;

        if (i == 0) {
            Item h = head;
            head = head.next;

            return h.value;
        }

        Item prev = find(i - 1); // ищем предыдущий элемент
        Item cur;

        if (prev != null && (cur = prev.next) != null) { // здесь присвоение cur = prev.next возвращает значение prev.next
            prev.next = cur.next;

            return cur.value;
        }

        return null;
    }

    /**
     * Находит Item по индексу.
     *
     * @param i индекс искомого элемента, если он равен -1, то находит последний.
     * @return Item или null, если ничего не найдено.
     */
    private Item find(int i) {
        if (head == null)
            return null;

        if (i == 0)
            return head;

        int cnt = 1;

        for (Item prev = head;;) {
            Item next = prev.next;

            if (next == null)
                return i < 0 ? prev : null; // возвращаем последний элемент

            if (cnt++ == i) // возвращаем элемент по индексу
                return next;

            prev = next; // двигаем указатель на следующий элемент
        }
    }

}
