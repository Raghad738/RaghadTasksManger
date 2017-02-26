package raghad_12_1_2016.topspy;

import android.location.Location;

import java.util.Date;

/**
 * Created by user on 11/17/2016.
 */
public class MyGps
{
    private double lat;//al3ard
    private double lng;//altool

    private Date time;

    public Date getTime() {

        return time;

    }

    public void setTime(Date time) {
        this.time = time;
    }
    public MyGps() {
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }
}
