package arraylist;

/**
 * Класс, представляющий список, реализованный с использованием массива.
 * Этот класс предоставляет методы для добавления, удаления и получения элементов,
 * а также для работы с позициями элементов в списке.
 */
public class List {
    private ListElement[] elements; // Массив элементов списка
    private int last; // Индекс последнего занятого элемента

    /**
     * Конструктор для создания пустого списка с заданной емкостью.
     * @param capacity Емкость списка, то есть максимальное количество элементов, которое может содержать список.
     */
    public List(int capacity) {
        elements = new ListElement[capacity]; // Инициализация массива с заданной емкостью
        last = -1; // Индекс последнего занятого элемента (начинается с -1 для пустого списка)
    }

    /**
     * Метод для получения позиции конца списка.
     * @return Позиция, указывающая на место после последнего элемента списка.
     */
    public Position END() {
        return new Position(last + 1);
    }

    /**
     * Метод для вставки элемента в указанную позицию.
     * @param element Элемент типа ListElement, который будет вставлен в список.
     * @param position Позиция типа Position, указывающая место, куда нужно вставить элемент.
     * @throws IllegalArgumentException Если позиция недопустима.
     */
    public void INSERT(ListElement element, Position position) {
        int posIndex = position.getIndex();

        if (posIndex < 0 || posIndex > last + 1) {
            throw new IllegalArgumentException("Invalid position.");
        }

        // Проверка, если массив заполнен, увеличиваем его размер
        if (last + 1 >= elements.length) {
            expandArray();
        }

        // Сдвигаем элементы вправо от позиции вставки
        for (int i = last; i >= posIndex; i--) {
            elements[i + 1] = elements[i];
        }

        // Вставляем элемент
        elements[posIndex] = element;
        last++;
    }

    /**
     * Метод для увеличения размера массива.
     * Создает новый массив с удвоенной емкостью и копирует в него все элементы старого массива.
     */
    private void expandArray() {
        ListElement[] newElements = new ListElement[elements.length * 2];

        for (int i = 0; i < elements.length; i++) {
            newElements[i] = elements[i];
        }
        elements = newElements;
    }


    /**
     * Метод для поиска элемента по имени.
     * @param name Имя элемента, который нужно найти в списке.
     * @return Позиция типа Position, указывающая на найденный элемент, или END, если элемент не найден.
     */
    public Position LOCATE(String name) {
        for (int i = 0; i <= last; i++) {
            if (elements[i].getName().equals(name)) {
                return new Position(i);
            }
        }
        return END();
    }

    /**
     * Метод для получения элемента на указанной позиции.
     * @param position Позиция типа Position, указывающая на место элемента в списке.
     * @return Элемент типа ListElement, находящийся на указанной позиции.
     * @throws IllegalArgumentException Если позиция недопустима.
     */
    public ListElement RETRIEVE(Position position) {
        int index = position.getIndex();
        if (index < 0 || index > last) {
            if (index == last + 1) {
                return null;
            }
            throw new IllegalArgumentException("Invalid position.");
        }
        return elements[index];
    }

    /**
     * Метод для удаления элемента на указанной позиции.
     * @param position Позиция типа Position, указывающая на место элемента, который нужно удалить.
     * @throws IllegalArgumentException Если позиция недопустима.
     */
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

    /**
     * Метод для получения следующей позиции.
     * @param position Позиция типа Position, от которой нужно получить следующую.
     * @return Позиция типа Position, указывающая на следующий элемент, или END, если текущий элемент последний.
     * @throws IllegalArgumentException Если позиция недопустима.
     */
    public Position NEXT(Position position) {
        int index = position.getIndex();
        if (index < 0 || index > last) {
            throw new IllegalArgumentException("Invalid position.");
        }
        return index == last ? END() : new Position(index + 1);
    }

    /**
     * Метод для получения предыдущей позиции.
     * @param position Позиция типа Position, от которой нужно получить предыдущую.
     * @return Позиция типа Position, указывающая на предыдущий элемент.
     * @throws IllegalArgumentException Если позиция недопустима.
     */
    public Position PREVIOUS(Position position) {
        int index = position.getIndex();
        if (index <= 0 || index > last) {
            throw new IllegalArgumentException("Invalid position.");
        }
        return new Position(index - 1);
    }

    /**
     * Метод для очистки списка.
     * Очищает список, создавая новый пустой массив и сбрасывая индекс последнего элемента.
     */
    public void MAKENULL() {
        elements = new ListElement[elements.length];
        last = -1;
    }

    /**
     * Метод для получения первой позиции.
     * @return Первая позиция в списке, или END, если список пуст.
     */
    public Position FIRST() {
        return last == -1 ? END() : new Position(0);
    }

    /**
     * Метод для вывода списка на печать.
     * Проходит по всем элементам списка и выводит их на экран.
     */
    public void PRINTLIST() {
        for (int i = 0; i <= last; i++) {
            System.out.println(elements[i]);
        }
    }
}