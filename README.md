# Amusement Park Web App
This repository contains the source code for an Amusement Park Web Application, developed using the Spring Framework in Java. The application allows users to perform CRUD (Create, Read, Update, Delete) operations on a database related to amusement park entities such as employees, attractions, and salary information.

## Features
### Employee Management:
- View a list of employees.
- Add new employees.
- Edit employee details.
- Delete employees.

### Salary Management:
- View a list of salary information for employees.
- Add new salary records.
- Edit existing salary records.
- Delete salary records.

### Attraction Management:
- View a list of attractions in the amusement park.
- Add new attractions.
- Edit attraction details.
- Delete attractions.

## Technologies Used:
- **Spring Framework:** The core framework used for building the web application.
- **Spring MVC:** For building the Model-View-Controller architecture.
- **Spring JDBC:** To interact with the database and perform CRUD operations.
- **Thymeleaf:** A modern server-side Java template engine for web and standalone environments.
- **Java Database Connectivity (JDBC):** For database connectivity and operations.
- **HTML, CSS, JavaScript:** For front-end development.

## Database Structure
The application uses a relational database with tables for Pracownicy (Employees), Wynagrodzenia (Salaries), and Atrakcje (Attractions). Refer to the corresponding DAO (Data Access Object) classes for details on the database interactions.

## Getting Started
- To run the application locally, follow these steps:
- Clone the repository by copying this code:
```bash
git clone https://github.com/Patr1ckf/AmusementPark.git
```
- Open the project in your preferred Java IDE.
- Configure the database connection in the application.properties file. (ask me about detailed information about connection to a database on server)
- add path in pom.xml to odjbc11.jar
- Build and run the application.
- Access the application in your web browser: http://localhost:8080

## Usage
- Navigate to the various pages using the provided URLs:
  - `/index`: Home page.
  - `/main_admin`: Admin dashboard for managing employees, salaries, and attractions.
  - `/main_user`: User dashboard for general amusement park information.
  - `/login`: Login page (authentication not yet implemented in this version).
- Perform CRUD operations on employees, salary records, and attractions using the respective pages.

## Screenshots

Explore visual snapshots of Amusement Park Web App to get a glimpse of its user interface and key features. These screenshots showcase various sections, including the homepage, admin dashboard, employee management, attractions, and more. Take a visual tour to see the app in action!


![Main page](OtherFiles/screenshots/img.png)
![Main page](OtherFiles/screenshots/img_1.png)
![Main page](OtherFiles/screenshots/img_2.png)
![Main page](OtherFiles/screenshots/img_3.png)
![Main page](OtherFiles/screenshots/img_4.png)
![Main page](OtherFiles/screenshots/img_5.png)
