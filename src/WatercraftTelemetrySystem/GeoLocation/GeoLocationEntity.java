package WatercraftTelemetrySystem.GeoLocation;

import org.jetbrains.annotations.NotNull;

import java.sql.Timestamp;

public class GeoLocationEntity {
    private String timestamp;
    private String geolocation;

    public void copyFrom(@NotNull GeoLocationEntity source) {

        if(source.getGeolocation() != getGeolocation()) {
            setGeolocation(source.getGeolocation());
        }

        if(source.getTimestamp()!= getTimestamp()) {
            setTimestamp(source.getTimestamp());
        }
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getGeolocation() {
        return geolocation;
    }

    public void setGeolocation(String geolocation) {
        this.geolocation = geolocation;
    }

}
