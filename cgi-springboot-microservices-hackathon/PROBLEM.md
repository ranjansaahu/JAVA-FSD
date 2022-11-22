### SpringBoot Microservices Hackathon

### Tools and Technologies:

    - Spring Spring Boot
    - Spring data JPA/Mongo
    - MySQL, MONGODB
    - Postman / Swagger


In this Assessment, you will implement microservices to manage the insurance quotes based on the data received.

Need to build two microservices, which uses  MySQL /  MONGO DB. Data Access / Validation can be done through Postman / Swagger.

###  Microservice1 - REST API Development with MySQL
     Group id : com.cgi 
     Artifact : driver

#### Create a REST controller with the following core features (endpoints)
    • Post new driver details 
    • Get all driver details 
    • Delete details of a driver for the given driverid 

### A driver model will have the following attributes:
    • driverid        : int - Primarkey
    • firstname       : string
    • telephonenumber : number 
    • address         : string
    • city            : string
    • enginesize      : string 
    • quoteamount     : string

    Database name : DRIVERDB

#### Ensure the following
    1.	Duplicate driver id should raise exception - DuplicateDriverIdException
    2.	For Delete need to raise exception – DriverNotFoundException



###  Microservice2 - REST API Development with MONGODB
     Group id : com.cgi 
     Artifact : insurance

#### Create a REST controller with the following core features (endpoints)
    • Post new insurance details. 
    • Get all insurance details 
    • view insurance details based on given insurance id and planid 

#### Model
    Class : Insurance  
        • insuranceid : string – primary key
        • type        : string
        • Plan        : Plan class (embedded document)
    Class : Plan
        • planid   : string
        • planname : string
        • period   : number
        • amount   : number

    Database Name: insurancedb

Insurance is the base document and plan will be embedded document. While adding new insurance, need to verify the existence of insuranceid and add plans accordingly

#### Ensure the following
    1.	Duplicate insuranceid should raise exception - InsuranceAlreadyExistException
    2.	View by planid and insuranceid to raise exception – PlanIdNotFoundException

#### Sample data

    data Example 
    {
    “insuranecid” : “i01”,
    “type”: “Health”,
    “plan”:
        {
        “planid”:”p01”,
        “planname”: “Critical Illness”
        “period”:5
        “amount”:4500
        },
            {
        “planid”:”p02”,
        “planname”: “Family Illness”
        “period”:3
        “amount”:6500
        }
    },
    {
    “insuranecid” : “i02”,
    “type”: “Life Insurance”,
    “plan”:
        {
        ----
        ---
        },
            {
        ---
        }
    } 
### Unit Testing

    - Write atleast 5 unit test cases each, for Service and Controller classes, for both the microservices

#### Note:
    • Ensure you have used clean code and project structure to ensure that maintainability has been considered. 
    • Use Swagger UI / Postman to submit the details to the REST controller to test the post endpoint. 
    • Run the all endpoints. 
    • Push your code to gitlab and add mentor to your repo for review
    
