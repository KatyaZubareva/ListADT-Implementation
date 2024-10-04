package main;

import arraylist.List; // Для использования представления на массиве
// import linkedlist.List; // Для использования связного списка
import arraylist.Position;

public class Main {
    public static void main(String[] args) {
        List<String> list = new List<>(); // Обобщённый список для строк

        // Пример добавления элементов в список
        list.INSERT("apple", list.END());
        list.INSERT("banana", list.END());
        list.INSERT("apple", list.END());
        list.INSERT("cherry", list.END());

        // Удаление дубликатов
        removeDuplicates(list);

        // Печать списка после удаления дубликатов
        list.PRINTLIST();
    }

    private static <T> void removeDuplicates(List<T> list) {
        Position p1 = list.FIRST();
        while (p1.getIndex() < list.END().getIndex()) {
            T element = list.RETRIEVE(p1);
            Position p2 = list.NEXT(p1);
            while (p2.getIndex() < list.END().getIndex()) {
                if (list.RETRIEVE(p2).equals(element)) {
                    list.DELETE(p2);
                } else {
                    p2 = list.NEXT(p2);
                }
            }
            p1 = list.NEXT(p1);
        }
    }
}
