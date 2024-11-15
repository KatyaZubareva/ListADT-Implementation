package arraylist;

/**
 * Класс, представляющий позицию в списке.
 * Позиция хранит индекс, который указывает на местоположение элемента в массиве.
 */
public class Position {
    private int index;

    /**
     * Конструктор, инициализирующий позицию индексом.
     * @param index Индекс, который будет присвоен позиции.
     */
    public Position(int index) {
        this.index = index;
    }

    /**
     * Метод для получения индекса позиции.
     * @return Индекс позиции.
     */
    public int getIndex() {
        return index;
    }

    /**
     * Метод для установки нового индекса позиции.
     * @param index Новый индекс, который будет присвоен позиции.
     */
    public void setIndex(int index) {
        this.index = index;
    }
}
