package parking;

import java.util.Random;

import static parking.Parking.getParking;

public class Car extends Thread {

    private static Object obj = new Object();

    public void setName(int name) {
        this.name = name;
    }

    private int name;

    @Override
    public void run() {
        while (true) {
            synchronized (obj) {
                int i;
                if ((i = findFreePlace()) >= 0) {
                    try {
                        obj.wait(1000 + new Random().nextInt(5000));
                        goAway(i);
                        obj.wait(1000 + new Random().nextInt(5000));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    interrupt();
                }
            }
        }
    }

    private void goAway(int i) {
        int[] places = getParking();
        places[i] = 0;
        System.out.println("Машина " + name + " освободила место: " + i);
    }

    private int findFreePlace() {
        int[] places = getParking();
        for (int i = 0; i < places.length; i++) {
            if (places[i] == 0) {
                places[i] = 1;
                System.out.println("Машина " + name + " заняла место: " + i);
                return i;
            }
        }
        System.out.println("Машина " + name + " уехала");
        return -1;
    }

}
