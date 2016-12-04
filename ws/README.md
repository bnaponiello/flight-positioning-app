# Flight Positioning App (Webservice)

This is the webservice of the application "Flight Positioning App" (flight-positioning-app), an application that gives accurate informations about flights around the globe.

## REST Endpoints

Following are list of the REST endpoints that can be called in order to test the application:

```
(GET) http://{{domain}}/api/v1/flights
```
Description: Gets all flights data in the database.

```
(GET) http://{{domain}}/api/v1/flights?airlineName=LATAM Airlines
```
Description: Gets a list of flights filtered by the airline name.

```
(GET) http://{{domain}}/api/v1/flights?ident=AAL950
```
Description: Gets a list of flights filtered by the ident.

```
(GET) http://{{domain}}/api/v1/flights?airlineName=LATAM Airlines&ident=AAL950
```
Description: Gets a list of flights filtered by the airline name and by the ident.

```
(GET) http://{{domain}}/api/v1/flights/123
```
Description: Gets the flight by its identifier.

## Technologies used in this project

- Java 8;
- Spring MVC and Spring Boot;
- RESTfull;
- Maven to the dependency management;
- MariaDB as the database (https://mariadb.org/);
- Liquibase to generate the database, tables and data (http://www.liquibase.org/)
- Mockito (http://site.mockito.org/), PowerMock (http://powermock.github.io/) and FixtureFactory (https://github.com/six2six/fixture-factory) in unit tests.