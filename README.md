# MSD

Generalized Service To Check If Dependent Servers are working fine.


MSD Module
1) It's build using spring boot.http://docs.spring.io/spring-boot/docs/1.5.1.RELEASE/reference/htmlsingle/

Steps to bring up the service:
1) Clone the Project.
2) cd MSD.
3) Run mvn spring-boot:run (or mvn package && java -jar target/msd-0.0.1-SNAPSHOT.jar)
4) Should be able to access the service by calling  http://localhost:8080/.
5) The above request will call the PersonController. Which is the initial point.


Database Integration
1) install and start cassandra on localhost - https://www.datastax.com/2012/01/working-with-apache-cassandra-on-mac-os-x
2) Connecting to cassandra using spring data cassandra http://docs.spring.io/spring-data/cassandra/docs/1.5.1.RELEASE/reference/html/#cassandra.core

Casssandra Data Models
1) check msd.cql file.


Code Coverage
1) Added Cobertura code coverage. http://www.mkyong.com/qa/maven-cobertura-code-coverage-example/
2) Run mvn cobertura:cobertura
3) open target/site/cobertura/index.html
