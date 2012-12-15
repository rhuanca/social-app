Pre-Requisites
--------------

- Java 6+
- Maven 3+
- Ant 1.8+
- mysql 5.5+

To work with IDEs
---------------------------------

- to create idea project:
	ant idea

- to create eclipse project:
	ant eclipse
	
To work with database
---------------------

- to create initial database:
	ant createdb		

How to run the application with ant
-------------------------------------

- To clean
	ant clean
- To compile and create war
	ant make
- To run the app
	ant run
- Or all together
	ant clean make run


other tasks using maven
-------------------------------------
- to create idea project:
	mvn idea:idea
- to create eclipse project:
	mvn eclipse:eclipse
- To clean
	mvn clean
- To compile and create war
	mvn clean package
- To run the app
	mvn jetty:run
- Or
	mvn clean package jetty:run