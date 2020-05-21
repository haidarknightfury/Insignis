package com.insignis.location.repository;

import java.util.HashMap;
import java.util.List;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

import com.insignis.location.model.Location;

public interface LocationRepository extends Neo4jRepository<Location, Long> {

	List<Location> findByName(String name);

	@Query("MATCH (start:Location {name: $start}), (end:Location {name: $end})\r\n" + "CALL gds.alpha.shortestPath.stream({\r\n" + "  nodeProjection: 'Location',\r\n"
			+ "  relationshipProjection: {\r\n" + "    NEXT_TO: {\r\n" + "      type: 'NEXT_TO',\r\n" + "      properties: 'distance',\r\n" + "      orientation: 'UNDIRECTED'\r\n" + "    }\r\n"
			+ "  },\r\n" + "  startNode: start,\r\n" + "  endNode: end,\r\n" + "  relationshipWeightProperty: 'distance'\r\n" + "})\r\n" + "YIELD nodeId, cost\r\n"
			+ "RETURN gds.util.asNode(nodeId).name AS name, cost\r\n" + "")
	List<HashMap<String, Long>> findShortestPath(@Param("start") String start, @Param("end") String end);

	@Query("MATCH (start:Location {name: $start}), (end:Location {name: $end})\r\n" + "CALL gds.alpha.shortestPath.write({\r\n" + "  nodeProjection: 'Location',\r\n"
			+ "  relationshipProjection: {\r\n" + "    NEXT_TO: {\r\n" + "      type: 'NEXT_TO',\r\n" + "      properties: 'distance',\r\n" + "      orientation: 'UNDIRECTED'\r\n" + "    }\r\n"
			+ "  },\r\n" + "  startNode: start,\r\n" + "  endNode: end,\r\n" + "  relationshipWeightProperty: 'distance',\r\n" + "  writeProperty: 'sssp'\r\n" + "})\r\n"
			+ "YIELD nodeCount, totalCost\r\n" + "RETURN nodeCount,totalCost")
	List<HashMap<Long, Long>> findNodeCount(@Param("start") String start, @Param("end") String end);

	@Query("MATCH (start:Location {name: 'A1'}), (end:Location {name: 'B5'})\r\n" + "CALL gds.alpha.shortestPath.stream({\r\n" + "  nodeProjection: 'Location',\r\n" + "  relationshipProjection: {\r\n"
			+ "    NEXT_TO: {\r\n" + "      type: 'NEXT_TO',\r\n" + "      properties: 'distance',\r\n" + "      orientation: 'UNDIRECTED'\r\n" + "    }\r\n" + "  },\r\n" + "  startNode: start,\r\n"
			+ "  endNode: end,\r\n" + "  relationshipWeightProperty: 'distance'\r\n" + "})\r\n" + "YIELD nodeId\r\n" + "RETURN gds.util.asNode(nodeId)")
	List<Location> findShortestPathLocations(@Param("start") String start, @Param("end") String end);

}
