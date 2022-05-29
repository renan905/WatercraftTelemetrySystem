package WatercraftTelemetrySystem.WatercraftMetadata;

import WatercraftTelemetrySystem.GeoLocation.GeoLocationEntity;
import WatercraftTelemetrySystem.Helpers.Vector2;

import java.sql.Date;
import java.util.Objects;

public class WatercraftMetadataEntity {
	private String type;
	private Vector2<String> dimensions;
	private String propulsion;
	private String name;
	private String launchYear;
	private Integer capacity;
	private Double maxWeight;
	private Double maxSpeed;
	private Double acceleration;
	private Double waterTankCapacity;
	private Double fuelTankCapacity;

	public void copyFrom(WatercraftMetadataEntity source) {

		if(!Objects.equals(source.getType(), getType())) {
			setType(source.getType());
		}

		if(!Objects.equals(source.getDimensions().y, getDimensions().y) || !Objects.equals(source.getDimensions().x, getDimensions().x)) {
			setDimensions(source.getDimensions());
		}

		if(!Objects.equals(source.getPropulsion(), getPropulsion())) {
			setPropulsion(source.getPropulsion());
		}

		if(!Objects.equals(source.getName(), getName())) {
			setName(source.getName());
		}

		if(!Objects.equals(source.getLaunchYear(), getLaunchYear())) {
			setLaunchYear(source.getLaunchYear());
		}

		if(!Objects.equals(source.getCapacity(), getCapacity())) {
			setCapacity(source.getCapacity());
		}

		if(!Objects.equals(source.getMaxWeight(), getMaxWeight())) {
			setMaxWeight(source.getMaxWeight());
		}

		if(!Objects.equals(source.getMaxSpeed(), getMaxSpeed())) {
			setMaxSpeed(source.getMaxSpeed());
		}

		if(!Objects.equals(source.getAcceleration(), getAcceleration())) {
			setAcceleration(source.getAcceleration());
		}

		if(!Objects.equals(source.getFuelTankCapacity(), getFuelTankCapacity())) {
			setFuelTankCapacity(source.getFuelTankCapacity());
		}

		if(!Objects.equals(source.getWaterTankCapacity(), getWaterTankCapacity())) {
			setWaterTankCapacity(source.getWaterTankCapacity());
		}
	}

	public Double getFuelTankCapacity() {
		return fuelTankCapacity;
	}

	public void setFuelTankCapacity(Double fuelTankCapacity) {
		this.fuelTankCapacity = fuelTankCapacity;
	}

	public Double getWaterTankCapacity() {
		return waterTankCapacity;
	}

	public void setWaterTankCapacity(Double waterTankCapacity) {
		this.waterTankCapacity = waterTankCapacity;
	}
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Vector2<String> getDimensions() {
		return dimensions;
	}

	public void setDimensions(Vector2<String> dimensions) {
		this.dimensions = dimensions;
	}

	public String getPropulsion() {
		return propulsion;
	}

	public void setPropulsion(String propulsion) {
		this.propulsion = propulsion;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLaunchYear() {
		return launchYear;
	}

	public void setLaunchYear(String launchYear) {
		this.launchYear = launchYear;
	}

	public Integer getCapacity() {
		return capacity;
	}

	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}

	public Double getMaxWeight() {
		return maxWeight;
	}

	public void setMaxWeight(Double maxWeight) {
		this.maxWeight = maxWeight;
	}

	public Double getMaxSpeed() {
		return maxSpeed;
	}

	public void setMaxSpeed(Double maxSpeed) {
		this.maxSpeed = maxSpeed;
	}

	public Double getAcceleration() {
		return acceleration;
	}

	public void setAcceleration(Double acceleration) {
		this.acceleration = acceleration;
	}

}



