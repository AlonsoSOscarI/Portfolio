# School Management System in Java

## Overview
This School Management System is specifically tailored for the efficient management and administration of small schools. By transitioning from traditional methods like notebook or physical file registrations to a more advanced, technology-driven approach, the system aims to simplify and clarify the enrollment process. Developed using Java Swing for the user interface and PHPMyAdmin with SQL through XAMPP for database management, it provides a comprehensive administrative solution that leverages the advantages of database systems over rudimentary record-keeping methods. All data entry fields come with stringent validations to ensure the accuracy and integrity of the information entered into the database.

## Technical Overview
- **Interface**: Crafted with Java Swing to ensure an intuitive and accessible user experience.
- **Database Connectivity**: Utilizes JDBC version 8.2.0 for reliable database integration, facilitating seamless interaction between the Java application and the SQL database managed through XAMPP.
- **Data Validation**: Rigorous validation rules are applied to all input fields to prevent the entry of invalid data, maintaining the integrity and reliability of the database.
- **PDF Generation**: Incorporates the iTextPDF library for generating PDF documents, such as printable enrollment forms and financial reports, directly from the application.

## Features

### Secure Login
- Ensures system security and user authentication, safeguarding sensitive information.
- - ![Login](https://github.com/AlonsoSOscarI/Portfolio/blob/main/Java-SchoolManagementSystem/JavaOutput/1.%20Login.JPG)

### Main Dashboard
- The primary interface post-login, offering a "Home" button icon for quick access to the main view and easy navigation to various system functionalities.
- - ![Main Dashboard](https://github.com/AlonsoSOscarI/Portfolio/blob/main/Java-SchoolManagementSystem/JavaOutput/2.%20Main%20Dashboard.JPG)

### Student Registration
- A detailed registration form captures all necessary student details, with built-in validations to prevent incorrect data entry. The system dynamically adjusts available fields based on the student's educational level to streamline data input.
- - ![Student Registration](https://github.com/AlonsoSOscarI/Portfolio/blob/main/Java-SchoolManagementSystem/JavaOutput/3.%20Student%20Registration.JPG)

### Query Functionality
- Advanced search and filter capabilities allow for efficient data retrieval, with a responsive interface that updates results in real-time based on user input.
- - ![Query table](https://github.com/AlonsoSOscarI/Portfolio/blob/main/Java-SchoolManagementSystem/JavaOutput/4.%20Students%20Table.JPG)

### Data Modification
- Facilitates updates to existing student records through an intuitive interface, ensuring data accuracy through validation checks.
- - ![Student ID first](https://github.com/AlonsoSOscarI/Portfolio/blob/main/Java-SchoolManagementSystem/JavaOutput/5.%20Modify.JPG)
- -![Modify form](https://github.com/AlonsoSOscarI/Portfolio/blob/main/Java-SchoolManagementSystem/JavaOutput/6.%20Modify%20form.JPG)

### Soft Delete Mechanism
- Employs a non-destructive deletion approach, marking records as deleted to preserve data integrity while effectively removing them from active views.
- - ![Delete form](https://github.com/AlonsoSOscarI/Portfolio/blob/main/Java-SchoolManagementSystem/JavaOutput/7.%20Delete%20Form.JPG)

### Print Functionality
- Enables the creation of printable PDF enrollment forms.
- - ![Print form ](https://github.com/AlonsoSOscarI/Portfolio/blob/main/Java-SchoolManagementSystem/JavaOutput/8.%20Print%20Enrollment.JPG)
- - ![Resultan PDF](https://github.com/AlonsoSOscarI/Portfolio/blob/main/Java-SchoolManagementSystem/JavaOutput/9.%20Enrollment%20PDF.JPG)

### Financial Tracking
- The system automatically records enrollment-related payments, with adjustments for scholarship students and variable fees by grade level. An "Incomes" table provides a transparent financial overview, including a running total for clear insight into the school's financial status, print functionality included.
- - ![Enrollment pays table](https://github.com/AlonsoSOscarI/Portfolio/blob/main/Java-SchoolManagementSystem/JavaOutput/10.%20Incomes.JPG)
- - ![Enrollment pays PDF](https://github.com/AlonsoSOscarI/Portfolio/blob/main/Java-SchoolManagementSystem/JavaOutput/11.%20Incomes%20PDF.JPG)

## Acknowledgments
This project reflects a dedicated effort to address the unique administrative needs of small schools, showcasing the potential of tailored software solutions to significantly enhance operational efficiency and data management practices.

## License
This project is licensed under the MIT License - see the [LICENSE](./LICENSE) file for details.
