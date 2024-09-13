# Task B
* DDD structure with microservices
* Dataflow : apiGateway -> each micro services

___
## Metadata

### Microservice Ports:
* Api gateway : 8080
* Product Microservice : 8081  
* Customer Microservice : 8082
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

// Add image here

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

### Sample rest connection from Api router to microservice server: 
`curl -X GET http://localhost:8080/api/products/getProduct/13 `

-> It will return the hello from the microservice Product 


### TODO list :

1. Implemented the sample connection for the Product_microservice  => Done
2. Make the api gateway ( port 8080 ) to forward the response from the microservices.  => Done
   1. Apply the try catch for http response. 

3. Define & Implement Use Case
   1. Design Aggregate for each micro service => Done 
   2. Design Application Service / Domain methods based on Use Case
   3. Design DTO based on Aggregate 
   4. Implement Api Mapping from Presentation Layer

4. Add a sample rest call & api gateway calls
5. Project done




___

### Partial Tests : 

* For microservice Product testing ( directly testing for microservice ): 
* 
* Linux/ macos for now

#### 1. Get Product by ID (`/get/{productId}`)

```bash
curl -X GET "http://localhost:8081/get/1" -H "accept: application/json"
```

This fetches the product with `productId = 1`.

---

#### 2. Update Product Stock (`/patch/{product_id}/{quantity}`)

```bash
curl -X PATCH "http://localhost:8081/patch/1/50" -H "accept: application/json"
```

This updates the stock of the product with `product_id = 1` to `50`.

---

#### 3. View Preferred Category Products (`/get/prefer/{customer_id}`) 

```bash
curl -X GET "http://localhost:8081/get/prefer/123" -H "accept: application/json"
```

This fetches the preferred products for the customer with `customer_id = 123`.

---

#### 4. Get Items with Stock Greater Than 1 (`/get/available`) 

```bash
curl -X GET "http://localhost:8081/get/available" -H "accept: application/json"
```

This fetches products where the quantity (stock) is more than 1.

---

#### 5. Add New Product (`/create`)

```bash
curl -X POST "http://localhost:8081/create" -H "Content-Type: application/json" -d '{
    "fullName": "Gaming Laptop",
    "description": "High-performance laptop for gaming with 16GB RAM and RTX 3080 GPU.",
    "price": 2000,
    "stock": 15,
    "category": "Electronics"
}'
```

This creates a new product with the provided details.

___

## Customer Microservice Testing 


### 1. Add New Customer (`/create`)

#### Sample `curl` Command:

```bash

curl -X POST "http://localhost:8082/create" -H "Content-Type: application/json" -d '{
    "f_name": "John",
    "l_name": "Doe",
    "email": "john.doe@example.com",
    "address": {
        "street": "123 Main St",
        "state": "California",
        "country": "USA",
        "postCode": "90001"
    },
    "preferenceCategory": "Electronics"
}'
```

### 2. Update User information

```bash
curl -X PATCH "http://localhost:8082/patch/3" -H "Content-Type: application/json" -d '{
    "f_name": "John",
    "l_name": "Doe",
    "email": "john.doe@example.com",
    "address": {
        "street": "456 Oak St",
        "state": "Texas",
        "country": "USA",
        "postCode": "73301"
    },
    "preferenceCategory": "Books"
}'
