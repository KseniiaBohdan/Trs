package shower;

import java.util.Random;

import static shower.Shower.*;

public class Human extends Thread {

    private Gender humanGender;

    private String name;

    private Object obj;

    public Human(Gender gender, String name) {
        obj = new Object();
        this.humanGender = gender;
        this.name = name;
    }

    @Override
    public void run() {
        synchronized (obj) {
            if (isFree()) {
                setFree(false);
                setGender(humanGender);
                takeShower();
            } else {
                if (humanGender == getGender()) {
                    takeShower();
                } else {
                    interrupt();
                }
            }
        }

    }

    private void takeShower() {
        try {
            System.out.println("Пришла " + humanGender + name + " Сейчас душ для = " + getGender() + " и в нем " + (getCapacity() + 1) + " человек");
            setCapacity(getCapacity() + 1);
            obj.wait(1 + new Random().nextInt(8));
            setCapacity(getCapacity() - 1);
            if (getCapacity() == 0) {
                setFree(true);
                setGender(null);
            }
            System.out.println("Ушла " + humanGender + name + " Сейчас душ для = " + getGender() + " и в нем " + (getCapacity() + 1) + " человек");
            interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public Gender getHumanGender() {
        return humanGender;
    }
}
