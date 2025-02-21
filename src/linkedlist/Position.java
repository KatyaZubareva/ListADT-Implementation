package linkedlist;

/**
 * Класс, представляющий позицию в связанном списке.
 * Каждая позиция указывает на определённый узел списка.
 */
public class Position {
    public Node element; // Узел списка, на который указывает позиция

    /**
     * Конструктор, инициализирующий позицию узлом.
     * @param element Узел, на который будет указывать позиция.
     */
    public Position(Node element) {
        this.element = element;
    }

    /**
     * Метод для получения узла на позиции.
     * @return Узел, на который указывает позиция.
     */
    public Node getElement() {
        return element;
    }

    /**
     * Метод для сравнения двух объектов Position.
     * @param object Объект, с которым сравнивается текущий объект.
     * @return true, если объекты равны; false в противном случае.
     */
    @Override
    public boolean equals(Object object) {
        if (this == object) return true; // Проверка на ссылочную равность
        if (object == null || getClass() != object.getClass()) return false; // Проверка типа
        Position position = (Position) object;
        return this.element == position.element; // Сравнение узлов
    }
}
