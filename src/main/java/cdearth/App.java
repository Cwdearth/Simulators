package cdearth;

import cdearth.subsystems.Sun;
import cdearth.systems.GrowingLandSimulator;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        //GrowingLandSimulator sim = new GrowingLandSimulator();
        //sim.executeSimulator();
        //
        Sun sun = new Sun(90);
        for(int i = 0; i < 24; i++)
            System.out.println(sun.getAltitude(365, i));

    }

}
