# Sample Project of Spring Boot 

1, It can be run by this command

mvn -U clean install

mvn package -Dmaven.test.skip

mvn spring-boot:run

2, and also can be run by the next commands.

mvn -U clean install

mvn package -Dmaven.test.skip

java -jar ./target/bc-1.0.0-SNAPSHOT.jar

3, package to war file

mvn compile war:war
