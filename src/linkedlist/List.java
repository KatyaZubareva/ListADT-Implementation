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
     * Метод для поиска позиции, предшествующей указанной.
     * Если позиция является головой списка или не найдена, возвращается null.
     * @param position Позиция, для которой нужно найти предыдущую.
     * @return Позиция, предшествующая указанной, или null, если её нет.
     */
    private Position findPosition(Position position) {
        Node prevPosition = null;
        Node current = head;

        while (current != null) {
            if (current == position.element) {
                return new Position(prevPosition);
            }
            prevPosition = current;
            current = current.next;
        }

        return new Position(null);
    }

    /**
     * Метод для получения последнего узла списка.
     * @return Последний узел списка или null, если список пуст.
     */
    private Node getLastNode() {

        Node current = head;
        Node prev = null; // хранит конец; хранит null, если список пустой
        while (current != null) {
            prev = current;
            current = current.next; // Переходим к следующему узлу
        }
        return prev;
    }

    /**
     * Метод для получения позиции конца списка.
     * @return Позиция, указывающая на конец списка (null).
     */
    public Position end() {
        return new Position(null);
    }

    /**
     * Метод для вставки элемента в список на указанной позиции.
     * Если позиция указана как конец списка (END), элемент добавляется в конец.
     * Если позиция указывает на начало списка, элемент вставляется перед текущей головой.
     * В остальных случаях вставка осуществляется перед указанной позицией.
     * @param element Элемент, который нужно вставить.
     * @param position Позиция, на которую нужно вставить элемент.
     */
    public void insert(ListElement element, Position position) {
        if (position.element == null) {
            if (head == null) {
                // Список пуст: новый элемент становится головой
                head = new Node(element);
            } else {
                // Список не пуст: добавляем элемент в конец
                Node last = getLastNode();
                last.next = new Node(element);
            }
            return;
        }

        Node newNode = new Node(element);

        Position prevPosition = findPosition(position);

        if (prevPosition.element != null) {
            Node prevNode = prevPosition.element;
            newNode.next = prevNode.next;
            prevNode.next = newNode;
        }
    }

    /**
     * Метод для поиска позиции элемента в списке.
     * @param element Объект ListElement, который нужно найти.
     * @return Позиция найденного элемента (объект Position) или позиция конца списка, если элемент не найден.
     */
    public Position locate(ListElement element) {
        Node current = head; // Начинаем поиск с головы списка

        // Перебираем узлы списка
        while (current != null) {
            // Сравниваем данные текущего узла с искомым объектом
            if (current.data.equals(element)) {
                return new Position(current); // Возвращаем позицию найденного элемента
            }
            current = current.next; // Переходим к следующему узлу
        }

        // Если элемент не найден, возвращаем позицию конца списка
        return new Position(null);
    }

    /**
     * Метод для получения элемента на указанной позиции.
     * @param position Позиция, на которой нужно извлечь элемент.
     * @return Элемент на указанной позиции.
     * @throws IllegalArgumentException Если позиция недействительна (null).
     */
    public ListElement retrieve(Position position) {
        if (position.element == null) {
            throw new IllegalArgumentException("Invalid position.");
        }
        if (position.element == head) {
            return head.data;
        }

        return position.element.data; // Возвращаем элемент списка
    }

    /**
     * Метод для удаления элемента на указанной позиции.
     * Если элемент не существует или список пуст, ничего не происходит.
     * @param position Позиция элемента, который нужно удалить.
     */
    public void delete(Position position) {

        if (head == null || position.element == null) {
            return;
        }

        if (position.element == head) {
            head = head.next; // Удаление головы
            return;
        }

        Position previousPosition = findPosition(position);

        if (previousPosition.element != null) {
            Node previous = previousPosition.element;
            previous.next = position.element.next; // Удаление узла
        }
    }


    /**
     * Метод для получения следующей позиции относительно текущей.
     * @param position Позиция, для которой нужно найти следующую.
     * @return Позиция следующего узла.
     * @throws IllegalArgumentException Если позиция недействительна или это последний узел.
     */
    public Position next(Position position) {
        if (position.element == null) {
            throw new IllegalArgumentException("Invalid position.");
        }
        Node current = (Node) position.element;
        return current.next == null ? end() : new Position(current.next);
    }

    /**
     * Метод для очистки списка.
     * Очищает список, удаляя все элементы.
     */
    public Position makeNull() {
        head = null;
        return new Position(null);
    }

    /**
     * Метод для получения первой позиции в списке.
     * Если список пуст, возвращается позиция, указывающая на конец списка.
     * @return Первая позиция списка или END, если список пуст.
     */
    public Position first() {
        return new Position(head);
    }

    /**
     * Метод для вывода всех элементов списка на экран.
     * Печатает каждый элемент списка в порядке от головы до конца.
     */
    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }
}
