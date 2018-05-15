package ma.sqli.vehicules.parsers;

import java.util.Map;

import ma.sqli.vehicules.entities.Vehicle;

public interface VehiclesParser
{
	Map<String, Vehicle> parseVehicles(final String vehicles);
}
