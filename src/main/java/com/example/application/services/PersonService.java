package com.example.application.services;

import com.vaadin.flow.server.auth.AnonymousAllowed;
import com.vaadin.hilla.BrowserCallable;
import com.vaadin.hilla.Nonnull;
import com.vaadin.hilla.signals.ValueSignal;
import jakarta.annotation.security.RolesAllowed;

@BrowserCallable
@AnonymousAllowed
public class PersonService {
    final private ValueSignal<Person> personSignal = new ValueSignal<Person>(new Person("foo", 1999), Person.class);

    public record Person(String name, int birthYear) {

    }
    public ValueSignal<@Nonnull Person> getPersonSignal() {
        return personSignal;
    }
}
