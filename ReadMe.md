# TodoList Application

A simple **Spring Boot** REST API for managing a todo list with **MySQL** as the database. The project supports **Docker** for easy setup and deployment.

---

## Table of Contents

- [Features](#features)
- [Tech Stack](#tech-stack)
- [Getting Started](#getting-started)
- [API Endpoints](#api-endpoints)
- [Database](#database)
- [Docker](#docker)
- [Contributing](#contributing)
- [License](#license)

---

## Features

- Create, Read, Update, and Delete tasks
- Assign priorities to tasks
- Validation for required fields
- Dockerized for quick setup
- Swagger/OpenAPI documentation support

---

## Tech Stack

- **Backend:** Java 21, Spring Boot 3.5
- **Database:** MySQL 8.1
- **Docker:** Docker Compose
- **API Documentation:** Swagger (/swagger-ui/index.html)

---

## Getting Started

### Prerequisites

- Docker & Docker Compose installed
- Git installed
- Optional: Postman or any API client

### Clone the repository

```bash
git clone https://github.com/username/TodoList.git
cd TodoList

```

### Swagger

Swagger UI is available at:

http://localhost:8080/swagger-ui/index.html


### API Endpoints
Example:

PUT URL: http://localhost:8080/todoList/1
{
"description": "Sample task",
"priority": 1
}
