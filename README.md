# Task Manager

Task Manager is a comprehensive web application designed to help users efficiently manage their tasks. The project is built using Java, Spring Boot, and Spring Security, providing a robust and secure environment for task management.

## Features

- **User Management:** Task Manager incorporates a user management system with authentication and authorization capabilities. Users can securely register, log in, and perform actions based on their roles.

- **Task CRUD Operations:** The application allows users to create, read, update, and delete tasks. Each task is associated with the authenticated user, ensuring data privacy.

- **Security:** Utilizing Spring Security, Task Manager prioritizes the security of user data. Passwords are securely encoded, and access to tasks is restricted to the authenticated user.

- **Database Interaction:** The application interacts with an H2 in-memory database, providing a seamless and persistent data storage solution.

## Project Structure

- **Entities:** The project defines two main entities: `Personnel` to manage users and `Task` for task-related information.

- **Repositories:** Separate repositories (`PersonnelRepository` and `TaskRepository`) handle database interactions for their respective entities.

- **Services:** The application employs services (`PersonnelService` and `TaskService`) to encapsulate business logic and manage interactions between controllers and repositories.

- **Controllers:** Controllers (`PersonnelController` and `TaskController`) handle HTTP requests, ensuring a smooth flow of data between the frontend and backend.

- **Data Initialization:** The `DataInitializer` class initializes sample data for tasks upon application startup.

## Getting Started

1. Clone the repository.
2. Build the project using Maven: `mvn clean install`.
3. Run the application: `java -jar target/TaskManager-0.0.1-SNAPSHOT.jar`.
4. Access the application at `http://localhost:8080`.

## Dependencies

- Java 17
- Spring Boot 2.5.5
- H2 Database
- Maven

## Contributing

Feel free to contribute to the project by submitting bug reports, feature requests, or pull requests. Your feedback is highly appreciated.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

