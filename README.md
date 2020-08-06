## Register Vacation

This is a simple project that try to demonstrate an implementation of microservice architecture. This project runs together with the projects: security-auth,
zuul, and the gateway UI. The domain of this project is a CRUD, where you can insert an employee, a team, and a vacation for this employee.

##Configurations

There is a folder "docker" on the root project that can be used to up a mysql database and the data. To run: docker-compose up.

## How to run

mvn spring-boot:run
 
##TODO
On next versions, it will be implementing the queue with apache Kafka and a sender email, in GO.