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
     */
    public List() {
        int capacity = 20;
        elements = new ListElement[capacity]; // Инициализация массива с заданной емкостью
        last = -1; // Индекс последнего занятого элемента (начинается с -1 для пустого списка)
    }

    /**
     * Метод для получения позиции конца списка.
     * @return Позиция, указывающая на место после последнего элемента списка.
     */
    public Position end() {
        return new Position(last + 1);
    }

    /**
     * Метод для вставки элемента в указанную позицию.
     * @param element Элемент типа ListElement, который будет вставлен в список.
     * @param position Позиция типа Position, указывающая место, куда нужно вставить элемент.
     * @throws IllegalArgumentException Если позиция недопустима.
     */
    public void insert(ListElement element, Position position) {
        if (position.index < 0 || position.index > last + 1 || last >= elements.length) {
            return;
        }

        // Сдвигаем элементы вправо от позиции вставки
        for (int i = last; i >= position.index; i--) {
            elements[i + 1] = elements[i];
        }

        // Вставляем элемент
        elements[position.index] = element;
        last++;
    }

    /**
     * Метод для поиска элемента по имени.
     * @param name Имя элемента, который нужно найти в списке.
     * @return Позиция типа Position, указывающая на найденный элемент, или END, если элемент не найден.
     */
    public Position locate(String name) {
        for (int i = 0; i <= last; i++) {
            if (elements[i].getName().equals(name)) {
                return new Position(i);
            }
        }
        return new Position(last + 1);
    }

    /**
     * Метод для получения элемента на указанной позиции.
     * @param position Позиция типа Position, указывающая на место элемента в списке.
     * @return Элемент типа ListElement, находящийся на указанной позиции.
     * @throws IllegalArgumentException Если позиция недопустима.
     */
    public ListElement retrieve(Position position) {
        if (position.index < 0 || position.index > last) {
            throw new IllegalArgumentException("Invalid position.");
        }
        return elements[position.index];
    }


    /**
     * Метод для удаления элемента на указанной позиции.
     * @param position Позиция типа Position, указывающая на место элемента, который нужно удалить.
     * @throws IllegalArgumentException Если позиция недопустима.
     */
    public void delete(Position position) {
        if (position.index < 0 || position.index > last) {
            return;
        }

        // Сдвигаем элементы влево
        for (int i = position.index; i < last; i++) {
            elements[i] = elements[i + 1];
        }

        last--; // Уменьшаем индекс последнего элемента
    }

    /**
     * Метод для получения следующей позиции.
     * @param position Позиция типа Position, от которой нужно получить следующую.
     * @return Позиция типа Position, указывающая на следующий элемент, или END, если текущий элемент последний.
     * @throws IllegalArgumentException Если позиция недопустима.
     */
    public Position next(Position position) {
        if (position.index < 0 || position.index > last) {
            throw new IllegalArgumentException("Invalid position.");
        }
        // Если текущая позиция равна последней плюс 1 (END), возвращаем END
        if (position.index == last) {
            return new Position(last + 1);
        }
        return new Position(position.index + 1);
    }

    /**
     * Метод для получения предыдущей позиции.
     * @param position Позиция типа Position, от которой нужно получить предыдущую.
     * @return Позиция типа Position, указывающая на предыдущий элемент.
     * @throws IllegalArgumentException Если позиция недопустима.
     */
    public Position previous(Position position) {
        if (position.index <= 0 || position.index > last) {
            throw new IllegalArgumentException("Invalid position.");
        }
        return new Position(position.index - 1);
    }

    /**
     * Метод для очистки списка.
     * Очищает список, создавая новый пустой массив и сбрасывая индекс последнего элемента.
     */
    public Position makeNull() {
        last = -1;
        return new Position(last + 1);
    }

    /**
     * Метод для получения первой позиции.
     * @return Первая позиция в списке, или END, если список пуст.
     */
    public Position first() {
        return new Position(0);
    }

    /**
     * Метод для вывода списка на печать.
     * Проходит по всем элементам списка и выводит их на экран.
     */
    public void printList() {
        for (int i = 0; i <= last; i++) {
            System.out.println(elements[i]);
        }
    }
}