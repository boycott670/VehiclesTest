package ma.sqli.vehicules.entities;

public final class Vehicle
{
	private final FuelType fuelType;
	private final int numberOfDoors;
	
	public Vehicle(FuelType fuelType, int numberOfDoors)
	{
		this.fuelType = fuelType;
		this.numberOfDoors = numberOfDoors;
	}

	public FuelType getFuelType()
	{
		return fuelType;
	}

	public int getNumberOfDoors()
	{
		return numberOfDoors;
	}
}
