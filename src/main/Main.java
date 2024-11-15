package main;

import arraylist.List; // Для использования представления на массиве
// import linkedlist.List; // Для использования связного списка
import arraylist.Position;
import arraylist.ListElement;

/**
 * Главный класс, который демонстрирует использование АДТ списка.
 * Он добавляет элементы в список, удаляет дубликаты и выводит результат.
 */
public class Main {
    public static void main(String[] args) {
        List list = new List(4);

        list.INSERT(new ListElement("name1", "address1"), list.END());
        list.INSERT(new ListElement("name2", "address2"), list.END());
        list.INSERT(new ListElement("name2", "address2"), list.END());
        list.INSERT(new ListElement("name3", "address1"), list.END());
        list.INSERT(new ListElement("name4", "address3"), list.END());

        removeDuplicates(list);

        list.PRINTLIST();
    }

    /**
     * Метод для удаления дублирующихся элементов из списка по имени.
     * Этот метод сравнивает имя каждого элемента в списке с каждым другим элементом.
     * Если найдены дублирующиеся имена, то дублирующий элемент удаляется.
     *
     * @param list Список, из которого нужно удалить дубликаты.
     */
    public static void removeDuplicates(List list) {
        Position current = list.FIRST();
        while (!current.equals(list.END())) {
            ListElement element = list.RETRIEVE(current);

            if (element != null) {
                Position checker = list.NEXT(current);

                while (!checker.equals(list.END())) {
                    ListElement checkerElement = list.RETRIEVE(checker);
                    if (checkerElement != null && element.getName().equals(checkerElement.getName())) {
                        Position nextChecker = list.NEXT(checker);
                        list.DELETE(checker);
                        checker = nextChecker;
                    } else {
                        checker = list.NEXT(checker);
                    }
                }
            }
            current = list.NEXT(current);
        }
    }

}
