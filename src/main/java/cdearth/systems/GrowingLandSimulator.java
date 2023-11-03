package cdearth.systems;

import cdearth.subsystems.BasicLand;

import cdearth.subsystems.Plant;

public class GrowingLandSimulator {

    private Plantable eden = new BasicLand("Luscious Land", 10.0, 10.0, 0.1);

    private Cycler eventCycler = new PlantCycler(eden);

    private Growable grassPlant = new Plant("grassPlant", 0.1, 100.0, 0.5, 10, 0.5, 10, 50, eventCycler);

    public GrowingLandSimulator(){
    }

    public void executeSimulator() {
        eventCycler.subscribeGrowable(grassPlant);

        for (int i = 0; i < 100; i++) {
            eventCycler.cycle();
        }
    }
}
