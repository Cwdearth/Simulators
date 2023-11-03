package cdearth;

import cdearth.systems.GrowingLandSimulator;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws CloneNotSupportedException {
        GrowingLandSimulator sim = new GrowingLandSimulator();
        sim.executeSimulator();
    }

}
