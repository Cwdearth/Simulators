package cdearth.systems;

public interface Growable extends Cyclable {
    public Plantable cycleEvent(Plantable growingLocation);
    public void updateConditionLevel(Plantable growingLocation);
    public void age(Plantable growingLocation);
    public double getSize();
}
