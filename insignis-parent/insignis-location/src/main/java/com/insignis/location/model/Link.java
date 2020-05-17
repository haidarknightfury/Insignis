package com.insignis.location.model;

import java.io.Serializable;

import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;

import com.fasterxml.jackson.annotation.JsonIgnore;

@RelationshipEntity(type = "NEXT_TO")
public class Link implements Serializable {

	private static final long serialVersionUID = 5609951782220954004L;

	@Id
	@GeneratedValue
	private Long id;

	@JsonIgnore
	@StartNode
	private Location start;

	@JsonIgnore
	@EndNode
	private Location end;

	private Long distance;

	public Link() {
	}

	public Location getStart() {
		return start;
	}

	public void setStart(Location start) {
		this.start = start;
	}

	public Location getEnd() {
		return end;
	}

	public void setEnd(Location end) {
		this.end = end;
	}

	public Long getDistance() {
		return distance;
	}

	public void setDistance(Long distance) {
		this.distance = distance;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Link [id=" + id + ", distance=" + distance + "]";
	}

}
