# Objective
Complete the given Spring Boot Movie REST API, that use Spring Data JPA to interact with h2 in-memory database, by adding the missing code wherever required and submit within the alloted time.

# Complete the following as per the requirement
## Define Data Model - Movie Class  

Define the following properties in Movie Class. Properties should be private.
- id: int
- movieName: String
- language: String
- genre: String

Define parameterized constructor to initialize all the properties  
Define Getter and Setter for all the properties  

## Create Repository Interface  

In dao package, create MovieRepository interface that extends JPARepository  

## Create Service Class  

In service package, complete the MovieServiceImpl class by implementing the methods specified in the MovieService interface for providing the getAll, getById and addNew functionalities. These methods invokes the appropriate repository methods for interacting with the database and throws appropriate custom exceptions.   

## Create Movie Rest APIs Controller

In controller package, Complete the MovieController class that has the handler methods, for performing getAll, getById and addNew operations, mapped to appropriate URIs for RESTful requests.  

## APIs to be provided

| GET  	| /api/v1/movies      	| get all Movies     	|
|------	|------------------------	|-----------------------	|
| GET  	| /api/v1/movies/{id} 	| get a Movie by id 	|
| POST 	| /api/v1/movies      	| create a new Movie 	|   
  

**Note:-** Read the instructions given as comments in the class files and also understand the failure messages displayed, when running the test cases, to complete the code.   
