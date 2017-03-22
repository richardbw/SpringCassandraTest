
Simple Springboot/Cassandra Test app
====================================

Startup
-------


1. Create schema:
Run script in 
> ./src/main/cassandra/cql/Niha.cql

2. Build & run:
>  mvn package -DskipTests=true 

3. Start up:
>  java -jar target/SpringCassandraTest-0.0.1-SNAPSHOT.jar


Test Shell scripts
------------------

* Get all:
> ./getAll.sh

* Create  (Edit script 1st):
> ./createNewEmp.sh

* Retrieve one employee
> ./getOne.sh

* Delete an employee:
> ./delOne.sh (id) 



