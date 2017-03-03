package com.multi.server.dependency;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.java.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

@Configuration
@EnableCassandraRepositories
class ApplicationConfig extends AbstractCassandraConfiguration {

  @Override
  protected String getKeyspaceName() {
    return "msd";
  }

  public String[] getEntityBasePackages() {
    return new String[] { "com.multi.server.dependency.repository" };
  }
}