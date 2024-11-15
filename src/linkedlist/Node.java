package linkedlist;

/**
 * Класс, представляющий узел в связанном списке.
 * Каждый узел хранит данные типа ListElement и ссылку на следующий узел.
 */
public class Node {
    ListElement data; // Данные типа ListElement
    Node next;       // Ссылка на следующий узел

    /**
     * Конструктор для создания узла с данными.
     * @param data Данные, которые будут сохранены в узле.
     */
    public Node(ListElement data) {
        this.data = data;
        this.next = null; // Изначально следующий узел отсутствует
    }
}
