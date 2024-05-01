package ua.com.cbs.homework.task3_MinNumberInLinkedList;

/**
 * Мінімальне з N чисел (використовувати LinkedList):
 * 1. Введіть із клавіатури число N.
 * 2. Вважати N цілих чисел і заповнити ними список - метод getIntegerList.
 * 3. Знайти мінімальне число серед елементів списку – метод getMinimum.
 */

import java.util.*;

public class Main {

  public static void main(String[] args) {
    int n = ListHandler.enterNumber();
    List<Integer> integerList = ListHandler.getIntegerList(n);

    System.out.println("Initial list :");
    ListHandler.printList(integerList);

    System.out.println("Minimum value in the list :");
    System.out.println(ListHandler.getMinimum(integerList));
    System.out.println(ListHandler.getMinimumWithIterator(integerList));
    System.out.println(ListHandler.getMinimumWithPriorityQueue(integerList));

  }
}

