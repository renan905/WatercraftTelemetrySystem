package WatercraftTelemetrySystem;

import WatercraftTelemetrySystem.Database.RepositoryController;
import WatercraftTelemetrySystem.GeoLocation.GeoLocationEntity;
import WatercraftTelemetrySystem.Helpers.Helpers;
import WatercraftTelemetrySystem.WatercraftMetadata.WatercraftMetadataEntity;
import WatercraftTelemetrySystem.WatercraftStatus.WatercraftStatusEntity;

import java.io.IOException;

public class WatercraftTelemetrySystem {

	public static void main (String[] args) throws IOException {

		RepositoryController repo = new RepositoryController();
		GeoLocationEntity geoData = new GeoLocationEntity();
		WatercraftMetadataEntity watercraftMetadata = new WatercraftMetadataEntity();
		WatercraftStatusEntity watercraftStatus = new WatercraftStatusEntity();

		String ts = Helpers.getStringTimestamp();
		geoData.setTimestamp(ts);
		geoData.setGeolocation("-20.75902915348214 -42.871074831110946");

		repo.getGeoLocation().insertGeoLocationData(geoData);
		repo.getGeoLocation().printGeoLocationData();

		GeoLocationEntity update = repo.getGeoLocation().getGeoLocation(ts);
		GeoLocationEntity update2 = repo.getGeoLocation().getGeoLocation(ts);

		update2.setGeolocation("1000 2000");
		repo.getGeoLocation().updateGeoLocation(update, update2);

//        repo.getGeoLocation().deleteGeoLocationData("2022-05-29 12:55:17.8589436");
		repo.getGeoLocation().printGeoLocationData();
		repo.getGeoLocation().saveDataToFile();

		watercraftMetadata.setName("Sereia do Mar");
		repo.getWatercraftMetadata().insertWatercraftMetadata(watercraftMetadata);
		repo.getWatercraftMetadata().saveDataToFile();

		watercraftStatus.setTimestamp(ts);
		watercraftStatus.setSpeed(10.241);
		watercraftStatus.setWaterTankLevel(90.0);
		watercraftStatus.setFuelLevel(56.2);
		watercraftStatus.setEngineTemp(78.1);

		repo.getWatercraftStatus().insertWatercraftStatusData(watercraftStatus);
		repo.getWatercraftStatus().saveDataToFile();
	}
}