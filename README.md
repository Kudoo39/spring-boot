# Spring Boot Project

This is a simple REST API project using Spring Boot with basic security, Hibernate ORM, and PostgreSQL. It is designed to help you learn these technologies.

## Features

- JWT Authentication
- Spring Security
- Hibernate ORM
- PostgreSQL Database
- Dockerized setup

## Prerequisites

- Docker
- Java 21 or later
- Maven

## Setup

1. **Clone the repository**

    ```sh
    git clone https://github.com/Kudoo39/spring-boot
    cd spring-boot
    ```

2. **Create `env.properties` file**

   Create a file named `env.properties` in the `src/main/resources` directory with the following content:

    ```properties
    JWT_SECRET_KEY="secret-key"
    ```

3.  **Adjust `application.properties` file**