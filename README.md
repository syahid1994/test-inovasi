# 🚀 Spring Boot MySQL Demo

A simple **Spring Boot (Java 17)** application with **MySQL** backend and **Swagger UI** for API testing.  

---

## ⚙️ Requirements
- **Java 17**
- **Maven 3.8+**
- **MySQL 8+**

---

## 🗄️ Database Setup
1. Start MySQL and login:
   ```bash
   mysql -u root -p
   ```
2. Create database:
   ```sql
   create database test_inovasi_syahid;
   ```
3. Configure your database connection in `src/main/resources/application.properties`:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/test_inovasi_syahid?useSSL=false&serverTimezone=UTC
   spring.datasource.username=your_mysql_username
   spring.datasource.password=your_mysql_password
   spring.jpa.hibernate.ddl-auto=update
   spring.jpa.show-sql=true
   ```

---

## ▶️ Run the Application
Use Maven:
```bash
mvn spring-boot:run
```

---

## 📖 API Documentation
Swagger UI is available at:  
👉 [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)

---

## 🛠️ Example API Calls

### 1. Create Product
```bash
curl -X 'POST'   'http://localhost:8080/product/save'   -H 'accept: */*'   -H 'Content-Type: application/json'   -d '{
  "productID": "10001",
  "productName": "Test 1"
}'
```

### 2. Create Transaction
```bash
curl -X 'POST'   'http://localhost:8080/transaction/save'   -H 'accept: */*'   -H 'Content-Type: application/json'   -d '{
  "transactionID": "TRX250800001",
  "productID": "10001",
  "amount": 1000,
  "customerName": "abc",
  "status": 0,
  "transactionDate": "2022-07-10 11:14:52",
  "createBy": "abc"
}'
```

### 3. View Transactions
```bash
curl -X 'GET'   'http://localhost:8080/transaction/viewdata'   -H 'accept: */*'
```

---

## ✅ Tech Stack
- **Spring Boot 3+**
- **Java 17**
- **Spring Data JPA**
- **MySQL**
- **Swagger / OpenAPI**
