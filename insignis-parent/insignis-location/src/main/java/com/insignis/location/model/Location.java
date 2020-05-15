package com.insignis.location.model;

import java.util.HashSet;
import java.util.Set;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

@NodeEntity
public class Location {

	@Id
	@GeneratedValue
	private Long id;

	private String name;
	private Integer x;
	private Integer y;
	private CategoryEnum category;

	@Relationship(type = "NEXT_TO", direction = Relationship.UNDIRECTED)
	private Set<Link> links = new HashSet<Link>();

	public Location() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getX() {
		return x;
	}

	public void setX(Integer x) {
		this.x = x;
	}

	public Integer getY() {
		return y;
	}

	public void setY(Integer y) {
		this.y = y;
	}

	public CategoryEnum getCategory() {
		return category;
	}

	public void setCategory(CategoryEnum category) {
		this.category = category;
	}

	public Set<Link> getLinks() {
		return links;
	}

	public void setLinks(Set<Link> links) {
		this.links = links;
	}

	@Override
	public String toString() {
		return "Location [id=" + id + ", name=" + name + ", x=" + x + ", y=" + y + ", category=" + category + ", links=" + links + "]";
	}

}
