package linkedlist;

public class Position {
    private ListElement element; // Элемент списка, на который указывает позиция

    // Конструктор, инициализирующий позицию элементом
    public Position(ListElement element) {
        this.element = element;
    }

    // Метод для получения элемента на позиции
    public ListElement getElement() {
        return element;
    }
}
