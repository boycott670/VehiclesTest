package ma.sqli.vehicules.parsers;

import java.util.Arrays;
import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;

public final class DefaultVehicleMoveParser implements VehicleMoveParser
{

	@Override
	public Set<Integer> parseClosedDoors(String closedDoors)
	{
		return closedDoors.isEmpty() ? Collections.emptySet() : Arrays.stream(closedDoors.split(" ")).map(Integer::valueOf).collect(Collectors.toSet());
	}

	@Override
	public double parseDistance(String distance)
	{
		return Double.parseDouble(distance.substring(0, distance.indexOf(' ')));
	}

}
