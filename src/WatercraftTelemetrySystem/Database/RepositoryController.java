package WatercraftTelemetrySystem.Database;

import WatercraftTelemetrySystem.GeoLocation.GeoLocationRepository;

public class RepositoryController {
	GeoLocationRepository geoLocation = new GeoLocationRepository();

	public GeoLocationRepository getGeoLocation() {
		return geoLocation;
	}
}
