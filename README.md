# Learn GraphQL integration with Spring Boot

### Reference Documentation
For further reference, please consider the following sections:

* [Medium - GraphQL Server Using Spring Boot, Part I](https://medium.com/supercharges-mobile-product-guide/graphql-server-using-spring-boot-part-i-722bdd715779)
* [Medium - GraphQL Server Using Spring Boot, Part II — Scalars](https://medium.com/supercharges-mobile-product-guide/graphql-server-using-spring-boot-part-ii-scalars-31505fe90c4c)

### How to run
These steps below should help you run this application on local:

* Clone this repository to your local.
* Build the project, note that this might take a while (also make sure you have configured Lombok plugin).
* After run succeed, go to http://localhost:8080/graphiql.
* Use the documentation explorer to help you navigate the schema.

### Sample Queries

Create Person

```$xslt
mutation {
  createPerson(
    firstName: "John",
  	lastName: "Doe"
  ) {
    id
    firstName
    lastName
    fullName
  }
}
```

Get People

```query {
     people {
       firstName
       lastName
     }
   }
```

_Have fun!_