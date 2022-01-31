package org.acme.entities.run;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import lombok.Data;
import org.acme.entities.level.Level;
import org.acme.entities.speedrun.Speedrun;
import org.acme.entities.speedrun.SpeedrunId;
import org.acme.entities.user.Person;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.time.Duration;

@Data
@Entity
public class Run extends PanacheEntityBase {
    @EmbeddedId
    RunId id;
    Duration duration;
    @ManyToOne
    Speedrun speedrun;

    public static Run create(Person person, Level level, Duration duration) {
        Run run = new Run();
        run.setDuration(duration);

        RunId runId = new RunId();
        runId.setLevel(level);
        runId.setPerson(person);

        run.setId(runId);
        return run;
    }
}
