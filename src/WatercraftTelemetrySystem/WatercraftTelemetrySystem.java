package WatercraftTelemetrySystem;

import WatercraftTelemetrySystem.Database.RepositoryController;
import WatercraftTelemetrySystem.GeoLocation.GeoLocationEntity;
import WatercraftTelemetrySystem.Helpers.Helpers;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class WatercraftTelemetrySystem {

    public static void main (String[] args) throws IOException {

        RepositoryController repo = new RepositoryController();
        GeoLocationEntity geoData = new GeoLocationEntity();

        String ts = Helpers.getStringTimestamp();
        geoData.setTimestamp(ts);
        geoData.setGeolocation("-20.75902915348214, -42.871074831110946");

        repo.getGeoLocation().insertGeoLocationData(geoData);
        repo.getGeoLocation().printGeoLocationData();

        GeoLocationEntity update = repo.getGeoLocation().getGeoLocation(ts);
        GeoLocationEntity update2 = repo.getGeoLocation().getGeoLocation(ts);
        update2.setGeolocation("1000, 2000");
        repo.getGeoLocation().updateGeoLocation(update, update2);

//        repo.getGeoLocation().deleteGeoLocationData("2022-05-29 12:55:17.8589436");
        repo.getGeoLocation().printGeoLocationData();
        repo.getGeoLocation().saveDataToFile();

//        System.out.println());
    }
}
