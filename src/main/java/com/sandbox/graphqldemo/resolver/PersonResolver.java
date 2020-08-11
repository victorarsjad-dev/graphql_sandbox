package com.sandbox.graphqldemo.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.sandbox.graphqldemo.models.Person;
import org.springframework.stereotype.Service;

@Service
public class PersonResolver implements GraphQLResolver<Person> {

    public String fullName(final Person person) {
        return person.getFirstName() + " " + person.getLastName();
    }
}
