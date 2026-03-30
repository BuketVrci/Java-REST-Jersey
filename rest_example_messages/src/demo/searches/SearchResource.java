package demo.searches;

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

@Path("search")
public class SearchResource {
	private static Map<Integer, Search> map;
	private static AtomicInteger counter = new AtomicInteger();
	
	static {
		map = new ConcurrentHashMap<>();
		Instant instant = Instant.now();
		map.put(1, new Search(1, "google", instant));
		map.put(2, new Search(2, "haw-hamburg.de", instant));
		map.put(3, new Search(3, "myhaw.de", instant));
		counter.set(3);
	}

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getAllSearchAsText() {
		StringBuilder stringBuilder = new StringBuilder();
		map.values().stream()
				.sorted((m1, m2) -> -m1.getTimestamp().compareTo(m2.getTimestamp()))
				.forEach(m -> stringBuilder.append(m.toString() + "\n"));
		return stringBuilder.toString();
	}
	@GET
	@Path("{id}")
	@Produces(MediaType.TEXT_PLAIN)
	public Response getSearchesText(@PathParam("id") int id) {
		Search search = map.get(id);
		if (search == null) {
			return Response.noContent().status(Response.Status.NOT_FOUND).build();
		}
		return Response.ok(search.toString()).build();
	}
	
	@DELETE
	@Path("{id}")
	public Response deleteSearch(@PathParam("id") int id) {
		Search delete = map.remove(id);
		if (delete == null) {
			return Response.noContent().status(Response.Status.NOT_FOUND).build();
		}
		return Response.ok(delete.toString()).build();
	}

}
