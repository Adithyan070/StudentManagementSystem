Software Requirements Specification (SRS)
Console-Based Student Management System

1. Introduction

1.1 Purpose
The purpose of this Software Requirements Specification (SRS) is to define the functional and non-functional requirements for the Console-Based Student Management System.
This document serves as the single source of truth for all features, constraints, and expectations of the system. It ensures alignment between developers, reviewers, and project stakeholders.

1.2 Scope
The Student Management System is a Java-based backend-only console application designed to manage student records such as adding, viewing, updating, and deleting information.
The system uses JDBC to connect to a relational database (Oracle Database in this implementation) and performs full CRUD operations using SQL.

1.3 Intended Audience

-->Project Managers

-->Technical Leads

-->Developers

-->Test Engineers

-->Intern Mentors

2. Overall Description

2.1 Product Perspective

This system is a standalone Java application running in a console environment.
It does not include a frontend or web layer.
The system interacts directly with an RDBMS through JDBC PreparedStatements.

2.2 User Needs / User Classes

Primary User: Intern / Developer using the console to perform CRUD operations

Needs:

-->Easily perform student operations

-->Persistent data storage in the database

-->Simple step-by-step menu navigation

2.3 Assumptions and Dependencies

-->Java JDK 8+ must be installed.

-->Oracle/MySQL/PostgreSQL must be running before the application starts.

-->JDBC driver (ojdbc8.jar for Oracle) must be correctly configured.

-->Student table must exist in the database.

-->The application runs in a single-user environment.

3. System Features (Functional Requirements)
All functional requirements follow the “shall” format.

1: Add Student
The system shall allow the user to add a new student by entering details (ID, name, age, marks) which shall be stored in the database.

2: View All Students
The system shall retrieve and display all student records stored in the database.

3: Search Student
The system shall allow the user to search for a student by ID using a database query.

4: Update Student Information
The system shall allow the user to update existing fields such as name, age, and marks for a specific student.

5: Delete Student
The system shall allow the user to delete a student record permanently from the database.

6: Input Validation
The system shall validate all user inputs and shall prevent invalid or null entries.

7: Persistent Storage
The system shall store all student records in a relational database using JDBC.

8: Menu-Based Interface
The system shall display a console-based menu to guide user actions (Add, View, Update, Delete, Search, Exit).

4. Non-Functional Requirements

4.1 Performance Requirements
The system shall respond to user input within 1 second.
Database operations shall complete within acceptable response time (<2 seconds).

4.2 Security Requirements
The system shall use PreparedStatement to prevent SQL injection.
Database credentials shall be stored securely in the configuration class.

4.3 Usability Requirements
The system shall be intuitive and require no prior training.
All menu instructions shall be clear and unambiguous.

4.4 Reliability Requirements
The system shall handle invalid inputs gracefully without terminating unexpectedly.
The system shall be able to reconnect to the database if connection is temporarily lost.

4.5 Maintainability Requirements
The system’s codebase shall follow modular design using the DAO Pattern.
Database logic shall be separated from the main application.
