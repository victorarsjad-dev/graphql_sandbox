package com.sandbox.graphqldemo.query;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.sandbox.graphqldemo.models.Person;
import com.sandbox.graphqldemo.service.PersonService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Collection;

@Service
public class CreatePersonMutationResolver implements GraphQLMutationResolver {

    private final PersonService personService;

    public CreatePersonMutationResolver(final PersonService personService) {
        this.personService = personService;
    }

    public Person createPerson(final String firstName, final String lastName, final LocalDate dateOfBirth) {
        return personService.createPerson(firstName, lastName, dateOfBirth);
    }
}
