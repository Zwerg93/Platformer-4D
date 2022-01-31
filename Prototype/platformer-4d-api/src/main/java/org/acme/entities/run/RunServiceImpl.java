package org.acme.entities.run;

import org.acme.entities.level.Level;
import org.acme.entities.user.Person;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.time.Duration;


@ApplicationScoped
public class RunServiceImpl implements RunService {
    @Inject
    RunRepo runRepo;

    @Override
    public void create(Person person, Level level, Duration duration) {
        Run run = Run.create(person, level, duration);
        runRepo.add(run);
    }
}
