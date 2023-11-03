package cdearth.subsystems;

import static java.lang.Math.cos;
import static java.lang.Math.tan;

import java.security.InvalidParameterException;

public class Sun {

    private final double latitude;

    private double declination;

    public Sun(double latitude) {
        this.latitude = latitude;
    }

    public double getAltitude(int day, int hour) {
        if(hour < 0 || hour > 24)
            throw new InvalidParameterException("The hour parameter must be from 0 to 24");

        declination = getDeclination(day);

        double maxAlt = getSunsMaxAlt(latitude);
        double solarAngleHour = Math.toDegrees(Math.acos(Math.toRadians(Math.max(Math.min(-tan(declination * Math.PI/180)*tan(latitude*Math.PI/180),1.0),1.0))));
        return Math.sin((15 * Math.PI * (solarAngleHour/15 + hour - 12))/(2 * solarAngleHour)) * maxAlt;
    }

    // Returns altitude in degrees
    private double getSunsMaxAlt(double latitude) {
        if(latitude > 90 || latitude < -90)
            throw new InvalidParameterException("The latitude parameter must be from -90.0 to 90.0");

        if(latitude >= 0) {
            return (double) 90 - (latitude - declination);
        }
        else
            return (double) 90 - (latitude + declination);
    }

    // Returns declination in degrees
    private double getDeclination(int day) {
        if(day >= 0 && day <= 365) {
            return -23.45 * cos(Math.toRadians((double) 360 /365 * (day + 10)));
        }
        else
            throw new InvalidParameterException("The day parameter must be from 0 to 365");
    }
}
