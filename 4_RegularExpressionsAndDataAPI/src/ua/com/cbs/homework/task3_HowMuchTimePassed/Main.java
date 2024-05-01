package ua.com.cbs.homework.task3_HowMuchTimePassed;

import java.util.InputMismatchException;

/**
 * Спроєктувати та розробите метод, який визначає, скільки часу пройшло із заданої дати.
 * За допомогою цього методи виведіть у консоль, скільки часу пройшло з вашого дня народження
 * у зручному для сприйняття вигляді,
 * наприклад: «Вам виповнилося 20 років, 3 місяці, 18 днів, 4 години, 5 хвилин та 10 секунд».
 */

public class Main {

  public static void main(String[] args) {
    Person person = new Person();
    MenuHandler menu = new MenuHandler();

    int menuChoice;

    try (menu.scanner) {
      do {
        menuChoice = 0;
        menu.printMenu();
        try {
          menuChoice = menu.scanner.nextInt();
        } catch (InputMismatchException ex) {
          menu.scanner.nextLine();
        }
      } while (menu.verifyInputConditions(menuChoice, person));
    }
  }
}
