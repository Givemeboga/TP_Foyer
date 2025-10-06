# TP Foyer Management System

This is a Spring Boot application for managing a university foyer system. It includes entities such as `Foyer`, `Bloc`, `Chambre`, `Etudiant`, and `Reservation` to handle various aspects of the system.

## Features

- **Foyer Management**: Manage foyers and their associated blocks.
- **Bloc Management**: Manage blocks and their associated rooms.
- **Room Reservations**: Handle reservations for students.
- **Student Management**: Manage student information and their reservations.
- **Bidirectional Relationships**: Implemented relationships between entities such as `One-to-Many`, `Many-to-Many`, etc.

## Technologies Used

- **Java**: Programming language.
- **Spring Boot**: Framework for building the application.
- **Hibernate/JPA**: ORM for database interaction.
- **Maven**: Dependency management.
- **Lombok**: To reduce boilerplate code.
- **H2/MySQL**: Database (can be configured in `application.properties`).

## Project Structure

- `src/main/java/org/esprim/tpfoyer/entities`: Contains entity classes such as `Foyer`, `Bloc`, `Chambre`, `Etudiant`, and `Reservation`.
- `src/main/java/org/esprim/tpfoyer`: Contains the main application class `TpFoyerApplication`.

## How to Run

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/Givemeboga/TP_Foyer.git
   cd TP_Foyer