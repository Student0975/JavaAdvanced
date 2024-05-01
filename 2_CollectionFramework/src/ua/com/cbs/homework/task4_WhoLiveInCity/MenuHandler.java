package ua.com.cbs.homework.task4_WhoLiveInCity;

import java.util.*;

public class MenuHandler {
  final Scanner scanner;
  Map<String, String> map;

  public MenuHandler() {
    scanner = new Scanner(System.in);
    map = new HashMap<>();
  }

  public void autoFillIn(Map<String, String> map) {
    String[] cities = {"Kyiv", "Kharkiv", "Odesa", "Dnipro", "Donetsk", "Mykolaiv", "Mariupol", "Luhansk"};
    String[] families = {"Antonenko", "Bilovol", "Vasylyk", "Hryhorenko", "Gogol", "Dovzhenko", "Yevtushenko", "Zinchenko"};
    Random random = new Random();

    for (int i = 0; i < 10; i++) {
      String city = cities[random.nextInt(8)];
      String family = families[random.nextInt(8)];
      map.put(city.toUpperCase(), family.toUpperCase());
    }
    System.out.println("Done! Created 10 pairs.");
  }

  public void viewAll(Map<String, String> map) {
    for (Map.Entry<?, ?> entry : map.entrySet()) {
      System.out.printf("%-10s : %s%n", entry.getKey(), entry.getValue());
    }
  }

  public void getInfo(Map<String, String> map) {
    System.out.println("Input surname :");
    String surname = scanner.next();
    if (map.containsValue(surname.toUpperCase())) {
      for (Map.Entry<?, ?> entry : map.entrySet()) {
        if (entry.getValue().equals(surname.toUpperCase()))
          System.out.printf("%-10s : %s%n", entry.getKey(), entry.getValue());
      }
    } else {
      System.out.println("No info about : " + surname.toUpperCase());
    }
  }
}



