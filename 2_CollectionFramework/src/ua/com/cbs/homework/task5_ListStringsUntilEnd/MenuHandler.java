package ua.com.cbs.homework.task5_ListStringsUntilEnd;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuHandler {
  final Scanner scanner;
  List<String> list;

  public MenuHandler() {
    scanner = new Scanner(System.in);
    list = new ArrayList<>();
  }

  public void fillIn() {
    boolean end = true;
    System.out.println("Input a line (type 'end' for ending) :");
    while (end) {
      String line = scanner.nextLine();
      if (!line.equalsIgnoreCase("end")) list.add(line);
      else end = false;
    }
  }

  public void displayAll(List<String> list) {
    for (String line : list) {
      System.out.println(line);
    }
  }
}
