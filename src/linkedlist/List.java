package linkedlist;

public class List<T> {
    private Node<T> head; // Указатель на начало списка

    public List() {
        head = null; // Инициализация пустого списка
    }

    // Метод возвращает позицию после последнего элемента
    public Position<T> END() {
        Node<T> temp = head;
        if (temp == null) {
            return new Position<>(null); // Если список пуст, возвращаем позицию с null
        }
        while (temp.next != null) {
            temp = temp.next;
        }
        return new Position<>(temp); // Возвращаем позицию последнего элемента
    }

    // Метод вставки нового элемента в список
    public void INSERT(T x, Position<T> p) {
        Node<T> newNode = new Node<>(x); // Создаем новый узел
        if (p.getNode() == head) {
            newNode.next = head; // Вставляем в начало списка
            head = newNode;
        } else {
            Node<T> temp = head;
            while (temp != null && temp != p.getNode()) {
                temp = temp.next;
            }
            if (temp != null) {
                newNode.next = temp.next;
                temp.next = newNode;
            } else {
                throw new IndexOutOfBoundsException("Invalid position"); // Проверяем корректность позиции
            }
        }
    }

    // Метод поиска элемента в списке
    public Position<T> LOCATE(T x) {
        Node<T> temp = head;
        while (temp != null) {
            if (temp.data.equals(x)) {
                return new Position<>(temp); // Возвращаем позицию найденного элемента
            }
            temp = temp.next;
        }
        return new Position<>(null); // Если элемент не найден, возвращаем позицию с null
    }

    // Метод получения элемента по позиции
    public T RETRIEVE(Position<T> p) {
        if (p.getNode() == null) {
            throw new IndexOutOfBoundsException("Invalid position");
        }
        return p.getNode().data;
    }

    // Метод удаления элемента по позиции
    public void DELETE(Position<T> p) {
        if (head == null || p.getNode() == null) {
            throw new IndexOutOfBoundsException("Invalid position");
        }

        if (p.getNode() == head) {
            head = head.next; // Удаляем первый элемент
        } else {
            Node<T> temp = head;
            while (temp != null && temp.next != p.getNode()) {
                temp = temp.next;
            }
            if (temp != null && temp.next == p.getNode()) {
                temp.next = p.getNode().next; // Удаляем элемент
            } else {
                throw new IndexOutOfBoundsException("Invalid position");
            }
        }
    }

    // Метод возвращает позицию следующего элемента
    public Position<T> NEXT(Position<T> p) {
        if (p.getNode() == null || p.getNode().next == null) {
            return new Position<>(null); // Нет следующего элемента
        }
        return new Position<>(p.getNode().next);
    }

    // Метод возвращает позицию предыдущего элемента
    public Position<T> PREVIOUS(Position<T> p) {
        if (p.getNode() == head) {
            return new Position<>(null); // Если это первый элемент, предыдущего нет
        }
        Node<T> temp = head;
        while (temp != null && temp.next != p.getNode()) {
            temp = temp.next;
        }
        return new Position<>(temp); // Возвращаем предыдущий узел
    }

    // Метод очищает список
    public void MAKENULL() {
        head = null; // Очищаем список
    }

    // Метод возвращает первую позицию в списке
    public Position<T> FIRST() {
        return new Position<>(head); // Возвращаем первую позицию
    }

    // Метод выводит все элементы списка
    public void PRINTLIST() {
        Node<T> temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}
