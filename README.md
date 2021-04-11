  

# Explore the possible of Spring Boot

## Practice the integration of different frontend and backend frameworks with spring boot

    Backend: Spring boot server , mongo database/MySql
    Frontend: React / thymeleaf

## General configuration of the spring boot app

WebSecurityConfig defines what request will go through


## Mongodb support

AccountRepository extends MongoRepository<Account,String> provides methods to retrieve data fromm mongo database as Account type or list of Account type

EmployerRepository extends MongoRepository<Employer,String> provides methods to retrieve data fromm mongo database as Employer type or list of Employer type

## MySQL support

UserRepository extends CrudRepository<User, Integer> provides methods to retrieve data fromm MySql database as User type


