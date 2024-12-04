# Online Voting System - Voting Management Application

Online Voting System is an application designed to facilitate secure and efficient voting processes. It allows users to register as voters, cast their votes, and view election results in real-time. Built with *Java, **MySQL, and *JDBC, this project aims to provide a transparent and user-friendly system for managing elections.

# Features

- User Registration and Login
- Create and manage elections
- Cast votes securely
- View election results
- Admin panel for election management

# Setup

# Prerequisites
Before you begin, ensure you have the following installed:

1. JDK 17 or higher
2. MySQL Database
3. Maven

# Installation
1. Clone this repository to your local machine:

    - git clone https://github.com/yourusername/online-voting-system.git

2. Set up the database:

    - Install MySQL and create a new database called voting_system.
    - Run the create_tables.sql script to create necessary tables.

3. Configure the database connection:

 Edit the DBConnection.java file in the util package to set your database credentials (username, password, URL).

4. Run the project:

    -  Open the project in your preferred IDE (IntelliJ IDEA or Eclipse).
    -  Build and run the project.

# Technologies Used
1. Java (JDK 17)
2. MySQL (for database)
3. JDBC (for database connectivity)
4.  Maven (for dependency management)

# Database Schema
The project uses the following tables:

1. users - stores user information.
2. elections - stores election details.
3. votes - records votes cast by users.
4. results - stores election results.

# Installation

# JDK (Java Development Kit) Setup


The Java Development Kit (JDK) is a software development kit used to develop Java applications. It contains everything you need to compile, debug, and run Java applications, including the Java Runtime Environment (JRE) and the necessary development tools.

# Steps to Install JDK:
1. Download JDK:

    -  Visit the official Oracle website: JDK Downloads or use OpenJDK from AdoptOpenJDK.
    -  Choose the appropriate version for your operating system (Windows, macOS, or Linux).

2. Install JDK:

    -  Run the installer and follow the on-screen instructions.
    -  On Windows, ensure that you check the option to Add Java to PATH during installation.

3. Verify JDK Installation:

    -  Open the command prompt (Windows) or terminal (macOS/Linux).
    -  Type the following command to check if JDK is installed correctly:

        - java -version
If the installation is successful, you should see the installed version of Java.

4. Set JAVA_HOME (Optional):

- You may need to set the JAVA_HOME environment variable to the JDK installation directory. This is often necessary for IDEs and build tools like Maven or Gradle.
For Windows:
   - Right-click This PC -> Properties -> Advanced system settings -> Environment Variables.
   - Add a new system variable JAVA_HOME with the value as the directory path of your JDK installation (e.g., C:\Program Files\Java\jdk-17.x.x).

# IDE (Integrated Development Environment) Setup

An IDE (Integrated Development Environment) is a software that provides comprehensive facilities to computer programmers for software development. IDEs typically include features like code completion, debugging, and version control integration.

For this project, you can use IntelliJ IDEA or Eclipse as the IDE.

# IntelliJ IDEA Setup:

# Download IntelliJ IDEA:

- Visit the official website: IntelliJ IDEA Downloads.
- Choose the Community edition (free) and download it for your operating system.

# Install IntelliJ IDEA:

Run the installer and follow the instructions for your platform.

# Configure JDK in IntelliJ IDEA:

- Open IntelliJ IDEA and go to File -> Project Structure -> Project.
- In the Project SDK section, click Add SDK and select the path to your JDK installation directory.

# Create a New Project:

- Once JDK is set up, you can create a new project by selecting File -> New Project.
- Choose Java as the project type, and follow the steps to set up your project.
# Eclipse Setup:

# Download Eclipse:
Visit the official Eclipse website: [Eclipse Downloads](https://www.eclipse.org)

## License

This project is licensed under the MIT License.