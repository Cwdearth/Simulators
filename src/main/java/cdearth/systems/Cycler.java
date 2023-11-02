package cdearth.systems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

public interface Cycler {

    public void unsubscribeGrowable(Growable subscriber);


    public void subscribeGrowable(Growable subscriber);

    public void cycle();
}
