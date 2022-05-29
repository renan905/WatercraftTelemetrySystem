package WatercraftTelemetrySystem.GeoLocation;

import WatercraftTelemetrySystem.Database.DatabaseConnection;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.ext.Db4oIOException;

import java.util.ArrayList;
import java.util.List;

public class GeoLocationRepository {
	public void insertGeoLocationData(GeoLocationEntity data) {
		try {
			ObjectContainer conn = new DatabaseConnection().getDatabase();;
			conn.store(data);
			conn.close();

		} catch (Db4oIOException e) {
			throw new RuntimeException(e);
		}
	}

	public List<GeoLocationEntity> getAllGeoLocation() {
		List<GeoLocationEntity> geoLocations = new ArrayList<>();

		try {
			ObjectContainer conn = new DatabaseConnection().getDatabase();;
			ObjectSet geoLocationData = conn.queryByExample(GeoLocationEntity.class);

			for(Object geoLocation : geoLocationData) {
				geoLocations.add((GeoLocationEntity) geoLocation);
			}

			conn.close();

		} catch (Db4oIOException e) {
			throw new RuntimeException(e);
		}

		return geoLocations;
	}
}
