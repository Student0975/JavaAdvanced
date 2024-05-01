package ua.com.cbs.homework.task3_MinNumberInLinkedList;

import java.util.*;

public class ListHandler {
  public static List<Integer> getIntegerList(int n) {
    List<Integer> integerList = new LinkedList<>();
    Random random = new Random();
    for (int i = 0; i < n; i++) {
      integerList.add(random.nextInt());
    }
    return integerList;
  }

  public static void printList(List<Integer> integerList) {
    for (Integer number : integerList) {
      System.out.println(number + " ");
    }
  }

  public static int enterNumber() {
    int n = 0;
    try (Scanner scanner = new Scanner(System.in)) {
      do {
        System.out.println("Input a positive integer number:");
        try {
          n = scanner.nextInt();
        } catch (InputMismatchException ex) {
          scanner.nextLine();
        }
      } while (conditionInputVerify(n));
    }
    return n;
  }

  private static boolean conditionInputVerify(int n) {
    if (n <= 0) {
      System.out.println("""
          Input must be a positive integer number!
          Try to input again!
          """);
      return true;
    }
    return false;
  }

  public static Integer getMinimum(List<Integer> integerList) {
    return Collections.min(integerList);
  }

  public static Integer getMinimumWithIterator(List<Integer> integerList) {
    int min = Integer.MAX_VALUE;
    Iterator<Integer> iterator = integerList.iterator();
    while (iterator.hasNext()) {
      Integer current = iterator.next();
      if (current < min) {
        min = current;
      }
    }
    return min;
  }

  public static int getMinimumWithPriorityQueue(List<Integer> list) {
    Queue<Integer> queue = new PriorityQueue<>(list);
    Integer headElement = queue.poll();
    if (headElement != null) {
      return headElement;
    } else {
      throw new NoSuchElementException("List is empty");
    }
  }
}

