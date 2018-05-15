package ma.sqli.vehicules.parsers;

import java.util.AbstractMap.SimpleImmutableEntry;
import java.util.Arrays;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import ma.sqli.vehicules.entities.FuelType;
import ma.sqli.vehicules.entities.Vehicle;

public final class DefaultVehiclesParser implements VehiclesParser
{

	@Override
	public Map<String, Vehicle> parseVehicles(String vehicles)
	{
		final Map<String, FuelType> fuelTypeMapper = Stream.of(new SimpleImmutableEntry<>("Hybrid", FuelType.HYBRID), new SimpleImmutableEntry<>("Diesel", FuelType.DIESEL), new SimpleImmutableEntry<>("Gasoline", FuelType.GASOLINE)).collect(Collectors.toMap(Entry::getKey, Entry::getValue));
		
		return Arrays.stream(vehicles.split(", ")).map(vehicle -> vehicle.split(":")).collect(Collectors.toMap(vehicleTokens -> vehicleTokens[0], vehicleTokens -> new Vehicle(fuelTypeMapper.get(vehicleTokens[1]), Integer.parseInt(vehicleTokens[2]))));
	}

}
