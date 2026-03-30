package demo.feedbacks;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import demo.messages.Message;

import java.net.URI;
import java.time.Instant;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Path("feedback")
public class FeedbackResource {
	private static Map<Integer, Feedback> map;
	private static AtomicInteger counter = new AtomicInteger();
	
	static {
		map = new ConcurrentHashMap<>();
		Instant instant = Instant.now();
		map.put(1, new Feedback(1, 5, "It sucks!", instant));
		map.put(2, new Feedback(2, 0, "It sucks a lot!", instant.plusSeconds(1)));
		map.put(3, new Feedback(3, 10, "Cooool!", instant.plusSeconds(2)));
		counter.set(3);
	}

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getAllFeedbacksAsText() {
		StringBuilder stringBuilder = new StringBuilder();
		map.values().stream()
				.sorted((m1, m2) -> -m1.getTimestamp().compareTo(m2.getTimestamp()))
				.forEach(m -> stringBuilder.append(m.toString() + "\n"));
		return stringBuilder.toString();
	}

	@GET
	@Path("{id}")
	@Produces(MediaType.TEXT_PLAIN)
	public Response getFeedbackAsText(@PathParam("id") int id) {
		Feedback feedback = map.get(id);
		if (feedback == null) {
			return Response.noContent().status(Response.Status.NOT_FOUND).build();
		}
		return Response.ok(feedback.toString()).build();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response newFeedback(@Context UriInfo uriInfo, Feedback feedback) {
		int id = counter.incrementAndGet();
		feedback.setId(id);
		feedback.setTimestamp(Instant.now());
		map.put(id, feedback);
		URI location = uriInfo.getAbsolutePathBuilder().path(String.valueOf(id)).build();
		return Response.created(location).build();
	}
}
