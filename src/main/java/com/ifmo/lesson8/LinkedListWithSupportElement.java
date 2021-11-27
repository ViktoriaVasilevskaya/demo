package com.ifmo.lesson8;

/**
 * Односвязный список, где каждый предыдущий
 * элемент харнит ссылку на следующий. Список
 * оканчивается ссылкой со значением {@code null}.
 */
public class LinkedListWithSupportElement {
    // Опорный элемент, который никогда не бывает null.
    // Он указывает на первый элемент списка, но им не является.
    private final Item top = new Item(null);

    /**
     * Добавляет значение в конец списка.
     *
     * @param val Значение, которое будет добавлено.
     */
    public void add(Object val) {
        //noinspection ConstantConditions
        find(-1).next = new Item(val);
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
        Item prev = i == 0 ? top : find(i - 1);
        Object removed = null;

        if (prev != null) {
            if (prev.next != null) {
                removed = prev.next.value;

                prev.next = prev.next.next;
            }
        }

        return removed;
    }

    private Item find(int idx) {
        int i = 0;

        Item head = top;

        while (head.next != null) {
            if (i++ == idx)
                return head.next;

            head = head.next;
        }

        if (idx == -1)
            return head;

        return null;
    }

}
