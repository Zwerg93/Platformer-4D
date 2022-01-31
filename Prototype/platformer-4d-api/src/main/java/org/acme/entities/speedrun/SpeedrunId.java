package org.acme.entities.speedrun;

import lombok.Data;
import org.acme.entities.run.Run;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Embeddable
public class SpeedrunId implements Serializable {
    @OneToMany(
            mappedBy = "speedrun",
            cascade = CascadeType.REFRESH
    )
    List<Run> runs = new ArrayList<>();
}
