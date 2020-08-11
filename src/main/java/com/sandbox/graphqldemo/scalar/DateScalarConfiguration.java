package com.sandbox.graphqldemo.scalar;

import graphql.language.StringValue;
import graphql.schema.Coercing;
import graphql.schema.CoercingParseLiteralException;
import graphql.schema.CoercingParseValueException;
import graphql.schema.CoercingSerializeException;
import graphql.schema.GraphQLScalarType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.DateTimeException;
import java.time.LocalDate;

@Configuration
public class DateScalarConfiguration {

    @Bean
    public GraphQLScalarType dateScalar() {
        return GraphQLScalarType.newScalar()
                .name("Date")
                .description("Java 8 LocalDate as scalar")
                .coercing(new Coercing<LocalDate, String>() {

                    @Override
                    public String serialize(final Object dataFetcherResult) throws CoercingSerializeException {
                        if (dataFetcherResult instanceof LocalDate) {
                            return dataFetcherResult.toString();
                        } else {
                            throw new CoercingSerializeException("Expected a LocalDate object.");
                        }
                    }

                    @Override
                    public LocalDate parseValue(final Object input) throws CoercingParseValueException {
                        try {
                            if (input instanceof LocalDate) {
                                //noinspection ConstantConditions
                                return LocalDate.parse((String) input);
                            } else {
                                throw new CoercingParseValueException("Expected a String");
                            }
                        } catch (DateTimeException e) {
                            throw new CoercingParseValueException(String.format("Not a valid date: '%s'.", input), e);
                        }
                    }

                    @Override
                    public LocalDate parseLiteral(final Object input) throws CoercingParseLiteralException {
                        if (input instanceof StringValue) {
                            try {
                                return LocalDate.parse(((StringValue) input).getValue());
                            } catch (DateTimeException e) {
                                throw new CoercingParseLiteralException(e);
                            }
                        } else {
                            throw new CoercingParseLiteralException("Expected a StringValue.");
                        }
                    }
                }).build();
    }
}
