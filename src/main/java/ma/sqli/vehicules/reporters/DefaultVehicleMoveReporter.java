package ma.sqli.vehicules.reporters;

import java.util.Locale;
import java.util.Set;

import ma.sqli.vehicules.entities.Vehicle;
import ma.sqli.vehicules.parsers.VehicleMoveParser;

public final class DefaultVehicleMoveReporter implements VehicleMoveReporter
{

	private VehicleMoveParser vehicleMoveParser;
	
	private CarDoorsNotClosedReporter carDoorsNotClosedReporter;
	
	@Override
	public void setVehicleMoveParser(VehicleMoveParser vehicleMoveParser)
	{
		this.vehicleMoveParser = vehicleMoveParser;
	}

	@Override
	public void setCarDoorsNotClosedReporter(CarDoorsNotClosedReporter carDoorsNotClosedReporter)
	{
		this.carDoorsNotClosedReporter = carDoorsNotClosedReporter;
	}

	@Override
	public String reportVehicleMove(String vehicleId, Vehicle vehicle, String closedDoors, String distance)
	{
		final Set<Integer> parsedClosedDoors = vehicleMoveParser.parseClosedDoors(closedDoors);
		
		if (vehicle.getNumberOfDoors() != parsedClosedDoors.size())
		{
			return carDoorsNotClosedReporter.report(vehicle, parsedClosedDoors);
		}
		
		return String.format("DOORS OK, MOVING. The %s will consume %s L", vehicleId, String.format(Locale.US, "%.2f", vehicle.getFuelType().getConsumptionRate() * vehicleMoveParser.parseDistance(distance)));
	}

}
