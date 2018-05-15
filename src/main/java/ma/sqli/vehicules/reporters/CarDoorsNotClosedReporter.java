package ma.sqli.vehicules.reporters;

import java.util.Set;

import ma.sqli.vehicules.entities.Vehicle;

public interface CarDoorsNotClosedReporter
{
	String report(final Vehicle vehicle, final Set<Integer> closedDoors);
}
