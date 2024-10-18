package arraylist;

public class Position {
    private int index; // Индекс позиции в массиве

    // Конструктор, инициализирующий позицию индексом
    public Position(int index) {
        this.index = index;
    }

    // Метод для получения индекса позиции
    public int getIndex() {
        return index;
    }

    // Метод для установки нового индекса позиции
    public void setIndex(int index) {
        this.index = index;
    }
}

