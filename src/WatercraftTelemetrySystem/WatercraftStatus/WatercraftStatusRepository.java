package WatercraftTelemetrySystem.WatercraftStatus;

import WatercraftTelemetrySystem.Database.DatabaseConnection;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.ext.Db4oIOException;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WatercraftStatusRepository {

	public void insertWatercraftStatusData(WatercraftStatusEntity data) {
		try {
			ObjectContainer conn = new DatabaseConnection().getDatabase();;
			conn.store(data);
			conn.close();

		} catch (Db4oIOException e) {
			throw new RuntimeException(e);
		}
	}

	public void deleteWatercraftStatusData(WatercraftStatusEntity data) {
		try {
			ObjectContainer conn = new DatabaseConnection().getDatabase();;
			ObjectSet dataObject = conn.queryByExample(data);
			if(dataObject != null) {
				WatercraftStatusEntity itemToDelete = (WatercraftStatusEntity) dataObject.next();
				conn.delete(itemToDelete);
			}
			conn.close();

		} catch (Db4oIOException e) {
			throw new RuntimeException(e);
		}
	}

	public void deleteWatercraftStatusData(String timestamp) {
		try {
			ObjectContainer conn = new DatabaseConnection().getDatabase();

			WatercraftStatusEntity item = new WatercraftStatusEntity();
			item.setTimestamp(timestamp);

			ObjectSet dataObject = conn.queryByExample(item);
			if(dataObject != null) {
				WatercraftStatusEntity itemToDelete = (WatercraftStatusEntity) dataObject.next();
				conn.delete(itemToDelete);
			}
			conn.close();

		} catch (Db4oIOException e) {
			throw new RuntimeException(e);
		}
	}

	public List<WatercraftStatusEntity> getAllWatercraftStatus() {
		List<WatercraftStatusEntity> watercraftStatus = new ArrayList<>();

		try {
			ObjectContainer conn = new DatabaseConnection().getDatabase();;
			ObjectSet watercraftStatusData = conn.queryByExample(WatercraftStatusEntity.class);

			for(Object geoLocation : watercraftStatusData) {
				watercraftStatus.add((WatercraftStatusEntity) geoLocation);
			}

			conn.close();

		} catch (Db4oIOException e) {
			throw new RuntimeException(e);
		}

		return watercraftStatus;
	}

	public WatercraftStatusEntity getWatercraftStatus(WatercraftStatusEntity data) {

		WatercraftStatusEntity watercraftStatusData;

		try {
			ObjectContainer conn = new DatabaseConnection().getDatabase();
			ObjectSet dataObject = conn.queryByExample(data);
			watercraftStatusData = (WatercraftStatusEntity) dataObject.next();
			conn.close();

		} catch (Db4oIOException e) {
			throw new RuntimeException(e);
		}

		return watercraftStatusData;
	}

	public WatercraftStatusEntity getWatercraftStatus(String timestamp) {

		WatercraftStatusEntity watercraftStatusData;
		WatercraftStatusEntity item = new WatercraftStatusEntity();
		item.setTimestamp(timestamp);

		try {
			ObjectContainer conn = new DatabaseConnection().getDatabase();
			ObjectSet dataObject = conn.queryByExample(item);
			watercraftStatusData = (WatercraftStatusEntity) dataObject.next();
			conn.close();

		} catch (Db4oIOException e) {
			throw new RuntimeException(e);
		}

		return watercraftStatusData;
	}

	public void updateWatercraftStatus(WatercraftStatusEntity data, WatercraftStatusEntity newData) {

		try {
			ObjectContainer conn = new DatabaseConnection().getDatabase();
			ObjectSet dataObject = conn.queryByExample(data);

			if (dataObject != null) {
				WatercraftStatusEntity watercraftStatusData = (WatercraftStatusEntity) dataObject.next();
				watercraftStatusData.copyFrom(newData);
				conn.store(watercraftStatusData);
			}

			conn.close();

		} catch (Db4oIOException e) {
			throw new RuntimeException(e);
		}
	}

	public void saveDataToFile() throws IOException {
		FileWriter writer = new FileWriter("WatercraftStatusRepository.csv");
		List<WatercraftStatusEntity> watercraftStatusData = getAllWatercraftStatus();

		String headers = "TIMESTAMP,SPEED,ENGINETEMP,FUELLEVEL,WATERTANKLEVEL\n";
		writer.write(headers);

		for (WatercraftStatusEntity watercraftStatus : watercraftStatusData) {
			String row = String.format("%s,%s,%s,%s,%s\n", watercraftStatus.getTimestamp(), watercraftStatus.getSpeed(),watercraftStatus.getEngineTemp(), watercraftStatus.getFuelLevel(), watercraftStatus.getWaterTankLevel());
			writer.write(row);
		}

		writer.close();
	}

	public void printGeoLocationData() {
		List<WatercraftStatusEntity> watercraftStatusData = getAllWatercraftStatus();
		System.out.printf("\n\n%s entries found\n", watercraftStatusData.size());

		System.out.printf("%20s         |  %25s\n", "TIMESTAMP", "SPEED");
		System.out.println("---------------------------------------------------------------------------------------------");

		for (WatercraftStatusEntity watercraftStatus : watercraftStatusData) {
			System.out.format("%10s  |  %15s\n", watercraftStatus.getTimestamp(), watercraftStatus.getSpeed());
		}
	}

}
