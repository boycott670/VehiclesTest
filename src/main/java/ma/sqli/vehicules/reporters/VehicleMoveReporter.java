package ma.sqli.vehicules.reporters;

import ma.sqli.vehicules.entities.Vehicle;
import ma.sqli.vehicules.parsers.VehicleMoveParser;

public interface VehicleMoveReporter
{
	void setVehicleMoveParser(final VehicleMoveParser vehicleMoveParser);
	
	void setCarDoorsNotClosedReporter(final CarDoorsNotClosedReporter carDoorsNotClosedReporter);
	
	String reportVehicleMove(final String vehicleId, final Vehicle vehicle, final String closedDoors, final String distance);
}
