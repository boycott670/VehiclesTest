package ma.sqli.vehicules.parsers;

import java.util.Set;

public interface VehicleMoveParser
{
	Set<Integer> parseClosedDoors(final String closedDoors);
	
	double parseDistance(final String distance);
}
