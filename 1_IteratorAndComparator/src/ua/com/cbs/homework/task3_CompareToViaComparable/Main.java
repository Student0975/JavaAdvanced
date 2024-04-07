package ua.com.cbs.homework.task3_CompareToViaComparable;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Car c1 = new Car(190,2000,"BMW","C");
        Car c2 = new Car(190,2000,"BMW","B");
        Car c3 = new Car(190,2000,"BMW","A");
        Car[] cars = {c1, c2, c3};

        Arrays.sort(cars);   // ClassCastException
        for (Car temp : cars) {
            System.out.println(temp);
        }
    }
}
