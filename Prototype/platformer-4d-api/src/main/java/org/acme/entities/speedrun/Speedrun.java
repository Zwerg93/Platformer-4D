package org.acme.entities.speedrun;

import lombok.Data;
import org.acme.entities.run.Run;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Speedrun {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @OneToMany
    List<Run> runs = new ArrayList<>();
    String videoUrl;
    Long levelId;
}
