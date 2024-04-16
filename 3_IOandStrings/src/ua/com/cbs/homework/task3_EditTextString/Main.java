package ua.com.cbs.homework.task3_EditTextString;

/**
 * Необхідно створити рядок із текстом (текст взяти будь-який з інтернету).
 * Розбити цей рядок на 2 підрядки рівної довжині та вивести на екран кожну речення з нового рядка.
 */

public class Main {
  public static void main(String[] args) {
    String s = "В Белгород-Днестровском Одесской области случился замес с участием мэра города, во время которого он отвесил подзатыльника одному из своих хейтеров.";
    String s1 = "When Europe talks about aid for Ukraine, it looks to itself and the United States. " +
        "But for months, politicians in Washington have been unable to agree on a new multibillion aid package for Kyiv. " +
        "As a result, other countries have increased their share of support. Among them is Japan, which, " +
        "according to Ukraine's Finance Ministry, has quietly become one of Kyiv's most important financial backers, " +
        "leading the way in the first months of 2024.";

    StringHandler stringHandler = new StringHandler();
    stringHandler.stringProcessing(s);
    stringHandler.stringProcessing(s1);
  }
}
