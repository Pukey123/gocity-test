# Intro
Hi Welcome to Go Inventory

Simple app for looking through your products with simple search and ordering functions

# Start up
To run the application simply build using mvn
```
mvn clean install
```
Once built use an IDE (Suggest using **Intellij**) or run the .jar through command line

## Design
### Backend
Using Java to provide light weight in design backend. Mostly utilises items provided by spring libraries.

Notably Spring web, JPA and REST services.

#### JPA / REST
JPA provided solution for sorting and pagination.

This was also automatically hosted via a REST api

API also supports crud operations but given timescale was not able to implement Update / Delete

#### Web hosting
Spring provides hosting out of the box for static web content

Used a plugin to assist with creating the static bundle

### Front End
A simple js react app all components can be found in app.js

This has the most logic to determine page sizes / sorting etc

### Improvement / Todo
1. Add Category Filter (JPA interface additional method + front end changes)
2. Create delete functionality
3. Create Update functionality (new modal / screen required)
4. Security - utilise spring security to secure endpoints
5. Clean up UI structure seperate files per component

### Resources
- https://spring.io/guides/tutorials/react-and-spring-data-rest/
- https://github.com/spring-guides/tut-react-and-spring-data-rest/tree/master/basic
- https://reactjs.org/docs/hello-world.html