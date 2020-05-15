package com.insignis.location.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.insignis.location.model.CategoryEnum;
import com.insignis.location.model.Link;
import com.insignis.location.model.Location;
import com.insignis.location.repository.LocationRepository;

@Component
public class LocationCommandLineRunner implements CommandLineRunner {

	@Autowired
	private LocationRepository locationRepository;

	private static final Integer LIMIT_COL = 10;
	private static final Integer LIMIT_ROW = 5;
	private static final char START = "A".charAt(0);

	@Override
	public void run(String... args) throws Exception {
		// List<Location> locations = (List<Location>) locationRepository.findAll();
		// System.out.println(locations);
		locationRepository.deleteAll();
		createNeo4jLocations();
	}

	public void createNeo4jLocations() {
		List<Location> locations = createLocations();
		System.out.println(locations);
		for (int i = 1; i <= LIMIT_ROW; i++) {
			addRowLink(i, locations);
		}
		System.out.println(locations);
		addEndLinks(locations);
		locationRepository.saveAll(locations);
	}

	public void addEndLinks(List<Location> locations) {
		for (int i = 2; i <= LIMIT_ROW; i++) {
			Location prevRowSt = getItem(i - 1, 1, locations);
			Location currRowSt = getItem(i, 1, locations);
			addLink(prevRowSt, currRowSt);

			Location prevRowEnd = getItem(i - 1, LIMIT_COL, locations);
			Location currRowEnd = getItem(i, LIMIT_COL, locations);
			addLink(prevRowEnd, currRowEnd);
		}
	}

	public Location getItem(Integer x, Integer y, List<Location> locations) {
		return locations.stream().filter(loc -> loc.getX() == x && loc.getY() == y).findFirst().get();
	}

	public void addRowLink(Integer rowNumber, List<Location> locations) {
		System.out.println("processing row " + rowNumber);
		List<Location> row = locations.stream().filter(loc -> loc.getX() == rowNumber).collect(Collectors.toList());
		for (int i = 1; i < row.size(); i++) {
			Location prev = row.get(i - 1);
			Location curr = row.get(i);
			System.out.println("adding link for " + prev + "," + curr);
			addLink(prev, curr);
		}
		System.out.println(row);
	}

	public void addLink(Location location1, Location location2) {
		Link link = createLink(1L, location1, location2);
		location1.getLinks().add(link);

		Link link2 = createLink(1L, location2, location1);
		location2.getLinks().add(link2);
	}

	public List<Location> createLocations() {
		List<Location> allLocations = new ArrayList<Location>();
		String currentRow = String.valueOf(START);
		for (int row = 1; row <= LIMIT_ROW; row++) {
			for (int col = 1; col <= LIMIT_COL; col++) {
				String name = currentRow + col;
				Location currentLocation = createLocation(name, row, col, CategoryEnum.NOT_DEFINED);
				allLocations.add(currentLocation);
			}
			currentRow = String.valueOf((char) (START + row));
		}
		return allLocations;
	}

	public Link createLink(Long distance, Location start, Location end) {
		Link link = new Link();
		link.setDistance(1L);
		link.setStart(start);
		link.setEnd(end);
		return link;
	}

	public Location createLocation(String name, Integer x, Integer y, CategoryEnum category) {
		Location location = new Location();
		location.setName(name);
		location.setX(x);
		location.setY(y);
		location.setCategory(category);
		return location;
	}

}
