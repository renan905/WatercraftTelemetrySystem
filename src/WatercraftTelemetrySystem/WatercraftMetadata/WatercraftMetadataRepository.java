package WatercraftTelemetrySystem.WatercraftMetadata;

import WatercraftTelemetrySystem.Database.DatabaseConnection;

import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.ext.Db4oIOException;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WatercraftMetadataRepository {

	public void insertWatercraftMetadata(WatercraftMetadataEntity data) {
		try {
			ObjectContainer conn = new DatabaseConnection().getDatabase();;
			conn.store(data);
			conn.close();

		} catch (Db4oIOException e) {
			throw new RuntimeException(e);
		}
	}

	public void deleteWatercraftMetadata(WatercraftMetadataEntity data) {
		try {
			ObjectContainer conn = new DatabaseConnection().getDatabase();;
			ObjectSet dataObject = conn.queryByExample(data);
			if(dataObject != null) {
				WatercraftMetadataEntity itemToDelete = (WatercraftMetadataEntity) dataObject.next();
				conn.delete(itemToDelete);
			}
			conn.close();

		} catch (Db4oIOException e) {
			throw new RuntimeException(e);
		}
	}

	public List<WatercraftMetadataEntity> getAllWatercraftMetadata() {
		List<WatercraftMetadataEntity> metadata = new ArrayList<>();

		try {
			ObjectContainer conn = new DatabaseConnection().getDatabase();;
			ObjectSet watercraftMetadata = conn.queryByExample(WatercraftMetadataEntity.class);

			for(Object geoLocation : watercraftMetadata) {
				metadata.add((WatercraftMetadataEntity) geoLocation);
			}

			conn.close();

		} catch (Db4oIOException e) {
			throw new RuntimeException(e);
		}

		return metadata;
	}

	public WatercraftMetadataEntity getWatercraftMetadata(WatercraftMetadataEntity data) {

		WatercraftMetadataEntity watercraftMetadata;

		try {
			ObjectContainer conn = new DatabaseConnection().getDatabase();
			ObjectSet dataObject = conn.queryByExample(data);
			watercraftMetadata = (WatercraftMetadataEntity) dataObject.next();
			conn.close();

		} catch (Db4oIOException e) {
			throw new RuntimeException(e);
		}

		return watercraftMetadata;
	}

	public void updateGeoLocation(WatercraftMetadataEntity data, WatercraftMetadataEntity newData) {

		try {
			ObjectContainer conn = new DatabaseConnection().getDatabase();
			ObjectSet dataObject = conn.queryByExample(data);

			if (dataObject != null) {
				WatercraftMetadataEntity watercraftMetadataEntity = (WatercraftMetadataEntity) dataObject.next();
				watercraftMetadataEntity.copyFrom(newData);
				conn.store(watercraftMetadataEntity);
			}

			conn.close();

		} catch (Db4oIOException e) {
			throw new RuntimeException(e);
		}
	}

	public void saveDataToFile() throws IOException {
		FileWriter writer = new FileWriter("WatercraftMetadataRepository.csv");
		List<WatercraftMetadataEntity> WatercraftMetadata = getAllWatercraftMetadata();

		String headers = "NAME,TYPE,ACCELERATION,CAPACITY,FUELTANKCAPACITY,WATERTANKCAPACITY,LAUNCHYEAR,MAXSPEED,MAXWEIGHT,PROPULSION\n";
		writer.write(headers);

		for (WatercraftMetadataEntity watercraft : WatercraftMetadata) {
			String row = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s\n", watercraft.getName(), watercraft.getType(), watercraft.getAcceleration(), watercraft.getCapacity(), watercraft.getFuelTankCapacity(), watercraft.getWaterTankCapacity(),watercraft.getLaunchYear(), watercraft.getMaxSpeed(), watercraft.getMaxWeight(), watercraft.getPropulsion());
			writer.write(row);
		}

		writer.close();
	}

	public void printWatercraftMetada() {
		List<WatercraftMetadataEntity> watercraftMetadata = getAllWatercraftMetadata();

		for (WatercraftMetadataEntity metadata : watercraftMetadata) {
			System.out.format("%10s\n", metadata.getName());
		}
	}

}
