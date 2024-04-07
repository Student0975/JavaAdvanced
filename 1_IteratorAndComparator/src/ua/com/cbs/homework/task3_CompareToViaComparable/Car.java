package ua.com.cbs.homework.task3_CompareToViaComparable;

public class Car implements Comparable {
  int speed;
  int price;
  String model;
  String color;

  Car(int speed, int price, String model, String color) {
    this.speed = speed;
    this.price = price;
    this.model = model;
    this.color = color;
  }

  @Override
  public String toString() {
    return this.model + " " + this.color + " " + this.speed + " " + this.price;
  }

  @Override
  public int compareTo(Object o) {
    if (this.speed != ((Car) o).speed)
      return this.speed - ((Car) o).speed;

    if (this.price != ((Car) o).price)
      return this.price - ((Car) o).price;

    if (!this.model.equalsIgnoreCase(((Car) o).model))
      return this.model.compareTo(((Car) o).model);

    return this.color.compareTo(((Car) o).color);
  }
}
