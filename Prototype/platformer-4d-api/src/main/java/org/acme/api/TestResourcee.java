package org.acme.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.sse.OutboundSseEvent;
import javax.ws.rs.sse.Sse;
import javax.ws.rs.sse.SseEventSink;
import java.util.concurrent.ExecutorService;

@Path("test")
public class TestResourcee {
    @Path("sse")
    @GET
    @Produces(MediaType.SERVER_SENT_EVENTS)
    public void startDomain(@Context SseEventSink eventSink, @Context Sse sse){
        try(SseEventSink sink = eventSink){
            sink.send(sse.newEvent("data"));
            sink.send(sse.newEvent("MyEventName", "more data"));

            OutboundSseEvent event = sse.newEventBuilder()
                    .id("EventId")
                    .name("EventName")
                    .data("Data")
                    .reconnectDelay(1000)
                    .comment("Anything i wanna come here!")
                    .build();

            sink.send(event);
        }
    }
}
