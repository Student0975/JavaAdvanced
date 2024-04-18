package ua.com.cbs.homework.task2_Decoder;

/**
 * Напишіть жартівливу програму «Дешифратор»,
 * яка в текстовому файлі могла б замінити всі прийменники на слово «Java».
 */

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Prep {

  public static void main(String[] args) {

    String fileContents = "";

    URL fileURL = Prep.class.getResource("TextForDecoding.txt");
    if (fileURL == null) {
      throw new RuntimeException("""
          File not found!
          ---> TextForDecodingCopy.txt
          """);
    }

    File actualFile = new File(fileURL.getPath());

    try (Scanner sc = new Scanner(Paths.get(fileURL.toURI()))) {
      StringBuilder buffer = new StringBuilder();
      while (sc.hasNextLine()) {
        buffer.append(sc.nextLine()).append(System.lineSeparator());
      }
      fileContents = buffer.toString();
      System.out.println("Contents of the file:\n" + fileContents);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }

    // keep list of preposition to a String variable
    fileURL = Prep.class.getResource("ListOfPreposition.txt");
    if (fileURL == null) {
      throw new RuntimeException("""
          File not found!
          ---> ListOfPreposition.txt
          """);
    }

    StringBuilder strPrepositions = new StringBuilder();
    try {
      List<String> results = Files.readAllLines(Paths.get(fileURL.toURI()));
      List<Integer> recordOfPreposition = List.of(3, 5, 7, 9, 11);
      int currentRecord = 0;
      for (String result : results) {
        if (recordOfPreposition.contains(currentRecord)) {
          strPrepositions.append(result);
        }
        currentRecord++;
      }
    } catch (Exception e) {
      throw new RuntimeException(e.getMessage());
    }

    // split by ,
    String[] prepositionList = strPrepositions.toString().replaceAll(";", ",").split(",");

    for (int i = 0; i < prepositionList.length; i++) {
      prepositionList[i] = " " + prepositionList[i].trim() + " ";
    }

    ArrayList<String> al = new ArrayList<>();

    // seeking prepositions in the text and replacing to Java
    boolean flag = false;

    for (int i = 0; i < prepositionList.length; i++) {
      Pattern p = Pattern.compile(prepositionList[i], Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE);
      Matcher m = p.matcher(fileContents);
      flag = m.find();
      if (flag) {
        fileContents = m.replaceAll(" Java ");
        al.add(prepositionList[i]);
      }
    }

    try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(actualFile, false))) {
      bufferedWriter.append(fileContents);
      bufferedWriter.flush();
    } catch (IOException e) {
      System.out.println(e.getMessage());
    }

    try {
      List<String> strings = Files.readAllLines(Paths.get(actualFile.toURI()));
      for (String str : strings) {
        System.out.println(str);
      }
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

    System.out.println();
    System.out.println("Follow prepositions have been replaced:");
    for (String temp : al) System.out.println(temp);
  }
}
