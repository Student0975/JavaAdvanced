package ua.com.cbs.homework.test4_ReadFileTxt;


import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * Створіть у пакеті текстовий файл і клас, внесіть у файл якийсь текст.
 * Виведіть на екран вміст файлу.
 */

public class Main {

  public static void main(String[] args) {
    URL fileURL = Main.class.getClassLoader().getResource("ua/com/cbs/homework/test4_ReadFileTxt/fileForReading1.txt");

    if (fileURL == null) {
      throw new RuntimeException("""
          File not found!
          ---> ua/com/cbs/homework/test4_ReadFileTxt/fileForReading.txt
          """);
    }

    try {
      List<String> results = Files.readAllLines(Paths.get(fileURL.toURI()));
      for (String result : results) {
        System.out.println(result);
      }
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}