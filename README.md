# Energy Meter Catalog — Back-end

REST API developed as part of a technical onboarding project at **Eletra Energy Solutions**. The application manages a hierarchical catalog of energy meter lines, categories, and models.

> Completed educational and professional onboarding project developed in 2024. No proprietary production source code is included.

## Overview

The back end exposes CRUD operations for three related resources:

```text
Line 1 ─── N Category 1 ─── N Model
```

It also provides filtered queries to retrieve categories by line and models by category. Data is persisted in PostgreSQL through Spring Data JPA and Hibernate.

## Technologies

- Java 8
- Spring Boot
- Spring Web
- Spring Data JPA
- Hibernate
- PostgreSQL
- Maven
- Swagger / Springfox
- Git and GitFlow

## Architecture

```text
HTTP request
     ↓
REST Controller
     ↓
Service
     ↓
JPA Repository
     ↓
PostgreSQL
```

The project is organized into controllers, services, repositories, and entities to keep HTTP handling, business queries, and persistence responsibilities separated.

## Main endpoints

### Lines

| Method | Endpoint | Description |
|---|---|---|
| `GET` | `/api/lines` | Lists all lines |
| `GET` | `/api/lines/{line-name}` | Finds a line by name |
| `POST` | `/api/lines` | Creates a line |
| `PUT` | `/api/lines` | Updates a line |
| `DELETE` | `/api/lines/{line-name}` | Deletes a line |

### Categories

| Method | Endpoint | Description |
|---|---|---|
| `GET` | `/api/categories` | Lists all categories |
| `GET` | `/api/categories/{line-name}` | Lists categories associated with a line |
| `POST` | `/api/categories` | Creates a category |
| `PUT` | `/api/categories` | Updates a category |
| `DELETE` | `/api/categories/{category-name}` | Deletes a category |

### Models

| Method | Endpoint | Description |
|---|---|---|
| `GET` | `/api/models` | Lists all models |
| `GET` | `/api/models/{category-name}` | Lists models associated with a category |
| `POST` | `/api/models` | Creates a model |
| `PUT` | `/api/models` | Updates a model |
| `DELETE` | `/api/models/{model-name}` | Deletes a model |

## Running locally

### Prerequisites

- JDK 8
- Maven
- PostgreSQL

### Configuration

Create a PostgreSQL database named `integration_project_bd` and execute the script located at:

```text
src/main/resources/bd.sql
```

Configure the application through environment variables:

```text
DB_URL=jdbc:postgresql://localhost:5432/integration_project_bd
DB_USERNAME=postgres
DB_PASSWORD=your_password
```

The datasource properties should use these variables:

```properties
spring.datasource.url=${DB_URL:jdbc:postgresql://localhost:5432/integration_project_bd}
spring.datasource.username=${DB_USERNAME:postgres}
spring.datasource.password=${DB_PASSWORD:}
```

Start the API:

```bash
mvn spring-boot:run
```

The server runs by default at:

```text
http://localhost:4455
```

Swagger documentation is available at:

```text
http://localhost:4455/swagger-ui.html
```

## Related project

The JavaFX desktop client that consumes this API is available in [integration_project_frontend](https://github.com/pdrflp0/integration_project_frontend).

## What I practiced

- Designing a relational data model
- Creating REST endpoints and CRUD operations
- Mapping entities and relationships with JPA/Hibernate
- Integrating Spring Boot with PostgreSQL
- Organizing code into application layers
- Working with feature branches, pull requests, code reviews, and continuous integration

## Author

Developed by [Pedro Felipe](https://github.com/pdrflp0) during the Eletra Energy Solutions scholarship program.
