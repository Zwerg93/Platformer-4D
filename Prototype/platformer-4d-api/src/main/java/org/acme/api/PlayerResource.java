package org.acme.api;

import org.acme.entities.level.Level;
import org.acme.entities.level.LevelService;
import org.acme.entities.run.RunService;
import org.acme.entities.user.Person;
import org.acme.entities.user.PersonService;
import org.acme.model.RunDTO;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.time.Duration;

@Path("player")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PlayerResource {
    @Inject
    RunService runService;
    @Inject
    PersonService personService;
    @Inject
    LevelService levelService;

    @Transactional
    @POST
    @Path("finishedLevel")
    public Response finishedLevel(
            RunDTO runDTO
    ){
        Person person = personService.getById(runDTO.getIdPersonName());
        Level level = levelService.getById(runDTO.getIdLevelId());

        if (person == null || level == null){
            return Response.status(404).build();
        }

        runService.create(person, level, runDTO.getDuration());

        return Response.ok().build();
    }
}
