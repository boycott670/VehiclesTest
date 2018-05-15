package ma.sqli.vehicules.reporters;

import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import ma.sqli.vehicules.entities.Vehicle;

public final class DefaultCarDoorsNotClosedReporter implements CarDoorsNotClosedReporter
{

	@Override
	public String report(Vehicle vehicle, Set<Integer> closedDoors)
	{
		final Function<Integer, Character> doorReporter = doorPosition -> closedDoors.contains(doorPosition) ? '|' : ((doorPosition - 1) % 2 == 0 ? '/' : '\\');
		
		final String partialCarReport = IntStream.range(0, vehicle.getNumberOfDoors() / 2 - 1).mapToObj(doorPositionFactor -> String.format(" %c %c", doorReporter.apply(2 * doorPositionFactor + 1), doorReporter.apply(2 * doorPositionFactor + 2))).collect(Collectors.joining("\n"));
		
		return String.format("DOORS KO, BLOCKED \n  _\n%s\n %s", partialCarReport, String.format("%c_%c", doorReporter.apply(vehicle.getNumberOfDoors() / 2 + 1), doorReporter.apply(vehicle.getNumberOfDoors() / 2 + 2)));
	}

}
