package ua.com.cbs.homework.task2_DubbedList;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListHandler {

  public static void printList(List<String> list) {
    for (String temp : list) {
      System.out.print(temp + " ");
    }
    System.out.println("\n");
  }

  public static List<String> enterList() {
    List<String> stringList = new ArrayList<>();
    try (Scanner scanner = new Scanner(System.in)) {
      System.out.println("Enter 5 words with enter:");
      for (int i = 0; i < 5; i++) {
        stringList.add(scanner.nextLine());
      }
      return stringList;
    }
  }

  public static List<String> doubleValues(List<String> initList) {
    List<String> dubbedList = new ArrayList<>(initList);
    for (int i = 0; i < initList.size(); i++) {
      dubbedList.add((2 * i + 1), initList.get(i));
    }
    return dubbedList;
  }

}
