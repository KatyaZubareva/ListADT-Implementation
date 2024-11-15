package linkedlist;

/**
 * Класс, реализующий связный список.
 * Содержит методы для добавления, удаления элементов и навигации по списку.
 */
public class List {
    private Node head; // Указатель на первый узел списка

    /**
     * Конструктор, инициализирующий пустой список.
     */
    public List() {
        head = null;
    }

    /**
     * Метод для получения позиции конца списка.
     * @return Позиция, указывающая на конец списка (null).
     */
    public Position END() {
        return new Position(null);
    }

    /**
     * Метод для вставки элемента в список на указанной позиции.
     * Если позиция указана как конец списка (END), элемент добавляется в конец.
     * Вставка перед указанной позицией в остальных случаях.
     * @param element Элемент, который нужно вставить.
     * @param position Позиция, на которую нужно вставить элемент.
     */
    public void INSERT(ListElement element, Position position) {
        Node newNode = new Node(element); // Создаем новый узел с данными

        if (position.getElement() == null) {
            // Если позиция - конец списка (END), вставляем в конец списка
            if (head == null) {
                head = newNode; // Если список пуст, вставляем в начало
            } else {
                Node current = head;
                while (current.next != null) {
                    current = current.next;
                }
                current.next = newNode; // Добавляем новый узел в конец
            }
        } else {
            // Вставляем новый узел перед текущим узлом позиции
            Node current = head;
            while (current != null && current.next != position.getElement()) {
                current = current.next;
            }
            if (current != null) {
                newNode.next = current.next; // Новый узел указывает на следующий
                current.next = newNode; // Предыдущий узел указывает на новый узел
            }
        }
    }

    /**
     * Метод для поиска элемента в списке по имени.
     * Если элемент найден, возвращает его позицию.
     * Если элемент не найден, возвращает позицию, указывающую на конец списка.
     * @param name Имя элемента, который нужно найти.
     * @return Позиция найденного элемента или END, если элемент не найден.
     */
    public Position LOCATE(String name) {
        Node current = head;
        while (current != null) {
            if (current.data.getName().equals(name)) {
                return new Position(current); // Возвращаем позицию найденного элемента
            }
            current = current.next;
        }
        return END(); // Если элемент не найден, возвращаем END
    }

    /**
     * Метод для получения элемента на указанной позиции.
     * @param position Позиция, на которой нужно извлечь элемент.
     * @return Элемент на указанной позиции.
     * @throws IllegalArgumentException Если позиция недействительна (null).
     */
    public ListElement RETRIEVE(Position position) {
        Node node = position.getElement(); // Узел на указанной позиции
        if (node == null) throw new IllegalArgumentException("Invalid position.");
        return node.data; // Возвращаем элемент списка
    }

    /**
     * Метод для удаления элемента на указанной позиции.
     * Если элемент не существует или список пуст, ничего не происходит.
     * @param position Позиция элемента, который нужно удалить.
     */
    public void DELETE(Position position) {
        Node nodeToDelete = position.getElement(); // Узел, который нужно удалить

        if (nodeToDelete == null || head == null) return; // Если узел или список пуст, ничего не делаем

        if (nodeToDelete == head) {
            head = head.next; // Удаляем первый узел
        } else {
            Node current = head;
            // Ищем узел перед тем, который нужно удалить
            while (current.next != null && current.next != nodeToDelete) {
                current = current.next; // Идём по списку
            }
            // Если нашли узел перед удаляемым
            if (current.next == nodeToDelete) {
                current.next = nodeToDelete.next; // Сдвигаем ссылку на следующий узел
            }
        }
    }


    /**
     * Метод для получения следующей позиции относительно текущей.
     * @param position Позиция, для которой нужно найти следующую.
     * @return Позиция следующего узла.
     * @throws IllegalArgumentException Если позиция недействительна или это последний узел.
     */
    public Position NEXT(Position position) {
        Node node = position.getElement(); // Текущий узел
        if (node == null || node.next == null) throw new IllegalArgumentException("Invalid position.");
        return new Position(node.next); // Возвращаем следующую позицию
    }

    /**
     * Метод для получения первой позиции в списке.
     * Если список пуст, возвращается позиция, указывающая на конец списка.
     * @return Первая позиция списка или END, если список пуст.
     */
    public Position FIRST() {
        return head == null ? END() : new Position(head);
    }

    /**
     * Метод для вывода всех элементов списка на экран.
     * Печатает каждый элемент списка в порядке от головы до конца.
     */
    public void PRINTLIST() {
        Node current = head;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }
}

