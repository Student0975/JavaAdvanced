package ua.com.cbs.homework.task2_writeAndReadFile;


import java.io.File;

/**
 * Створіть файл, запишіть у нього довільні дані та закрийте файл.
 * Потім знову відкрийте цей файл, прочитайте дані і виведіть їх на консоль.
 */

public class Main {

  public static void main(String[] args) {
    String fileName = "testFile.txt";

    FilesHandler filesHandler = new FilesHandler();
    File actualFile = filesHandler.createFile(fileName);
    filesHandler.writeToFile(actualFile);
    filesHandler.readFile(actualFile);
  }
}
