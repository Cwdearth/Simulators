package cdearth.subsystems;

import cdearth.systems.Cyclable;
import cdearth.systems.Plantable;

import java.util.Objects;

public class BasicLand implements Cyclable, Plantable {

    private String landType;
    private double waterQty = 0.0;
    private double nutrientQty = 0.0;
    private double waterRegenAmount = 0.0;

    public BasicLand(String landType, double waterQty, double nutrientQty, double waterRegenAmount) {
        this.landType = Objects.requireNonNull(landType, "A landType name is required.");
        this.waterQty = Math.max(0.0, waterQty);
        this.nutrientQty = Math.max(0.0, nutrientQty);
        this.waterRegenAmount = Math.max(0.0, waterRegenAmount);
    }

    public double getWaterQty() {
        return waterQty;
    }

    public void waterEvent(double changeWater) {
        waterQty += Math.max(0.0, nutrientQty + changeWater);
    }

    public double getNutrientQty() {
        return nutrientQty;
    }

    public void nutrientEvent(double changeNutrient) {
        nutrientQty = Math.max(0.0, nutrientQty + changeNutrient);
    }

    public void cycleEvent() {
        waterQty += waterRegenAmount;
    }

    @Override
    public String toString() {
        return "BasicLand{" +
                "landType='" + landType + '\'' +
                ", waterQty=" + waterQty +
                ", nutrientQty=" + nutrientQty +
                '}';
    }
}
