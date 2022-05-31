package WatercraftTelemetrySystem;

import WatercraftTelemetrySystem.Database.RepositoryController;
import WatercraftTelemetrySystem.GeoLocation.GeoLocationEntity;
import WatercraftTelemetrySystem.Helpers.Helpers;
import WatercraftTelemetrySystem.Helpers.Vector2;
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

        repo.getGeoLocation().deleteGeoLocationData(ts);

		repo.getGeoLocation().printGeoLocationData();
		repo.getGeoLocation().saveDataToFile();

		watercraftMetadata.setName("Sereia do Mar");
		watercraftMetadata.setAcceleration(10.3);
		watercraftMetadata.setMaxSpeed(96.0);
		watercraftMetadata.setWaterTankCapacity(10000.0);
		watercraftMetadata.setCapacity(15);
		watercraftMetadata.setPropulsion("Motor");
		watercraftMetadata.setType("Private");
		watercraftMetadata.setLaunchYear("2022");
		watercraftMetadata.setDimensions(new Vector2("15.2", "23.4"));
		watercraftMetadata.setMaxWeight(18000.1);
		watercraftMetadata.setFuelTankCapacity(1000.2);

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