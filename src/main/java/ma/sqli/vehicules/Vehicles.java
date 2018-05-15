package ma.sqli.vehicules;

import java.util.Map;

import ma.sqli.vehicules.entities.Vehicle;
import ma.sqli.vehicules.parsers.DefaultVehicleMoveParser;
import ma.sqli.vehicules.parsers.DefaultVehiclesParser;
import ma.sqli.vehicules.parsers.VehicleMoveParser;
import ma.sqli.vehicules.parsers.VehiclesParser;
import ma.sqli.vehicules.reporters.CarDoorsNotClosedReporter;
import ma.sqli.vehicules.reporters.DefaultCarDoorsNotClosedReporter;
import ma.sqli.vehicules.reporters.DefaultVehicleMoveReporter;
import ma.sqli.vehicules.reporters.VehicleMoveReporter;

public final class Vehicles
{
	private final VehiclesParser parser;
	
	private final VehicleMoveParser moveParser;
	
	private final VehicleMoveReporter moveReporter;
	
	private final CarDoorsNotClosedReporter carDoorsNotClosedReporter;
	
	private final Map<String, Vehicle> vehicles;
	
	public Vehicles(final String vehicles)
	{
		parser = new DefaultVehiclesParser();
		
		moveParser = new DefaultVehicleMoveParser();
		
		moveReporter = new DefaultVehicleMoveReporter();
		
		carDoorsNotClosedReporter = new DefaultCarDoorsNotClosedReporter();
		
		moveReporter.setVehicleMoveParser(moveParser);
		
		moveReporter.setCarDoorsNotClosedReporter(carDoorsNotClosedReporter);
		
		this.vehicles = parser.parseVehicles(vehicles);
	}
	
	public String move(final String vehicle, final String closedDoors, final String distance)
	{
		return moveReporter.reportVehicleMove(vehicle, vehicles.get(vehicle), closedDoors, distance);
	}
}
