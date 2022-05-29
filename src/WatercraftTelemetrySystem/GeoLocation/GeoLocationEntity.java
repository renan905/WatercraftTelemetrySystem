package WatercraftTelemetrySystem.GeoLocation;

import java.util.Objects;

public class GeoLocationEntity {
    private String timestamp;
    private String geolocation;

    public void copyFrom(GeoLocationEntity source) {

        if(!Objects.equals(source.getGeolocation(), getGeolocation())) {
            setGeolocation(source.getGeolocation());
        }

        if(!Objects.equals(source.getTimestamp(), getTimestamp())) {
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
