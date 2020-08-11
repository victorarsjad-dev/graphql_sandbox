package com.sandbox.graphqldemo.query;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.sandbox.graphqldemo.models.Person;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
class HelloQueryResolver implements GraphQLQueryResolver {

    public String hello(final String who) {
        return String.format("Hello %s, welcome to GraphQL demo!", Optional.ofNullable(who).orElse("user"));
    }
}
