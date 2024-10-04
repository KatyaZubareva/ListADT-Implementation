package linkedlist;

public class List<T> {
    private Node<T> head; // Указатель на начало списка

    public List() {
        head = null; // Инициализация пустого списка
    }

    // Метод возвращает позицию после последнего элемента
    public Position END() {
        int index = 0;
        Node<T> temp = head;
        while (temp != null) {
            temp = temp.next;
            index++;
        }
        return new Position(index); // Возвращаем позицию конца списка
    }

    // Метод вставки нового элемента в список
    public void INSERT(T x, Position p) {
        Node<T> newNode = new Node<>(x); // Создаем новый узел
        if (p.getIndex() == 0) {
            newNode.next = head; // Вставляем в начало списка
            head = newNode;
        } else {
            Node<T> temp = head;
            for (int i = 0; i < p.getIndex() - 1; i++) {
                if (temp == null) {
                    throw new IndexOutOfBoundsException("Invalid position"); // Проверяем на корректную позицию
                }
                temp = temp.next;
            }
            newNode.next = temp.next;
            temp.next = newNode;
        }
    }

    // Метод поиска элемента в списке
    public Position LOCATE(T x) {
        Node<T> temp = head;
        int index = 0;
        while (temp != null) {
            if (temp.data.equals(x)) {
                return new Position(index); // Возвращаем позицию, если нашли элемент
            }
            temp = temp.next;
            index++;
        }
        return END(); // Если элемент не найден, возвращаем конец списка
    }

    // Метод получения элемента по позиции
    public T RETRIEVE(Position p) {
        Node<T> temp = head;
        int index = 0;
        while (temp != null && index < p.getIndex()) {
            temp = temp.next;
            index++;
        }
        if (temp != null) {
            return temp.data;
        } else {
            throw new IndexOutOfBoundsException("Invalid position");
        }
    }

    // Метод удаления элемента по позиции
    public void DELETE(Position p) {
        if (p.getIndex() == 0) {
            if (head != null) {
                head = head.next; // Удаляем первый элемент
            }
        } else {
            Node<T> temp = head;
            for (int i = 0; i < p.getIndex() - 1; i++) {
                if (temp == null || temp.next == null) {
                    throw new IndexOutOfBoundsException("Invalid position"); // Проверяем позицию на корректность
                }
                temp = temp.next;
            }
            temp.next = temp.next != null ? temp.next.next : null; // Удаляем элемент
        }
    }

    // Метод возвращает позицию следующего элемента
    public Position NEXT(Position p) {
        return new Position(p.getIndex() + 1); // Возвращаем позицию следующего элемента
    }

    // Метод возвращает позицию предыдущего элемента
    public Position PREVIOUS(Position p) {
        if (p.getIndex() <= 0) {
            throw new IndexOutOfBoundsException("Invalid position");
        }
        return new Position(p.getIndex() - 1); // Возвращаем позицию предыдущего элемента
    }

    // Метод очищает список
    public void MAKENULL() {
        head = null; // Очищаем список
    }

    // Метод возвращает первую позицию в списке
    public Position FIRST() {
        return new Position(0); // Возвращаем первую позицию
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
