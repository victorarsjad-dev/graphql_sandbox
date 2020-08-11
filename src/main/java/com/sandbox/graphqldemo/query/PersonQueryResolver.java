package com.sandbox.graphqldemo.query;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.fasterxml.jackson.databind.jsonschema.JsonSerializableSchema;
import com.sandbox.graphqldemo.models.Person;
import com.sandbox.graphqldemo.service.PersonService;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class PersonQueryResolver implements GraphQLQueryResolver {

    private final PersonService personService;

    public PersonQueryResolver(final PersonService personService) {
        this.personService = personService;
    }

    public Collection<Person> people() {
        return personService.getPeople();
    }
}
