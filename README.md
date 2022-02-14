# Application Structure
````
We have a two parent package there are we and core.
* In web we write a code for controller in which we do not
expose the entity and repository.
* In core layer we write a business logic and database tables and queries.
* We have instroduced a DTO object to send and get data to the web layer. 
````
# Test
````
Here we have used mvc mock test to test the rest controllers.
````
* <a href="src/test/java/com/taskmanagement/web/controller/TaskControllerSpec.java">Task Controller Test</a>
* <a href="src/test/java/com/taskmanagement/web/controller/TaskGroupControllerSpec.java">Task Group Controller Test</a>
* <a href="src/test/java/com/taskmanagement/web/controller/EmployeeControllerSpec.java">Employee Controller Test</a>

# Configuratuin
````
* I have used H2 database config.
* I have craeted a profile for development and production.
* I have created a diffent config file according to the active profile like dev and prod.
````
<a href="src/main/resources/application.properties">Main Config</a>
<a href="src/main/resources/application-develop.properties">Dev Config</a>
<a href="src/main/resources/application-production.properties">Prod Config</a>
# Run
* To run the application enter the ./gradlew bootRun command in terminal
* To run the test goto the test class and run the test cases.