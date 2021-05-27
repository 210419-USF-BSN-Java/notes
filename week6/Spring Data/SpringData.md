# Spring Data / JPA Notes

## What is Spring Data?

### Spring Data is not a core spring frameworks

### It is family of frameworks for ORM and data persistance whos main purpose is abstract away required for data storage. Allows us to focus on business logic

We are specifically learning Spring Data JPA

It essentially abstracts away the use of hibernate and SpringORM, simplifying your Data Access Layer and providing standard implementations for common DAO methods

This means you no longer have to implement these, they are simply provided for you extending the JpaRepository

When you extend JpaRepository Spring will automatically create an implementation for youe DAO, include CRUD for standard data access, as custom queries based off of method signatures.

## Spring Data JPA Interface Hieracrchy

![JPA Repository](springdatajrepositories.png)

## Spring Data JPA Features

-   Building sophisicated repositories based on Spring and JPA
-   Support for QueryDSL predicates and type-safe JPA queries
    -   This is less importatant/probably won't use it. But, QueryDSL is a framework which enables statically typed SQL-like queries instead of requiring inline string queries or XML.
-   Transparent auditing of Domain classes
-   Pagination support
-   Dynamic Query Execution
-   Support for integration of custom data access code
-   Automatic custom queries
-   Valididation of @Query annotated queries during bootstrapping
-   Support of XML based entity mapping
-   JavaCongig based repository configuration by introducing `@EnableJpaRepositories`

## Spring Data JPA Methods

-   Comes with predefined methods

    -   https://docs.spring.io/spring-data/jpa/docs/current/api/org/springframework/data/jpa/repository/JpaRepository.html
    -   Primarily CRUD operations

-   You also create custom method signatures to find almost anything you want:

    -   https://docs.spring.io/spring-data/jpa/docs/1.5.0.RELEASE/reference/html/jpa.repositories.html
    -   Take a look at table 2.3 in about linkg for above examples
    -   When Spring Data crates a new Repository Implementation, it ananlyses all of the methods defined in the interfaces, and attempts to automatically generate queries from method names. It has limitations, but it is also very powerful and elegant way of defining new custom access methods with very little effort.

-   You can also use @Query to write JPA queries, and use QueryDSL as stated above
    -   You may end using the @Query annotations on rare occasions

## Spring Data Annotations

A quick run down of the different Spring Data Annotations

| Annotation                      | Purpose                                                                                   |
| ------------------------------- | ----------------------------------------------------------------------------------------- |
| @Transactional                  | Configure how the database transaction behaves (Kevin will cover this next)               |
| @NoRepositoryBean               | Creates an interface that provides common methods for child repositories                  |
| @Param                          | Parameters can be passed to queries defined with @Query                                   |
| @Transient                      | Mark a field as transient, to be ignored by the data store engine during reads and writes |
| @CreatedBy, @LastModifiedBy     | Auditing annotations that will automatically be filled with the current principal         |
| @CreatedDate, @LastModifiedDate | Auditing annotations that will automatically fill with current date                       |
| @Query                          | Supply a JPQL query for repository methods                                                |
