package shower;

public class Shower {

    private static boolean free = true;

    private static Gender gender = null;

    private static int capacity = 0;

    public static boolean isFree() {
        return free;
    }

    public static int getCapacity() {
        return capacity;
    }

    public static void setCapacity(int capacity) {
        Shower.capacity = capacity;
    }

    public static void setFree(boolean free) {
        Shower.free = free;
    }


    public static Gender getGender() {
        return gender;
    }

    public static void setGender(Gender gender) {
        Shower.gender = gender;
    }
}
