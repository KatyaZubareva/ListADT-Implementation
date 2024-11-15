package linkedlist;

/**
 * Класс, представляющий позицию в связанном списке.
 * Каждая позиция указывает на определённый узел списка.
 */
public class Position {
    private Node element; // Узел списка, на который указывает позиция

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
}
