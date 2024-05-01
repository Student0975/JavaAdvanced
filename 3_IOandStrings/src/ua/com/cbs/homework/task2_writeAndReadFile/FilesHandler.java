package ua.com.cbs.homework.task2_writeAndReadFile;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FilesHandler {
  public File actualFile;

  public File createFile(String fileName) {
    actualFile = new File("3_IOandStrings/resources/" + fileName);
    if (!actualFile.exists()) {
      actualFile.getParentFile().mkdirs();
      try {
        actualFile.createNewFile();
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
    }
    return actualFile;
  }

  public void writeToFile(File actualFile) {
    try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(actualFile))){
      bufferedWriter.write("Hello world!");
      bufferedWriter.append("\n");
      bufferedWriter.append("Hooray!!!");
      bufferedWriter.flush();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  public void readFile(File actualFile) {
    try {
      List<String> results = Files.readAllLines(Paths.get(actualFile.toURI()));
      for (String result : results) {
        System.out.println(result);
      }
    } catch (IOException e) {
      throw new RuntimeException(e.getMessage());
    }
  }
}
