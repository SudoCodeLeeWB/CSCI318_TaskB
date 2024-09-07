# Task B
* DDD structure with microservices
* Dataflow : apiGateway -> each micro services

___
## Metadata

### Microservice Ports:
* Api gateway : 8080
* Product Microservice : 8081  
* User Microservice : 8082
* Order Microservice : 8083

___
### Project Structure
* 4 different projects in one root directory
* Each sub-directory represents each microservice 
* api gateway : 
* Order : 
* Product : 
* User : 


#### Microservice Product layer structure 
* presentation : for handling api calls
* application : for handling usecases
* dto : to be used in presentation layer & applicaion layer
* domain : represents the sub-domain
* infrastructure.persistence : technical part (interface) to connect the DataBase (H2)


___
### Sample Rest Api calls

* For each usecase ( 9 usecases ) & operating systems
* Should be working using curl

#### Format
  * UseCase : 
  * Windows Powershell
  * Windows cmd
  * Macos / Linux 

___

### Tasks to be done :
1. Implemented the sample connection for the Product_microservice  => done
2. Make the api gateway ( port 8080 ) to forward the response from the microservices. 
3. Set the usecase for each micro services 
4. implement the each microservice usecase 
5. Add a sample rest call & api gateway calls
6. Project done