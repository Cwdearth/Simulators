package cdearth.systems;

import java.util.ArrayList;
import java.util.Objects;

public class PlantCycler implements Cycler {

    ArrayList<Growable> subscribers = new ArrayList();

    Plantable growingLocation;

    public PlantCycler(Plantable growingLocation) {
        this.growingLocation = growingLocation;
    }

    public void unsubscribeGrowable(Growable subscriber) {
        subscribers.remove(Objects.requireNonNull(subscriber, "Subscriber cannot be null"));
    }

    public void subscribeGrowable(Growable subscriber) {
        subscribers.add(Objects.requireNonNull(subscriber, "Subscriber cannot be null"));
    }

    public void cycle() {
        System.out.println("There are " + subscribers.size() + 1 + " Growables On This Land!");
        System.out.println(growingLocation);
        for(int i = 0; i < subscribers.size(); i++) {
            growingLocation = subscribers.get(i).cycleEvent(growingLocation);
            System.out.println("Growable #" + i + " " + subscribers.get(i));
        }
        System.out.println(growingLocation);
    }
}
