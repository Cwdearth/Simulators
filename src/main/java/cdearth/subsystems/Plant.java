package cdearth.subsystems;

import cdearth.systems.Cyclable;
import cdearth.systems.Cycler;
import cdearth.systems.Growable;
import cdearth.systems.Plantable;

public class Plant implements Growable {

    private String plantName;
    private double nutrientDemand;
    private double waterDemand;
    private double growthRate;
    private double size = 0.0;
    private double conditionLevel;

    private double grownWhen;

    private double producingRequirement;

    private int yieldTrial = 0;

    private int yieldRequirement;

    private Cycler cycler;
    private Growable blueprint;

    private double deathCycles;

    private double deathCyclesAmount = 0.0;

    /*
        yieldRequirement: the amount of trials that must pass before a yield event occurs.
        producingRequirement: 0.0 - 1.0 the condition that must be met for a cycle to count as a trial success.
        lifeForce: A number that will
     */

    public Plant(String plantName, double nutrientDemand, double waterDemand, double growthRate, double grownWhen, double producingRequirement, int yieldRequirement, double deathCycles, Cycler cycler) {
        this.plantName = plantName;
        this.nutrientDemand = nutrientDemand;
        this.waterDemand = waterDemand;
        this.growthRate = growthRate;
        this.grownWhen = grownWhen;
        this.producingRequirement = producingRequirement;
        this.yieldRequirement = yieldRequirement;
        this.cycler = cycler;
        this.deathCycles = deathCycles;
        blueprint = this;
    }

    public String getPlantName() {
        if (size < grownWhen)
            return plantName + " seed.";
        else
            return "Grown " + plantName + ".";
    }

    @Override
    public Plantable cycleEvent(Plantable growingLocation) {
        updateConditionLevel(growingLocation);
        growingLocation.waterEvent(-waterDemand);
        growingLocation.nutrientEvent(-nutrientDemand);

        if (size < grownWhen)
            size += growthRate * conditionLevel;
        else
            deathCyclesAmount += 1;
            if (conditionLevel >= producingRequirement) {
                yieldTrial += 1;
                // THIS CAN BE CUSTOMIZABLE LATER
                if (yieldTrial >= yieldRequirement) {
                    yieldTrial = 0;
                    cycler.subscribeGrowable(blueprint);
                }
            }
            else
                deathCyclesAmount += 1;
        age(growingLocation);
        return growingLocation;
    }

    public void updateConditionLevel(Plantable growingLocation) {
        double nutrientLevel = Math.min(1.0, growingLocation.getNutrientQty() / nutrientDemand);
        double waterLevel = Math.min(1.0, growingLocation.getWaterQty() / waterDemand);
        conditionLevel = (nutrientLevel + waterLevel) / 2;
    }

    @Override
    public void age(Plantable growingLocation) {
        if (deathCyclesAmount >=deathCycles) {
            growingLocation.nutrientEvent(size/nutrientDemand);
            cycler.unsubscribeGrowable(this);
        }
    }

    @Override
    public double getSize() {
        return size;
    }

    public String toString() {
        return "Plant{" +
                "plantName='" + getPlantName() + '\'' +
                ", size=" + size +
                ", conditionLevel=" + conditionLevel +
                ", yieldTrial=" + yieldTrial +
                '}';
    }

    @Override
    public void cycleEvent() {
        // SHOULDN'T REALLY EXIST, WILL DEAL WITH LATER
    }
}
