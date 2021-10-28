**HOW TO BUILD** 

**With Eclipse :**
To "solely" build, simply open the project in IDE and build it by right clicking **pom.xml** -> **Maven Build**.
You need to have **Spring Tools for Eclipse** plugin downloaded.


**With Command Prompt**
1. Open Comman Prompt as administrator 
2. Change directory **(cd)** to project root (that includes **pom.xml**)
3. Execute command  **mvn clean install**. This will build the project and generate a .jar file in the **target** folder


------------------------------------------------------------------------------------------------------------------------------------------------------------------------


**HOW TO RUN**

**With Eclipse**
To run the api, open the project in Eclipse, **Run -> RunAs -> Spring Boot App**
You need to have **Spring Tools for Eclipse** plugin downloaded.


**With Command Prompt**
1. After executing **mvn clean install** to build the project, execute **mvn dependency:copy-dependencies** . This will collect all the dependencies needed to 
   run the project into **/target/dependency**.
2. Change directory into **/target**
3. Run the main method with **java -cp TodoAppAssignmentApplication-0.0.1-SNAPSHOT.jar;dependency TodoAppAssignmentApplication** , here use **:** for LINUX/MAC.
   **-cp** defines class path, **TodoAppAssignmentApplication** is the class that is being run that has the main method.
   
------------------------------------------------------------------------------------------------------------------------------------------------------------------------
   
   
**HOW TO USE/TEST**
   
   After running, simply open your browser and go to **http://localhost:8080/swagger-ui/#/**. There you can juggle with REST controllers mapped methods. 
   **Use "admin" as both username and password for authentication**. After your login, Swagger UI will not ask for anymore authentication (For some reason). 
   Unit tests can be run with Eclipse.
   
------------------------------------------------------------------------------------------------------------------------------------------------------------------------

**DOCKER : https://hub.docker.com/r/jilet/todoappassignment**
- Pull Command : **docker pull jilet/todoappassignment**
