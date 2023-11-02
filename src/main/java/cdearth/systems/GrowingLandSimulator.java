package cdearth.systems;

import cdearth.subsystems.BasicLand;

import cdearth.subsystems.Plant;

public class GrowingLandSimulator {

    private Plantable eden = new BasicLand("Luscious Land", 10.0, 10.0, 0.2);

    private Cycler eventCycler = new PlantCycler(eden);

    private Growable grassPlant = new Plant("grassPlant", 0.1, 2.0, 0.2, 10, 0.5, 2, 15, eventCycler);

    public void executeSimulator() {
        eventCycler.subscribeGrowable(grassPlant);

        int cycleTimer = 1000;
        while(true) {
            for (int i = 0; i == cycleTimer; i++) {
            }
            eventCycler.cycle();
        }
    }
}
