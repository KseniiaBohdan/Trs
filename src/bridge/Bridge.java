package bridge;

import java.util.ArrayList;

public class Bridge {

    private static ArrayList<Car> cars = new ArrayList();

    public static ArrayList<Car> getCars() {
        return cars;
    }

}
