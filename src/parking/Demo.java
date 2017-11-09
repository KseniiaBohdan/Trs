package parking;

public class Demo {

    public static void main(String[] args) {

        for (int i = 0; i < Parking.getParking().length; i++) {
            System.out.print(Parking.getParking()[i] + " ");
        }
        System.out.println();

        Car[] cars = new Car[3];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car();
            cars[i].setName(i);
        }

        for (int i = 0; i < cars.length; i++) {
            cars[i].start();
        }
    }
}
