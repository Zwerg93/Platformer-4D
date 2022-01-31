package org.acme.entities.run;

import org.acme.entities.level.Level;
import org.acme.entities.user.Person;

import java.time.Duration;

public interface RunService {

    void create(Person person, Level level, Duration duration);
}
