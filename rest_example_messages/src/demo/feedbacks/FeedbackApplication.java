package demo.feedbacks;

import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

public class FeedbackApplication extends Application {
	private Set<Object> singletons = new HashSet<>();
	private Set<Class<?>> classes = new HashSet<>();

	public FeedbackApplication() {
		singletons.add(new FeedbackResource());
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
