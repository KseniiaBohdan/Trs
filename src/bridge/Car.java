package bridge;

import java.util.ArrayList;

import static java.lang.System.out;

public class Car extends Thread {

    private Direction direction;

    private String name;

    private static Object obj;

    public Direction getDirection() {
        return direction;
    }

    public Car(Direction direction, String name) {
        this.direction = direction;
        this.name = name;
        this.obj = new Object();
    }

    @Override
    public void run() {
        synchronized (obj) {
            ArrayList<Car> carsOnBridge = Bridge.getCars();
            if (carsOnBridge.isEmpty() || carsOnBridge.get(0).getDirection().equals(direction)) {
                rideOnBridge();
            } else {
                out.println("Не едет машина " + name + "" + direction);
            }
            interrupt();
        }
    }

    private void rideOnBridge() {
        Bridge.getCars().add(this);
        try {
            out.println("Едет машина " + name + "" + direction);
            obj.wait(1);
            out.println("Проехала машина " + name + "" + direction);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Bridge.getCars().remove(this);
    }
}
