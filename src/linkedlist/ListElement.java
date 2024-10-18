package linkedlist;

public class ListElement {
    private char[] name;    // Имя (максимум 20 символов)
    private char[] address; // Адрес (максимум 50 символов)
    public ListElement next; // Ссылка на следующий элемент

    // Обычный конструктор
    public ListElement(String name, String address) {
        this.name = new char[20];
        this.address = new char[50];

        // Копируем строку в массив символов, ограничивая по длине
        System.arraycopy(name.toCharArray(), 0, this.name, 0, Math.min(name.length(), 20));
        System.arraycopy(address.toCharArray(), 0, this.address, 0, Math.min(address.length(), 50));

        this.next = null; // Изначально следующий элемент отсутствует
    }

    // Копирующий конструктор
    public ListElement(ListElement other) {
        this.name = new char[20];
        this.address = new char[50];

        // Копируем массивы символов
        System.arraycopy(other.name, 0, this.name, 0, 20);
        System.arraycopy(other.address, 0, this.address, 0, 50);

        this.next = null; // При копировании создается независимый элемент без ссылки на следующий
    }

    // Получить имя
    public String getName() {
        return new String(name).trim();
    }

    // Получить адрес
    public String getAddress() {
        return new String(address).trim();
    }

    // Переопределение метода toString для вывода
    @Override
    public String toString() {
        return "Name: " + getName() + ", Address: " + getAddress();
    }
}
