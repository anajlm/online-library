# online-library
Online Library API with Java Spring Boot

## Table of Contents
- [Overview](#overview)
- [Features](#features)
- [Technologies Used](#technologies-used)
- [Technical Implementation](#technical-implementation)
- [Usage](#usage)
- [Dependencies](#dependencies)
- [Contributing](#contributing)
- [License](#license)

## Overview

## Features

## Technologies Used

- Java 17
- Spring Boot
- Spring Data JPA
- Lombok
- PostgreSQL
- Maven


## Technical Implementation

## Usage

Base URL for each request is `https://localhost:8080/online-library/api`, so combine it with one of the following parts.

### User

| Link          | HTTP Method   | Description                                        | 
| ------------- | ------------- | -------------------------------------------------  |
| `/users`      | POST          | Add new user to the database.                      |
| `/users/{id}` | PUT           | Update specific user's (`{id}`) fields.           |
| `/users/{id}` | DELETE        | Delete from the database user with provided `{id}`. |


### Book

| Link          | HTTP Method   | Description                                        | 
| ------------- | ------------- | -------------------------------------------------  |
| `/books`      | GET           | Retrieve the list of all books.                    |
| `/books`      | GET           | Retrieve book by title.                            |
| `/books`      | GET           | Retrieve book by author.                           |
| `/books`      | GET           | Retrieve book by genre.    	                |
| `/books`      | POST          | Add new book to the database.   	                |
| `/books/{id}` | DELETE        | Delete book from the database with provided `{id}`.|


### Borrowed

| Link          | HTTP Method   | Description                                        | 
| ------------- | ------------- | -------------------------------------------------  |
| `/loans`      | GET           | Retrieve the list of all loans.                    |
| `/loans/{userId}`| GET         | Retrieve list of borrowed books that are assigned to the user. |
| `/loans`   | POST         | Add new loan to the database.                          |
| `/loans/{id}`   | DELETE         | Delete loan from the database with provided id. |




## Dependencies 

The project does not have any external dependencies.

## Contributing

If you'd like to contribute to Online Library, please fork the repository, create a new branch, make your changes, and submit a pull request.

## License

This project is licensed under the [MIT License](LICENSE).
