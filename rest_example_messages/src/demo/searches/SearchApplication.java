package demo.searches;

import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

public class SearchApplication extends Application {
	private Set<Object> singletons = new HashSet<>();
	private Set<Class<?>> classes = new HashSet<>();

	public SearchApplication() {
		singletons.add(new SearchResource());
	}

	@Override
	public Set<Class<?>> getClasses() {
		return classes;
	}

	@Override
	public Set<Object> getSingletons() {
		return singletons;
	}
}
