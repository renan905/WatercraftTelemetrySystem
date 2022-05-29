package WatercraftTelemetrySystem;

import WatercraftTelemetrySystem.Database.RepositoryController;
import WatercraftTelemetrySystem.GeoLocation.GeoLocationEntity;

import java.util.List;

public class WatercraftTelemetrySystem {

    public static void main (String[] args) {

        RepositoryController repo = new RepositoryController();
        GeoLocationEntity geoData = new GeoLocationEntity();

        geoData.setTimestamp("1653828601");
        geoData.setGeolocation("-20.75902915348214, -42.871074831110946");

        repo.getGeoLocation().insertGeoLocationData(geoData);

        List<GeoLocationEntity> geoLocations = repo.getGeoLocation().getAllGeoLocation();
        for (GeoLocationEntity geoLocation : geoLocations) {
            System.out.printf("%s - %s \n",
                    geoLocation.getTimestamp(), geoLocation.getGeolocation());
        }
    }
}
