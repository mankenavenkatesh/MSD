package com.multi.server.dependency.cassandra;


import java.io.Closeable;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.data.cassandra.core.CassandraTemplate;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;
import com.datastax.driver.core.querybuilder.QueryBuilder;
import com.datastax.driver.core.querybuilder.Select;
import com.multi.server.dependency.domain.MSDEntity;

public class CassandraApplication {

  private static final Logger LOGGER = LoggerFactory.getLogger(CassandraApplication.class);

  protected static MSDEntity newPerson(String name, int age) {
    return newPerson(UUID.randomUUID().toString(), name, age);
  }

  protected static MSDEntity newPerson(String id, String name, int age) {
    return new MSDEntity(id, name, age);
  }

  public static void main(String[] args) {

    Cluster cluster = Cluster.builder().addContactPoints("localhost").build();
    Session session = cluster.connect("msd");

    CassandraOperations template = new CassandraTemplate(session);

    MSDEntity jonDoe = template.insert(newPerson("MSD", 40));

    Select selectStatement = QueryBuilder.select().from("msd");
    selectStatement.where(QueryBuilder.eq("id", jonDoe.getId()));

    LOGGER.info(""+template.queryForObject(selectStatement, MSDEntity.class));

    template.truncate("msd");
    session.close();
    cluster.close();
  }
}