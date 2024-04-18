package ua.com.cbs.homework.task3_HowMuchTimePassed;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MenuHandler {
  final Scanner scanner;

  public MenuHandler() {
    this.scanner = new Scanner(System.in);
  }

  public void printMenu() {
    System.out.println("""
        Menu
        ---------
        1. Input birthday date
        2. How old you are
        ---------
        3. Exit
        """);
    System.out.println("Make your choice :");
  }

  public boolean verifyInputConditions(int menuChoice, Person person) {
    switch (menuChoice) {
      case 1 -> {
        System.out.println("Please, input your date of birthday DD/MM/YYYY :");
        scanner.nextLine();
        String enteredBDay = scanner.nextLine();
        if (verifyInputBDay(enteredBDay)) {
          DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
          LocalDate dateTime = LocalDate.parse(enteredBDay, formatter);
          person.setBDay(dateTime);
        }
        return true;
      }
      case 2 -> {
        if (person.getBDay() == null) {
          System.out.println("No birthday point out!");
          return true;
        }
        System.out.println("Today is         : " + LocalDate.now());
        System.out.println("Your birthday is : " + person.getBDay());

        LocalDate today = LocalDate.now();
        LocalDateTime localDateTimeToday = LocalDateTime.now();
        Period period = Period.between(person.getBDay(), today);
        Duration duration = Duration.between(person.getBDay().atStartOfDay().toLocalTime(), localDateTimeToday.toLocalTime());

        System.out.println("Your age is      : " + period.getYears() + " years " +
            period.getMonths() + " months " +
            period.getDays() + " days " +
            duration.toHoursPart() + " hours " +
            duration.toMinutesPart() + " minutes " +
            duration.toSecondsPart() + " seconds.");

        return false;
      }
      case 3 -> {
        System.out.println("Goodbye!");
        return false;
      }
      default -> {
        System.out.println("""
            Input must be only among 1/2/3!
            Please, try to input again.
            """);
        return true;
      }
    }
  }

  private boolean verifyInputBDay(String enteredBDay) {
    String regex = "(0[1-9]|[12][0-9]|3[01])\\/(0[1-9]|1[0-2])\\/(19|20)\\d{2}";
    Pattern p = Pattern.compile(regex);
    Matcher m = p.matcher(enteredBDay);
    if (!m.matches()) {
      System.out.println("""
          Entered date does not match to the pattern DD/MM/YYYY!
          Please, input your date of birthday again (Menu > 1)\n
          """);
    }
    return m.matches();
  }
}

