package WatercraftTelemetrySystem.GeoLocation;

import WatercraftTelemetrySystem.Database.DatabaseConnection;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.ext.Db4oIOException;

import java.io.FileWriter;
import java.io.IOException;
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

	public void deleteGeoLocationData(GeoLocationEntity data) {
		try {
			ObjectContainer conn = new DatabaseConnection().getDatabase();;
			ObjectSet dataObject = conn.queryByExample(data);
			if(dataObject != null) {
				GeoLocationEntity itemToDelete = (GeoLocationEntity) dataObject.next();
				conn.delete(itemToDelete);
			}
			conn.close();

		} catch (Db4oIOException e) {
			throw new RuntimeException(e);
		}
	}

	public void deleteGeoLocationData(String timestamp) {
		try {
			ObjectContainer conn = new DatabaseConnection().getDatabase();

			GeoLocationEntity item = new GeoLocationEntity();
			item.setTimestamp(timestamp);

			ObjectSet dataObject = conn.queryByExample(item);
			if(dataObject != null) {
				GeoLocationEntity itemToDelete = (GeoLocationEntity) dataObject.next();
				conn.delete(itemToDelete);
			}
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

	public GeoLocationEntity getGeoLocation(GeoLocationEntity data) {

		GeoLocationEntity geoLocationData;

		try {
			ObjectContainer conn = new DatabaseConnection().getDatabase();
			ObjectSet dataObject = conn.queryByExample(data);
			geoLocationData = (GeoLocationEntity) dataObject.next();
			conn.close();

		} catch (Db4oIOException e) {
			throw new RuntimeException(e);
		}

		return geoLocationData;
	}

	public GeoLocationEntity getGeoLocation(String timestamp) {

		GeoLocationEntity geoLocationData;
		GeoLocationEntity item = new GeoLocationEntity();
		item.setTimestamp(timestamp);

		try {
			ObjectContainer conn = new DatabaseConnection().getDatabase();
			ObjectSet dataObject = conn.queryByExample(item);
			geoLocationData = (GeoLocationEntity) dataObject.next();
			conn.close();

		} catch (Db4oIOException e) {
			throw new RuntimeException(e);
		}

		return geoLocationData;
	}

	public void updateGeoLocation(GeoLocationEntity data, GeoLocationEntity newData) {

		try {
			ObjectContainer conn = new DatabaseConnection().getDatabase();
			ObjectSet dataObject = conn.queryByExample(data);

			 if (dataObject != null) {
				 GeoLocationEntity geoLocationData = (GeoLocationEntity) dataObject.next();
				 geoLocationData.copyFrom(newData);
				 conn.store(geoLocationData);
			 }

			conn.close();

		} catch (Db4oIOException e) {
			throw new RuntimeException(e);
		}
	}

	public void saveDataToFile() throws IOException {
		FileWriter writer = new FileWriter("GeoLocationRepository.csv");
		List<GeoLocationEntity> geoLocations = getAllGeoLocation();

		String headers = "TIMESTAMP,GEOLOCATION\n";
		writer.write(headers);

		for (GeoLocationEntity geoLocation : geoLocations) {
			String row = String.format("%s,%s\n", geoLocation.getTimestamp(), geoLocation.getGeolocation());
			writer.write(row);
		}

		writer.close();
	}

	public void printGeoLocationData() {
		List<GeoLocationEntity> geoLocations = getAllGeoLocation();
		System.out.printf("\n\n%s entries found\n", geoLocations.size());

		System.out.printf("%20s         |  %25s\n", "TIMESTAMP", "GEOLOCATION");
		System.out.println("---------------------------------------------------------------------------------------------");

		for (GeoLocationEntity geoLocation : geoLocations) {
			System.out.format("%10s  |  %15s\n", geoLocation.getTimestamp(), geoLocation.getGeolocation());
		}
	}

}
