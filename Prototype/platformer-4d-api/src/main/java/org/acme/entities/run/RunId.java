package org.acme.entities.run;

import lombok.Data;
import org.acme.entities.level.Level;
import org.acme.entities.user.Person;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Embeddable
public class RunId implements Serializable {
    long sequence;
    @OneToOne
    @JoinColumn(name = "levelId")
    Level level;
    @ManyToOne
    Person person;
}
