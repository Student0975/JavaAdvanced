package ua.com.cbs.homework.task4_WhoLiveInCity;

import java.util.InputMismatchException;

/**
 * Програма визначає, яка сім'я (прізвище) живе у місті:
 * Приклад введення:
 * · Москва
 * · Іванови
 * · Київ
 * · Петрови
 * · Лондон
 * · Абрамовичі
 * Приклад введення:
 * · Лондон
 * Приклад виведення:
 * · Абрамовичі
 */

public class Main {

  public static void main(String[] args) {
    MenuHandler menuHandler = new MenuHandler();
    int choiceMenu;

    try (menuHandler.scanner) {
      do {
        choiceMenu = 0;
        printMainMenu();
        try {
          choiceMenu = menuHandler.scanner.nextInt();
        } catch (InputMismatchException ex) {
          menuHandler.scanner.next();
        }
      } while (verifyInputConditions(menuHandler, choiceMenu));
    }
  }

  private static boolean verifyInputConditions(MenuHandler menuHandler, int choiceMenu) {
    switch (choiceMenu) {
      case 1 -> {
        menuHandler.autoFillIn(menuHandler.map);
        return true;
      }
      case 2 -> {
        if (menuHandler.map.isEmpty()) {
          System.out.println("No data yet!");
        } else {
          menuHandler.viewAll(menuHandler.map);
        }
        return true;
      }
      case 3 -> {
        if (menuHandler.map.isEmpty()) {
          System.out.println("No data yet!");
        } else {
          menuHandler.getInfo(menuHandler.map);
        }
        return true;
      }
      case 4 -> {
        System.out.println("Goodbye!");
        return false;
      }
      default -> {
        System.out.println("""
            Your choice must be only from 1/2/3!
            Please, try to chose again!
            """);
        return true;
      }
    }
  }

  private static void printMainMenu() {
    System.out.print("""
        \nMenu:
        -------------
        1. Automatically fill in (Random mode)
        2. View a list
        3. Get info of specific surname
        -------------
        4. Exit
                
        Please, make your choice :
        """);
  }
}