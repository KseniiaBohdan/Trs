package bridge;

import java.util.Random;

import static bridge.Direction.values;
import static java.lang.String.valueOf;

public class Demo {

    public static void main(String[] args) {
        Car[] cars = new Car[20];

        for (int i = 0; i < cars.length; i++) {
            Direction direction = values()[new Random().nextInt(2)];
            cars[i] = new Car(direction, valueOf(i));
            System.out.print(i + "" + direction.toString() + " ");
        }
        System.out.println();

        for (int i = 0; i < cars.length; i++) {
            cars[i].start();
        }
    }
}
