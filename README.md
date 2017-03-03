# MSD

Generalized Service To Check If Dependent Servers are working fine.


MSD Module
1) It's build using spring boot.http://docs.spring.io/spring-boot/docs/1.5.1.RELEASE/reference/htmlsingle/

Steps to bring up the service:
1) Clone the Project.
2) cd MSD.
3) Run mvn package && java -jar target/msd-0.0.1-SNAPSHOT.jar
4) Should be able to access the service by calling  http://localhost:8080/.
5) The above request will call the HelloController. Which is the initial point.
