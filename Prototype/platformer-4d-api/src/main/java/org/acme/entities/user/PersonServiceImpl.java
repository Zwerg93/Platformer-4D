package org.acme.entities.user;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PersonServiceImpl implements PersonService {
    @Override
    public Person getById(String personName) {
        return Person.findById(personName);
    }
}
