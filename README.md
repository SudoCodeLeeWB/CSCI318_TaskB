 ## About this project 
 
This directory consists of 4 different projects with different purposes.

API Gateway: To route each API request to the appropriate microservice

Customer Microservice: To handle the Customer information 
Use Cases 
- Add new user
- Update User information
     
Product Microservice: To handle the Product information
Use Cases 
- Add new product
- Update product stock
- View items from the preferred category 
- Get items which quantity is more than 1

Order Microservice: To handle the Customer Order information
Use Cases
- Add new product to the order 
- Place Order
- Mark the order as deliverd

## Project Build and Execution
Clone the repository or unzip the project file.
Navigate to the project directory.
Execute `mvn clean install`
Execute `./mvnspring-boot:run`

### Sample Rest Requests :

#### 1. Get Product by ID (`/get/{productId}`)

#### Linux/Mac Terminal & Windows CMD
```bash
curl -X GET "http://localhost:8081/get/1" -H "accept: application/json"
```
#### Windows PowerShell
```bash
curl -Uri http://localhost:8081/get/1
```

This fetches the product with `productId = 1`.

---

#### 2. Update Product Stock (`/patch/{product_id}/{quantity}`)

#### Linux/Mac Terminal & Windows CMD
```bash
curl -X PATCH "http://localhost:8081/patch/1/50" -H "accept: application/json"
```
#### Windows PowerShell
```bash
curl -Uri http://localhost:8081/patch/1/50
```

This updates the stock of the product with `product_id = 1` to `50`.

---

#### 3. View Preferred Category Products (`/get/prefer/{customer_id}`)

#### Linux/Mac Terminal & Windows CMD
```bash
curl -X GET "http://localhost:8081/get/prefer/123" -H "accept: application/json"
```
#### Windows PowerShell
```bash
curl -Uri http://localhost:8081/get/prefer/123
```
This fetches the preferred products for the customer with `customer_id = 123`.

---

#### 4. Get Items with Stock Greater Than 1 (`/get/available`)

#### Linux/Mac Terminal & Windows CMD
```bash
curl -X GET "http://localhost:8081/get/available" -H "accept: application/json"
```
#### Windows PowerShell
```bash
curl -Uri http://localhost:8081/get/available
```
This fetches products where the quantity (stock) is more than 1.

---

#### 5. Add New Product (`/create`)

#### Linux/Mac Terminal
```bash
curl -X POST "http://localhost:8081/create" -H "Content-Type: application/json" -d '{
	"fullName": "Gaming Laptop",
	"description": "High-performance laptop for gaming with 16GB RAM and RTX 3080 GPU.",
	"price": 2000,
	"stock": 15,
	"category": "Electronics"
}'
```
####  Windows CMD
```bash
curl -X POST "http://localhost:8081/create" -H "Content-Type: application/json" -d "{\"fullName\": \"Gaming Laptop\", \"description\": \"High-performance laptop for gaming with 16GB RAM and RTX 3080 GPU.\", \"price\": 2000, \"stock\": 15, \"category\": \"Electronics\"}"
```
####  Windows PowerShell
```bash
curl -Method POST "http://localhost:8081/create" -Headers @{ "Content-Type" = "application/json" } -Body '{ "fullName": "Gaming Laptop", "description": "High-performance laptop for gaming with 16GB RAM and RTX 3080 GPU.", "price": 2000, "stock": 15, "category": "Electronics"}'
```
This creates a new product with the provided details.

___

## Customer Microservice Testing


### 1. Add New Customer (`/create`)

#### Sample `curl` Command:

#### Linux/Mac Terminal
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
####  Windows CMD
```bash
curl -X POST "http://localhost:8081/create" -H "Content-Type: application/json" -d "{\"fullName\": \"Gaming Laptop\", \"description\": \"High-performance laptop for gaming with 16GB RAM and RTX 3080 GPU.\", \"price\": 2000, \"stock\": 15, \"category\": \"Electronics\"}"
```
####  Windows PowerShell
```bash
curl -Method POST "http://localhost:8081/create" -Headers @{ "Content-Type" = "application/json" } -Body '{ "fullName": "Gaming Laptop", "description": "High-performance laptop for gaming with 16GB RAM and RTX 3080 GPU.", "price": 2000, "stock": 15, "category": "Electronics"}'
```

### 2. Update User information

#### Linux/Mac Terminal
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
```
####  Windows CMD
```bash
curl -X PATCH "http://localhost:8082/patch/3" -H "Content-Type: application/json" -d "{\"f_name\": \"John\", \"l_name\": \"Doe\", \"email\": \"john.doe@example.com\", \"address\": {\"street\": \"456 Oak St\", \"state\": \"Texas\", \"country\": \"USA\", \"postCode\": \"73301\"}, \"preferenceCategory\": \"Books\"}"
```
####  Windows PowerShell
```bash
curl -Method PATCH "http://localhost:8082/patch/3" -Headers @{ "Content-Type" = "application/json" } -Body '{ "f_name": "John", "l_name": "Doe", "email": "john.doe@example.com", "address": { "street": "456 Oak St", "state": "Texas", "country": "USA", "postCode": "73301" }, "preferenceCategory": "Books" }'
```
