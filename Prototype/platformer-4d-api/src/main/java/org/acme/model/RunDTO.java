package org.acme.model;

import lombok.Data;

import java.io.Serializable;
import java.time.Duration;

@Data
public class RunDTO implements Serializable {
    private final Long idLevelId;
    private final String idPersonName;
    private final Duration duration;
}
