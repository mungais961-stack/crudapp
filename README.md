# Cloud Vendor CRUD Application

A Spring Boot REST API application demonstrating complete CRUD (Create, Read, Update, Delete) operations for managing cloud vendors with MySQL database integration.

## 📚 About

This project was built as a learning exercise to master CRUD application development. It serves as a practical reference implementation for building REST APIs with Spring Boot, JPA, and MySQL.

## 🏗️ Architecture

The application follows a clean, layered architecture:

```
com.simonCRUD.CRUDapplication/
├── controller/       # REST API endpoints
├── service/          # Business logic interface & implementation
├── model/            # JPA entities
└── repository/       # Data access layer (JPA repositories)
```

### Core Layers

- **Controller**: `CloudVendorController` - REST endpoints for HTTP requests
- **Service**: `CloudVendorService` interface & `CloudServiceImpl` - Business logic implementation
- **Model**: `CloudVendor` - JPA entity mapped to MySQL database
- **Repository**: `CloudVendorRepository` - JPA repository for database operations

## 🛠️ Technology Stack

- **Language**: Java
- **Framework**: Spring Boot 3.5.6
- **Database**: MySQL
- **ORM**: JPA/Hibernate
- **Build Tool**: Maven
- **Java Version**: Java 25

### Key Dependencies

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <version>8.0.33</version>
</dependency>
```

## 📊 Data Model

The `CloudVendor` entity represents a cloud service provider:

| Field | Type | Description |
|-------|------|-------------|
| `vendorId` | String | Primary key identifier |
| `vendorName` | String | Name of the vendor |
| `vendorAddress` | String | Physical address |
| `vendorPhoneNumber` | String | Contact phone number |

**Database Table**: `cloud_vendor_info`

## 🔌 API Endpoints

All endpoints are prefixed with `/cloudVendor`:

### Get All Vendors
```
GET /cloudVendor
```
Returns a list of all cloud vendors.

**Response**: `List<CloudVendor>`

### Get Vendor by ID
```
GET /cloudVendor/{vendorId}
```
Retrieves a specific vendor by ID.

**Response**: `CloudVendor`

### Create Vendor
```
POST /cloudVendor
Content-Type: application/json

{
    "vendorId": "V001",
    "vendorName": "AWS",
    "vendorAddress": "123 Main Street",
    "vendorPhoneNumber": "+1-234-567-8900"
}
```

**Response**: `"CloudVendor created successfully."`

### Update Vendor
```
PUT /cloudVendor
Content-Type: application/json

{
    "vendorId": "V001",
    "vendorName": "Amazon Web Services",
    "vendorAddress": "456 Oak Avenue",
    "vendorPhoneNumber": "+1-234-567-8901"
}
```

**Response**: `"CloudVendor details updated successfully."`

### Delete Vendor
```
DELETE /cloudVendor/{vendorId}
```
Deletes a vendor by ID.

**Response**: `"CloudVendor details deleted successfully."`

## ⚙️ Configuration

The application uses `application.yaml` for configuration:

```yaml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/cloud_vendor2
    username: root
    password: [your-password]
  jpa:
    hibernate:
      ddl-auto: create
    show-sql: true
    properties:
      hibernate:
        format_sql: true
```

### Configuration Parameters

- `ddl-auto: create` - Creates tables automatically on startup (use `update` for production)
- `show-sql: true` - Logs SQL queries to console
- `format_sql: true` - Formats SQL for readability

## 🚀 Getting Started

### Prerequisites

- Java 25 or higher
- MySQL 5.7 or higher
- Maven 3.6 or higher

### Setup Instructions

1. **Clone the repository**
   ```bash
   git clone https://github.com/mungais961-stack/crudapp.git
   cd crudapp
   ```

2. **Configure MySQL Connection**
   - Update `src/main/resources/application.yaml` with your MySQL credentials
   - Create a MySQL database: `CREATE DATABASE cloud_vendor2;`

3. **Build the application**
   ```bash
   ./mvnw clean build
   ```

4. **Run the application**
   ```bash
   ./mvnw spring-boot:run
   ```

   The application will start on `http://localhost:8080`

## 📝 Example Usage

### Create a Vendor
```bash
curl -X POST http://localhost:8080/cloudVendor \
  -H "Content-Type: application/json" \
  -d '{
    "vendorId": "V001",
    "vendorName": "AWS",
    "vendorAddress": "Seattle, WA",
    "vendorPhoneNumber": "+1-206-555-0100"
  }'
```

### Get All Vendors
```bash
curl http://localhost:8080/cloudVendor
```

### Get Specific Vendor
```bash
curl http://localhost:8080/cloudVendor/V001
```

### Update Vendor
```bash
curl -X PUT http://localhost:8080/cloudVendor \
  -H "Content-Type: application/json" \
  -d '{
    "vendorId": "V001",
    "vendorName": "Amazon Web Services",
    "vendorAddress": "Seattle, WA",
    "vendorPhoneNumber": "+1-206-555-0101"
  }'
```

### Delete Vendor
```bash
curl -X DELETE http://localhost:8080/cloudVendor/V001
```

## 🎓 Learning Outcomes

This project demonstrates:

✅ **Spring Boot fundamentals** - Application structure and auto-configuration  
✅ **REST API design** - Proper HTTP methods and endpoint design  
✅ **Data persistence** - JPA/Hibernate ORM and MySQL integration  
✅ **Dependency injection** - Spring's constructor injection pattern  
✅ **Layered architecture** - Separation of concerns across layers  
✅ **CRUD operations** - Complete data manipulation cycle  
✅ **Database operations** - Repository pattern and JPA queries

## 📂 Project Structure

```
crudapp/
├── src/
│   ├── main/
│   │   ├── java/com/simonCRUD/CRUDapplication/
│   │   │   ├── controller/
│   │   │   │   └── CloudVendorController.java
│   │   │   ├── service/
│   │   │   │   ├── CloudVendorService.java
│   │   │   │   └── impl/
│   │   │   │       └── CloudServiceImpl.java
│   │   │   ├── model/
│   │   │   │   └── CloudVendor.java
│   │   │   ├── repository/
│   │   │   │   └── CloudVendorRepository.java
│   │   │   └── CruDapplicationApplication.java
│   │   └── resources/
│   │       └── application.yaml
│   └── test/
├── pom.xml
├── mvnw
├── mvnw.cmd
└── README.md
```

## 🔧 Troubleshooting

### MySQL Connection Issues
- Verify MySQL is running
- Check username and password in `application.yaml`
- Ensure the database `cloud_vendor2` exists

### Port Already in Use
- Default port is 8080. Change in `application.yaml`:
  ```yaml
  server:
    port: 8081
  ```

### Java Version Compatibility
- This project requires Java 25. Install or configure your IDE to use Java 25+

## 🚀 Potential Enhancements

- Add input validation using `@Valid` and Bean Validation
- Implement exception handling with `@ControllerAdvice`
- Add logging with SLF4J
- Create integration tests
- Add API documentation with Swagger/OpenAPI
- Implement pagination and filtering
- Add service layer unit tests

## 📖 References

- [Spring Boot Documentation](https://spring.io/projects/spring-boot)
- [Spring Data JPA](https://spring.io/projects/spring-data-jpa)
- [MySQL Documentation](https://dev.mysql.com/doc/)

## 📄 License

This project is open source and available under the MIT License.

## 👤 Author

Built as a learning project by [mungais961-stack](https://github.com/mungais961-stack)

---

**Happy Learning! 🎉**

This was invaluable practice for mastering CRUD applications and Spring Boot fundamentals.
