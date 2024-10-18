package arraylist;

public class List {
    private ListElement[] elements; // Массив элементов списка
    private int last; // Индекс последнего занятого элемента

    // Конструктор, инициализирующий пустой список на массиве
    public List(int capacity) {
        elements = new ListElement[capacity]; // Инициализация массива с заданной емкостью
        last = -1; // Индекс последнего занятого элемента (начинается с -1 для пустого списка)
    }

    // Метод для получения позиции конца списка
    public Position END() {
        return new Position(last + 1); // Позиция после последнего
    }

    // Метод для вставки элемента в указанную позицию
    public void INSERT(ListElement element, Position position) {
        int posIndex = position.getIndex();

        if (posIndex < 0 || posIndex > last + 1 || last + 1 >= elements.length) {
            throw new IllegalArgumentException("Invalid position.");
        }

        // Сдвигаем элементы вправо от позиции вставки
        for (int i = last; i >= posIndex; i--) {
            elements[i + 1] = elements[i];
        }

        // Вставляем элемент
        elements[posIndex] = element;
        last++;
    }

    // Метод для поиска элемента по имени
    public Position LOCATE(String name) {
        for (int i = 0; i <= last; i++) {
            if (elements[i].getName().equals(name)) {
                return new Position(i); // Возвращаем позицию найденного элемента
            }
        }
        return END(); // Если элемент не найден, возвращаем END
    }

    // Метод для получения элемента на указанной позиции
    public ListElement RETRIEVE(Position position) {
        int index = position.getIndex();
        if (index < 0 || index > last) {
            throw new IllegalArgumentException("Invalid position.");
        }
        return elements[index]; // Возвращаем элемент списка
    }

    // Метод для удаления элемента на указанной позиции
    public void DELETE(Position position) {
        int index = position.getIndex();
        if (index < 0 || index > last) {
            throw new IllegalArgumentException("Invalid position.");
        }

        // Сдвигаем элементы влево
        for (int i = index; i < last; i++) {
            elements[i] = elements[i + 1];
        }

        elements[last] = null; // Освобождаем последний элемент
        last--; // Уменьшаем индекс последнего элемента
    }

    // Метод для получения следующей позиции
    public Position NEXT(Position position) {
        int index = position.getIndex();
        if (index < 0 || index > last) {
            throw new IllegalArgumentException("Invalid position.");
        }
        return index == last ? END() : new Position(index + 1);
    }

    // Метод для получения предыдущей позиции
    public Position PREVIOUS(Position position) {
        int index = position.getIndex();
        if (index <= 0 || index > last) {
            throw new IllegalArgumentException("Invalid position.");
        }
        return new Position(index - 1);
    }

    // Метод для очистки списка
    public void MAKENULL() {
        elements = new ListElement[elements.length]; // Создаем новый массив
        last = -1; // Индекс последнего элемента снова -1
    }

    // Метод для получения первой позиции
    public Position FIRST() {
        return last == -1 ? END() : new Position(0); // Возвращаем первую позицию или END
    }

    // Метод для вывода списка на печать
    public void PRINTLIST() {
        for (int i = 0; i <= last; i++) {
            System.out.println(elements[i]); // Печать каждого элемента
        }
    }
}
