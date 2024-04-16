package ua.com.cbs.homework.task3_EditTextString;

public class StringHandler {
  public void stringProcessing(String s) {
    if (s.trim().length() >> 1 != 0) {  // if string's length is not even
      s += " ";
    }
    String half1 = s.substring(0, s.length() / 2);
    String half2 = s.substring(s.length() / 2);

    printHalf(half1, 1);
    printHalf(half2, 2);
    System.out.println();
  }

  private void printHalf(String line, int whichHalf) {
    String[] strings = line.split("\\.", -1);

    if (!line.endsWith(".")) {        // if the last symbol of half1 is not '.'
      for (int i = 0; i < strings.length - 1; i++) {
        if (whichHalf == 2 && i==0) System.out.println(strings[i] + ".");
        else System.out.println(strings[i].trim() + ".");
      }
      System.out.print(strings[strings.length - 1].trim());
    } else for (String string : strings) {
      System.out.println(string.trim() + ".");
    }
  }
}

