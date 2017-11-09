package shower;

import java.util.Random;

public class Demo {

    public static void main(String[] args) {
        Human[] humans = new Human[20];
        for (int i = 0; i < humans.length; i++) {
            Gender gender = Gender.values()[new Random().nextInt(2)];
            humans[i] = new Human(gender, String.valueOf(i));
        }

        for (int i = 0; i < humans.length; i++) {
            System.out.print(humans[i].getHumanGender() +""+ i + " ");
        }
        System.out.println();

        for (int i = 0; i < humans.length; i++) {
            humans[i].start();
        }
    }
}
