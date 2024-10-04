package linkedlist;

public class Position {
    private int index;  // Храним индекс позиции в списке

    public Position(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    @Override
    public String toString() {
        return Integer.toString(index);
    }
}
