# Library API in Spring Boot

A REST API built with Spring Boot around 6 JPA entities, using PostgreSQL.

## Tech stack

- Java 17, built with Maven
- Spring Boot 2.6.3
- Spring Web (REST controllers)
- Spring Data JPA (Hibernate)
- Spring Data REST
- Spring Boot Actuator
- Lombok
- PostgreSQL driver
- Database: PostgreSQL (`librarydb` in `application.properties`)

## Data model

| Entity | Fields |
|---|---|
| `Book` | isbnCode, title, releaseDate, stock, coverImage, summary, type, authors, borrowedBooks |
| `Author` | id, firstName, lastName, birthDate, Nationality, description, photoPath, authorBooks |
| `Member` | id, firstName, lastName, birthDate, email, phoneNumber, photo, endInscriptionDate, type, address … |
| `Return` | id, borrowing, returnDate, description, penalty |
| `Borrowing` | id, loanDate, duration, state, book, member, returnBooks |
| `Address` | id, number, street, city, postalCode, member |

## REST endpoints

Found in the controllers (`BookController`, `MemberController`):

| Method | Path |
|---|---|
| GET | `/books/all` |
| POST | `/books/add` |
| GET | `/books/{isbnCode}` |
| GET | `/books/author` |
| PUT | `/books/{isbnCode}` |
| DELETE | `/books/{isbnCode}` |
| GET | `/books/before` |

## Project structure

- `tn.esb.lmad.library_api`: LibraryApiApplication
- `tn.esb.lmad.library_api.Controllers`: AddressController, AuthorController, BookController, BorrowingController, MemberController, ReturnController
- `tn.esb.lmad.library_api.Domains`: Address, Author, Book, Borrowing, BorrowingId, Member, Return
- `tn.esb.lmad.library_api.Enumerations`: BookType, BorrowingState, InscriptionType
- `tn.esb.lmad.library_api.Repositories`: AddressRepository, AuthorRepository, BookRepository, BorrowingRepository, MemberRepository, ReturnRepository
- `tn.esb.lmad.library_api.Services`: AddressService, AuthorService, BookService, BorrowingService, MemberService, ReturnService
- Tests: 1 test class

## How to run

Requirements: a JDK 17+ and Maven (or the included Maven wrapper).
Create the `librarydb` database and set your own username and password in `src/main/resources/application.properties`.

```bash
./mvnw spring-boot:run
```

The API then listens on `http://localhost:9592`.

---

Author: [Chaouki Bayoudhi](https://github.com/ChaoukiBayoudhi)
