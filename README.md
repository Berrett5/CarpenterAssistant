CarpenterAssistant
CarpenterAssistant is a Java-based desktop application designed to help users manage carpentry-related tasks such as user registration, project tracking, and data storage. The application is built using Java Swing for the user interface and connects to a database using MySQL or SQL Server JDBC drivers.

Features
User registration interface (username, email, password)

Java Swing–based GUI

Database connectivity using JDBC

Modular project structure for easy maintenance

Cross‑platform support (Windows, macOS, Linux)

CarpenterAssistant/
│
├── nbproject/                 # NetBeans project configuration
├── src/com/carpenterassistant # Java source code
│   ├── RegisterGUI.java
│   └── (other GUI and logic classes)
│
├── mssql-jdbc-12.10.0.jre8.jar   # SQL Server JDBC driver
├── mysql-connector-j-9.1.0.jar   # MySQL JDBC driver
├── build.xml                     # Ant build script
└── manifest.mf                   # Application manifest

Requirements
Java 8 or higher
NetBeans IDE (recommended)
MySQL or SQL Server database
JDBC driver (included in the repo)

How to Run
Clone the repository: git clone https://github.com/Berrett5/CarpenterAssistant.git
Open the project in NetBeans.
Ensure your database is running and update your connection settings in the code (if required).
Build and run the project:
Right‑click the project → Run

Database Setup
Create a database (MySQL or SQL Server).
Add a users table with fields such as:
username
email
password
Update your JDBC connection string in the Java code to match your database.

Future Improvements
Add login authentication
Add project/task management features
Improve UI design
Add password hashing for security
Add deployment packaging (JAR or installer)
