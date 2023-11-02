package cdearth;

import cdearth.systems.GrowingLandSimulator;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        GrowingLandSimulator sim = new GrowingLandSimulator();
        sim.executeSimulator();
    }

}
