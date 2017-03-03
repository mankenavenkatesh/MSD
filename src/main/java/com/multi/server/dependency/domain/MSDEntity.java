package com.multi.server.dependency.domain;

import java.util.UUID;

import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;

@Table(value="msd")
public class MSDEntity {

  @PrimaryKey("id")
  private final String id;

  private final String name;
  private final int description;

  public MSDEntity(String id, String name, int description) {
    this.id = id;
    this.name = name;
    this.description = description;
  }


  public String getId() {
	return id;
}


public String getName() {
	return name;
}


public int getDescription() {
	return description;
}


@Override
  public String toString() {
    return String.format("{ @type = %1$s, id = %2$s, name = %3$s, description = %4$d }",
      getClass().getName(), getId(), getName(), getDescription());
  }
}