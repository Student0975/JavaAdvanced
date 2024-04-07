package ua.com.cbs.homework.task2_DubbedList;

import java.util.List;

/**
 *Використовуючи колекцію, підвійте слово:
 * 1. Введіть із клавіатури 5 слів до списку рядків.
 * 2. Метод doubleValues повинен підвоювати слова за принципом a, b, c -> a, a, b, b, c, c.
 * 3. Використовуючи цикл for виведіть результат на екран, кожне значення нового рядка.
 */

public class Main {

  public static void main(String[] args) {
    List<String> initList = ListHandler.enterList();
    System.out.println("\nInitial list:");
    ListHandler.printList(initList);

    System.out.println("Dubbed list:");
    ListHandler.printList(ListHandler.doubleValues(initList));
  }
}
