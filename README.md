#periferia-test-customer-management-spring-boot

A Spring Boot application for managing customer data. The application provides endpoints to query customer information based on customer ID and type.

## Getting Started

### Prerequisites

- Java 8 or higher
- Maven
- Spring Boot

### Installation

1. Clone the repository:
git clone https://github.com/Nemezeck/periferia-test-customer-management-spring-boot

2. Navigate to the project directory:
cd customer-data-management
3. Build the project:
mvn clean install
4. Run the application:
java -jar target/my-service1-0.0.1-SNAPSHOT.jar

The application will be running on `http://localhost:8090`.

## Usage

Once the application is running, you can query customer information using the following endpoint:

GET /customer?id=<customer_id>&idtype=<customer_type>
