package WatercraftTelemetrySystem.Database;

import WatercraftTelemetrySystem.GeoLocation.GeoLocationRepository;
import WatercraftTelemetrySystem.WatercraftMetadata.WatercraftMetadataRepository;
import WatercraftTelemetrySystem.WatercraftStatus.WatercraftStatusRepository;

public class RepositoryController {
	GeoLocationRepository geoLocation = new GeoLocationRepository();
	WatercraftMetadataRepository watercraftMetadata = new WatercraftMetadataRepository();
	WatercraftStatusRepository watercraftStatus = new WatercraftStatusRepository();

	public GeoLocationRepository getGeoLocation() {
		return geoLocation;
	}

	public WatercraftMetadataRepository getWatercraftMetadata() {
		return watercraftMetadata;
	}

	public WatercraftStatusRepository getWatercraftStatus() {
		return watercraftStatus;
	}
}
