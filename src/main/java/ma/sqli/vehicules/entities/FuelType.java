package ma.sqli.vehicules.entities;

public enum FuelType
{
	DIESEL(.05),
	GASOLINE(.06),
	HYBRID(.03);
	
	private final double consumptionRate;

	private FuelType(double consumptionRate)
	{
		this.consumptionRate = consumptionRate;
	}

	public double getConsumptionRate()
	{
		return consumptionRate;
	}
}
