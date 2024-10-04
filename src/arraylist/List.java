package arraylist;

public class List<T> {
    private static final int MAX_SIZE = 100;
    private Object[][] array;
    private int last; // Индекс последнего занятого элемента

    public List() {
        array = new Object[MAX_SIZE][2]; // Первый столбец — значения, второй — адреса (индексы)
        last = -1; // Последний элемент не существует в начале, поэтому -1
    }

    // Возвращает позицию после последнего элемента
    public Position END() {
        return new Position(last + 1); // Позиция после последнего
    }

    // Вставка элемента на позицию p
    public void INSERT(T x, Position p) {
        int pos = p.getIndex();
        if (pos < 0 || pos > last + 1 || last + 1 >= MAX_SIZE) {
            return; // Позиция недействительна или массив переполнен
        }

        // Сдвигаем элементы вправо, начиная с конца до позиции p
        for (int i = last + 1; i > pos; i--) {
            array[i][0] = array[i - 1][0];
            array[i][1] = i;
        }

        // Вставляем элемент
        array[pos][0] = x;
        array[pos][1] = pos; // Адрес (индекс)
        last++; // Увеличиваем указатель на последний элемент
    }

    // Возвращает позицию первого элемента, равного x, или END, если такого элемента нет
    public Position LOCATE(T x) {
        for (int i = 0; i <= last; i++) {
            if (array[i][0].equals(x)) {
                return new Position(i);
            }
        }
        return END(); // Если элемент не найден, возвращаем END
    }

    // Возвращает элемент по позиции p
    public T RETRIEVE(Position p) {
        int pos = p.getIndex();
        if (pos < 0 || pos > last) {
            throw new IllegalArgumentException("Неверная позиция.");
        }
        return (T) array[pos][0]; // Приведение типа
    }

    // Удаление элемента на позиции p
    public void DELETE(Position p) {
        int pos = p.getIndex();
        if (pos < 0 || pos > last) {
            return; // Позиция недействительна
        }

        // Сдвигаем элементы влево, начиная с позиции p
        for (int i = pos; i < last; i++) {
            array[i][0] = array[i + 1][0];
            array[i][1] = i;
        }
        last--; // Уменьшаем указатель на последний элемент
    }

    // Возвращает следующую позицию после p
    public Position NEXT(Position p) {
        int pos = p.getIndex();
        if (pos < 0 || pos >= last) {
            return END();
        }
        return new Position(pos + 1);
    }

    // Возвращает предыдущую позицию перед p
    public Position PREVIOUS(Position p) {
        int pos = p.getIndex();
        if (pos <= 0 || pos > last) {
            throw new IllegalArgumentException("Неверная позиция.");
        }
        return new Position(pos - 1);
    }

    // Очищает список и делает его пустым
    public void MAKENULL() {
        last = -1; // Список пуст, нет элементов
    }

    // Возвращает первую позицию в списке
    public Position FIRST() {
        return last == -1 ? END() : new Position(0);
    }

    // Выводит список на печать
    public void PRINTLIST() {
        for (int i = 0; i <= last; i++) {
            System.out.print(array[i][0] + " ");
        }
        System.out.println();
    }
}
