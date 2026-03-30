package demo.feedbacks;

import java.time.Instant;

public class Feedback {
	private int id;
	private int rating;
	private String comment;
	private Instant timestamp;

	public Feedback() {
	}

	public Feedback(int id, int rating, String comment, Instant timestamp) {
		this.id = id;
		this.rating = rating;
		this.comment = comment;
		this.timestamp = timestamp;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Instant getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Instant timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public String toString() {
		return "Feedback [id=" + id + ", rating=" + rating + ", comment=" + comment + ", timestamp=" + timestamp + "]";
	}
}
