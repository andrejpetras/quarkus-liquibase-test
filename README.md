# quarkus-liquibase-test
Quarkus liquibase test project

## Dev test
```shell script
docker-compose up liquibase-db
mvn clean quarkus:dev
```
## Native test
```shell script
mvn clean package -Pnative
./target/quarkus-liquibase-test-0.1.0-SNAPSHOT-runner
```

## Native docker test
```shell script
mvn clean package -Pnative
samo maven docker-build
docker-compose up quarkus-liquibase-test
```

Build docker image manual
```shell script
docker build -t quarkus-liquibase-test -f src/main/Dockerfile .
```