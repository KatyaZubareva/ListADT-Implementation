package linkedlist;

/**
 * Класс, представляющий элемент списка.
 * Каждый элемент содержит имя и адрес, которые хранятся в массивах символов с ограничением по длине.
 * Имя обрезается до 20 символов, а адрес — до 50 символов.
 */
public class ListElement {
    private char[] name;    // Имя (максимум 20 символов)
    private char[] address; // Адрес (максимум 50 символов)

    /**
     * Конструктор для создания объекта ListElement.
     * @param name Имя, которое будет обрезано до 20 символов, если оно длиннее.
     * @param address Адрес, который будет обрезан до 50 символов, если он длиннее.
     */
    public ListElement(String name, String address) {
        this.name = new char[20];
        this.address = new char[50];

        copyToArray(name, this.name);
        copyToArray(address, this.address);
    }

    /**
     * Метод для копирования строки в массив символов с ограничением по длине.
     * @param source Строка для копирования.
     * @param result Массив символов, в который копируется строка.
     */
    private void copyToArray(String source, char[] result) {
        int length = Math.min(source.length(), result.length);
        for (int i = 0; i < length; i++) {
            result[i] = source.charAt(i);
        }
    }

    /**
     * Метод для сравнения двух массивов символов.
     * @param array1 Первый массив символов.
     * @param array2 Второй массив символов.
     * @return true, если массивы равны, иначе false.
     */

    private boolean compareArrays(char[] array1, char[] array2) {
        // Если длины массивов разные, то они не равны
        if (array1.length != array2.length) {
            return false;
        }

        // Сравниваем элементы массивов по очереди
        for (int i = 0; i < array1.length; i++) {
            if (array1[i] != array2[i]) {
                return false; // Если хотя бы один элемент не совпадает, массивы не равны
            }
        }

        return true; // Массивы равны
    }

    /**
     * Метод для сравнения текущего объекта ListElement с другим объектом.
     * @param obj Объект, с которым нужно сравнить текущий.
     * @return true, если объекты равны (имя и адрес совпадают), иначе false.
     */
    @Override
    public boolean equals(Object obj) {
        // Проверка: сравнение объекта с самим собой
        if (this == obj) {
            return true; // Объекты равны
        }

        // Проверка: объект равен null или принадлежит другому классу
        if (obj == null || getClass() != obj.getClass()) {
            return false; // Объекты не равны
        }

        // Приведение объекта к типу ListElement
        ListElement other = (ListElement) obj;

        // Сравниваем массивы символов name
        if (!compareArrays(this.name, other.name)) {
            return false; // Имена не совпадают
        }

        // Сравниваем массивы символов address
        return compareArrays(this.address, other.address); // Возвращаем результат сравнения адресов
    }

    /**
     * Метод для получения имени.
     * @return Строка, представляющая имя, обрезанное до 20 символов.
     */
    public String getName() {
        return new String(name).trim();
    }

    /**
     * Метод для получения адреса.
     * @return Строка, представляющая адрес, обрезанный до 50 символов.
     */
    public String getAddress() {
        return new String(address).trim();
    }

    /**
     * Переопределение метода toString для вывода информации об объекте.
     * @return Строка, представляющая объект ListElement в виде "Name: <имя>, Address: <адрес>".
     */
    @Override
    public String toString() {
        return "Name: " + getName() + ", Address: " + getAddress();
    }
}

