package linkedlist;

public class Position<T> {
    private Node<T> node; // Хранение ссылки на узел списка

    // Конструктор с передачей узла
    public Position(Node<T> node) {
        this.node = node;
    }

    // Получение узла
    public Node<T> getNode() {
        return node;
    }

    // Установка нового узла
    public void setNode(Node<T> node) {
        this.node = node;
    }

    @Override
    public String toString() {
        return node != null ? node.toString() : "null";
    }
}
