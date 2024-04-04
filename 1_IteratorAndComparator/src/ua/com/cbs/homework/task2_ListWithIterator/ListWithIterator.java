package ua.com.cbs.homework.task2_ListWithIterator;

import java.util.*;

/**
 * Виведення на екран елементів List:
 * Створити список,
 * заповнити його на 10 елементів
 * та вивести на екран вміст, використовуючи iterator.
 */

public class ListWithIterator {

  public static void main(String[] args) {
    String[] firstNames = {"Adam", "Bruce", "Cristian", "Derek", "Edward", "Frank", "Gary"};
    String[] lastNames  = {"Abrams", "Barbosa", "Cooper", "Dormant", "Eagle", "Falcon", "Green"};
    Random random = new Random();

    List<String> arrayList = new ArrayList<>();
    for (int i = 0; i < 10; i++) {
      arrayList.add(i + ". " + firstNames[random.nextInt(firstNames.length)] + " " + lastNames[random.nextInt(lastNames.length)]);
    }

    Iterator<String> iterator = arrayList.iterator();
    while (iterator.hasNext()) {
      System.out.println(iterator.next());
    }

    System.out.println("-".repeat(15));

    ListIterator<String> listIterator = arrayList.listIterator();
    while (listIterator.hasNext()) {
      System.out.println(listIterator.next());
    }

  }
}
