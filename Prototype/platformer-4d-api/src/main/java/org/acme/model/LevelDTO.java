package org.acme.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class LevelDTO implements Serializable {
    private final Long id;
    private final String name;
}
