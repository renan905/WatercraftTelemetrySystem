package WatercraftTelemetrySystem.WatercraftStatus;

import WatercraftTelemetrySystem.WatercraftMetadata.WatercraftMetadataEntity;

import java.util.Objects;

public class WatercraftStatusEntity {
	private String timestamp;
	private Double speed;
	private Double engineTemp;
	private Double fuelLevel;
	private Double waterTankLevel;


	public void copyFrom(WatercraftStatusEntity source) {
		if(!Objects.equals(source.getTimestamp(), getTimestamp())) {
			setTimestamp(source.getTimestamp());
		}

		if(!Objects.equals(source.getSpeed(), getSpeed())) {
			setSpeed(source.getSpeed());
		}

		if(!Objects.equals(source.getEngineTemp(), getEngineTemp())) {
			setEngineTemp(source.getEngineTemp());
		}

		if(!Objects.equals(source.getFuelLevel(), getFuelLevel())) {
			setFuelLevel(source.getFuelLevel());
		}

		if(!Objects.equals(source.getWaterTankLevel(), getWaterTankLevel())) {
			setWaterTankLevel(source.getWaterTankLevel());
		}
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public Double getSpeed() {
		return speed;
	}

	public void setSpeed(Double speed) {
		this.speed = speed;
	}

	public Double getEngineTemp() {
		return engineTemp;
	}

	public void setEngineTemp(Double engineTemp) {
		this.engineTemp = engineTemp;
	}

	public Double getFuelLevel() {
		return fuelLevel;
	}

	public void setFuelLevel(Double fuelLevel) {
		this.fuelLevel = fuelLevel;
	}

	public Double getWaterTankLevel() {
		return waterTankLevel;
	}

	public void setWaterTankLevel(Double waterTankLevel) {
		this.waterTankLevel = waterTankLevel;
	}


}
