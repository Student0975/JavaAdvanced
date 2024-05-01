package ua.com.cbs.homework.task5_ListStringsUntilEnd;

import java.util.InputMismatchException;

/**
 * Вводити з клавіатури рядки, доки користувач не введе рядок 'end':
 * 1. Створити перелік рядків.
 * 2. Ввести рядки з клавіатури та додати їх до списку.
 * 3. Вводити з клавіатури рядки, доки користувач не введе рядок "end". "end" не враховувати.
 * 4. Вивести рядки на екран, кожен з нового рядка.
 */

public class Main {

  public static void main(String[] args) {
    MenuHandler menuHandler = new MenuHandler();

    int choiceMenu;

    try (menuHandler.scanner) {
      do {
        choiceMenu = 0;
        printMenu();
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
        menuHandler.fillIn();
        return true;
      }
      case 2 -> {
        if (menuHandler.list.isEmpty()) {
          System.out.println("No lines yet!");
        } else {
          menuHandler.displayAll(menuHandler.list);
        }
        return true;
      }
      case 3 -> {
        System.out.println("Goodbye!!!");
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

  private static void printMenu() {
    System.out.println("""
        \nMenu
        -----------
        1. Input a line (type 'end' for ending)
        2. Display all lines
        -----------
        3. Exit
                
        Please, make your choice :
        """);
  }
}
