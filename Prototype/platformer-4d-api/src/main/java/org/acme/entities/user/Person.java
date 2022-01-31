package org.acme.entities.user;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import lombok.Data;
import org.acme.entities.run.Run;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Person extends PanacheEntityBase {
    @Id
    String name;
    Byte[] password;
    Byte[] salt;
    String email;
    @OneToMany(
            mappedBy = "id.person",
            cascade = CascadeType.ALL
    )
    List<Run> runs = new ArrayList<>();
}
