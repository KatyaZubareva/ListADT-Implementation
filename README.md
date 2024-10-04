# ListADT-Implementation

This project implements a List Abstract Data Type (ADT) using two different representations: an array and a linked list. The implementation is designed to be modular, allowing the `main` method to work seamlessly with both representations by simply changing the imported package.

## Features

- **Array Representation**:
  - Efficient for random access.
  - Elements are stored in a contiguous block of memory.
  
- **Linked List Representation**:
  - Efficient for insertion and deletion.
  - Elements are linked using pointers.

## Operations Supported

- `END(L)`: Returns the position after the last element in list `L`.
- `INSERT(x, p, L)`: Inserts an element `x` at position `p` in list `L`.
- `LOCATE(x, L)`: Returns the position of element `x` in list `L`. If `x` is not in the list, returns the position after the last element.
- `RETRIEVE(p, L)`: Retrieves the element at position `p` in list `L`.
- `DELETE(p, L)`: Deletes the element at position `p` in list `L`.
- `NEXT(p, L)`: Returns the position following `p` in list `L`.
- `PREVIOUS(p, L)`: Returns the position preceding `p` in list `L`.
- `MAKENULL(L)`: Empties list `L`.
- `FIRST(L)`: Returns the first position in list `L`.
- `PRINTLIST(L)`: Prints the elements of list `L`.

## Project Structure

The project is divided into separate packages for each representation of the List ADT. Each package contains the necessary classes and methods to support the operations listed above.

- **arraylist**: Implements the List ADT using an array.
- **linkedlist**: Implements the List ADT using a linked list.
- **main**: Contains the `Main` class to test the operations, including removing duplicates from the list.

## How to Use

1. Clone the repository:
    ```bash
    git clone https://github.com/yourusername/ListADT-Implementation.git
    ```
2. Navigate to the project directory:
    ```bash
    cd ListADT-Implementation
    ```
3. To test the array implementation, ensure the `arraylist` package is imported in the `Main` class.
4. To test the linked list implementation, switch the import in the `Main` class to the `linkedlist` package.

## Example Usage

```java
import arraylist.ListADT; // or linkedlist.ListADT

public class Main {
    public static void main(String[] args) {
        ListADT list = new ListADT(10);

        list.INSERT("A", list.END());
        list.INSERT("B", list.END());
        list.INSERT("A", list.END());
        list.INSERT("C", list.END());

        list.PRINTLIST(); // Output: A B A C

        // Remove duplicates and print again
        removeDuplicates(list);
        list.PRINTLIST(); // Output: A B C
    }

    public static void removeDuplicates(ListADT list) {
        // Implementation to remove duplicates
    }
}
