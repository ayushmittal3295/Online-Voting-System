# Online Voting System

An online voting system developed using Java, JSP, JSTL, JUnit, JDBC, and MySQL inside Maven. This project aims to provide a platform for conducting online elections efficiently and securely.

## Table of Contents

- [Introduction](#introduction)
- [Technologies Used](#technologies-used)
- [Project Structure](#project-structure)
- [Database Schema](#database-schema)
- [Setup Instructions](#setup-instructions)
- [Features](#features)
- [How to Use](#how-to-use)
- [Testing](#testing)
- [Contributing](#contributing)

## Introduction

The Online Voting System is a web application that allows users to register, log in, and vote in elections. It is designed to be secure, user-friendly, and efficient.

## Technologies Used

- Java
- JSP (Java Server Pages)
- JSTL (JavaServer Pages Standard Tag Library)
- JUnit
- JDBC (Java Database Connectivity)
- MySQL
- HTML
- CSS
- Bootstrap
- JavaScript

## Project Structure

The project follows a standard Java web application structure:

```plaintext
onlinevotingsystem/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── onlinevoting/
│   │   │           ├── dao/
│   │   │           ├── model/
│   │   │           ├── service/
│   │   │           └── servlet/
│   │   ├── resources/
│   │   ├── webapp/
│   │       ├── WEB-INF/
│   │       │   └── web.xml
│   │       ├── css/
│   │       ├── js/
│   │       └── jsp/
│   └── test/
│       ├── java/
│       │   └── com/
│       │       └── onlinevoting/
│       │           └── test/
│       └── resources/
└── pom.xml
```

## Database Schema

The database schema is designed to handle user management and voting operations. Make sure to make the required changes in the credentials according to your database.

```sql
CREATE DATABASE evoting;

USE evoting;

CREATE TABLE contact (
  contact_id int NOT NULL AUTO_INCREMENT,
  name varchar(255) NOT NULL,
  company varchar(255) DEFAULT NULL,
  email varchar(255) NOT NULL,
  message text,
  PRIMARY KEY (contact_id)
)

CREATE TABLE login (
  voter_card_number varchar(255) NOT NULL,
  name varchar(255) NOT NULL,
  username varchar(255) NOT NULL,
  gender enum('Male','Female','Other') NOT NULL,
  dob date DEFAULT NULL,
  email varchar(255) DEFAULT NULL,
  password varchar(255) NOT NULL,
  PRIMARY KEY (voter_card_number)
)

CREATE TABLE contact (
  contact_id int NOT NULL AUTO_INCREMENT,
  name varchar(255) NOT NULL,
  company varchar(255) DEFAULT NULL,
  email varchar(255) NOT NULL,
  message text,
  PRIMARY KEY (contact_id)
)

CREATE TABLE `partytable` (
  pid int NOT NULL AUTO_INCREMENT,
  partyCode varchar(255) DEFAULT NULL,
  partyName varchar(255) NOT NULL,
  photo blob,
  PRIMARY KEY (pid),
  UNIQUE KEY partyCode (partyCode)
)

CREATE TABLE voter (
  voter_card_number varchar(200) NOT NULL,
  voter varchar(200) NOT NULL,
  PRIMARY KEY (voter_card_number)
)
```

## Setup Instructions

1. **Clone the repository:**

   ```bash
   git clone https://github.com/Aafi04/onlinevotingsystem.git
   ```
   
2. **Set up the development environment:**

   - Install JDK (Java Development Kit)
   - Set up your IDE (Eclipse, IntelliJ, etc.)
   - Install Apache Tomcat server

3. **Configure the database:**

   - Install MySQL
   - Create the database and tables using the provided schema

4. **Configure the project:**

   - Update the `src/main/resources/db.properties` file with your database credentials

5. **Build and deploy the project:**

   - Use Maven to build the project
   - Deploy the WAR file to the Tomcat server from the webapps directory.

## Features

### Review 1

- **Project Setup:**
  - Create a new project with JDK setup
  - Define the project structure
  - Design the database schema for the project
  - Create MySQL tables
  - Implement JDBC for database connectivity
  - Create DAO classes for database operations

### Review 2

- **User Management:**
  - Design HTML templates for user management
  - Style HTML templates using CSS and Bootstrap
  - Implement JavaScript for form validation and interactivity

### Review 3

- **Servlets and JSP Integration:**
  - Create and configure Servlets
  - Implement `doGet` and `doPost` methods
  - Implement user form registration and profile using Servlets
  - Integrate JSP with Servlets
  - Implement JSP pages for displaying user data
  - Use JSTL and EL in JSP pages

### Review 4

- **Testing and Documentation:**
  - Create unit tests for service and DAO layers using JUnit
  - Perform a final review of the project
  - Prepare project documentation

## How to Use

1. **Register as a new user:**
   - Go to the registration page and create an account

2. **Log in:**
   - Use your credentials to log in

3. **Participate in elections:**
   - View available elections and candidates
   - Cast your vote

4. **Admin functionalities:**
   - Create new elections
   - Add candidates to elections
   - View voting results

## Testing

Unit tests are created using JUnit. To run the tests:

1. **Navigate to the test directory:**

   ```bash
   cd src/test/java/com/onlinevoting/test
   ```

2. **Run the tests:**

   ```bash
   mvn test
   ```

## Contributing

Contributions are welcome! Please follow these steps:

1. Fork the repository
2. Create a new branch (`git checkout -b feature-branch`)
3. Make your changes
4. Commit your changes (`git commit -m 'Add feature'`)
5. Push to the branch (`git push origin feature-branch`)
6. Open a Pull Request

---