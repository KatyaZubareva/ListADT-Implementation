package linkedlist;

public class List {
    private ListElement head; // Указатель на первый элемент списка

    // Конструктор, инициализирующий пустой список
    public List() {
        head = null;
    }

    // Метод для получения позиции конца списка
    public Position END() {
        ListElement current = head;
        while (current != null && current.getNext() != null) {
            current = current.getNext();
        }
        return new Position(null); // END указывает на null
    }

    // Метод для вставки элемента в список на указанную позицию
    public void INSERT(ListElement element, Position position) {
        ListElement newElement = new ListElement(element); // Создаем копию элемента

        if (position.getElement() == null) {
            // Вставляем в конец списка, если позиция равна END
            if (head == null) {
                head = newElement; // Если список пуст, вставляем в начало
            } else {
                ListElement current = head;
                while (current.getNext() != null) {
                    current = current.getNext();
                }
                current.setNext(newElement);
            }
        } else if (position.getElement() == head) {
            // Если позиция указывает на первый элемент, вставляем перед ним
            newElement.setNext(head);
            head = newElement;
        } else {
            // Вставляем новый элемент после текущего
            newElement.setNext(position.getElement().getNext());
            position.getElement().setNext(newElement);
        }
    }

    // Метод для поиска элемента по имени
    public Position LOCATE(String name) {
        ListElement current = head;
        while (current != null) {
            if (current.getName().equals(name)) {
                return new Position(current); // Возвращаем позицию найденного элемента
            }
            current = current.getNext();
        }
        return END(); // Если элемент не найден, возвращаем END
    }

    // Метод для получения элемента на указанной позиции
    public ListElement RETRIEVE(Position position) {
        ListElement element = position.getElement(); // Элемент на указанной позиции
        if (element == null) throw new IllegalArgumentException("Invalid position.");
        return element; // Возвращаем элемент списка
    }

    // Метод для удаления элемента на указанной позиции
    public void DELETE(Position position) {
        ListElement posElement = position.getElement(); // Элемент, который нужно удалить
        if (posElement == null || head == null) return;
        if (posElement == head) {
            head = head.getNext(); // Удаляем первый элемент
        } else {
            ListElement current = head;
            while (current.getNext() != posElement && current.getNext() != null) {
                current = current.getNext();
            }
            if (current.getNext() == posElement) {
                current.setNext(posElement.getNext()); // Удаляем элемент
            }
        }
    }

    // Метод для получения следующей позиции
    public Position NEXT(Position position) {
        ListElement posElement = position.getElement(); // Текущий элемент
        if (posElement == null || posElement.getNext() == null) throw new IllegalArgumentException("Invalid position.");
        return new Position(posElement.getNext()); // Возвращаем следующую позицию
    }

    // Метод для получения предыдущей позиции
    public Position PREVIOUS(Position position) {
        ListElement posElement = position.getElement(); // Текущий элемент
        if (posElement == null || posElement == head) throw new IllegalArgumentException("Invalid position.");
        ListElement current = head;
        while (current != null && current.getNext() != posElement) {
            current = current.getNext();
        }
        return new Position(current); // Возвращаем предыдущую позицию
    }

    // Метод для очистки списка
    public void MAKENULL() {
        head = null; // Обнуляем список
    }

    // Метод для получения первой позиции
    public Position FIRST() {
        return head == null ? END() : new Position(head); // Возвращаем первую позицию или END
    }

    // Метод для вывода всех элементов списка
    public void PRINTLIST() {
        ListElement current = head;
        while (current != null) {
            System.out.println(current); // Печать каждого элемента
            current = current.getNext();
        }
    }
}
