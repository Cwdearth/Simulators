package cdearth.systems;

public interface Plantable {
    public double getWaterQty();

    public void waterEvent(double changeWater);

    public double getNutrientQty();

    public void nutrientEvent(double changeNutrient);
}
