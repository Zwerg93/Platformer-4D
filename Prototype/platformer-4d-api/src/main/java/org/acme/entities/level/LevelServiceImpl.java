package org.acme.entities.level;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class LevelServiceImpl implements LevelService {
    @Override
    public Level getById(Long levelId) {
        return Level.findById(levelId);
    }
}
