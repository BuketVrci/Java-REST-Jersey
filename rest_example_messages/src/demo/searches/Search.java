package demo.searches;

import java.time.Instant;

public class Search {
	private int userID;
	private String queryText;
	private Instant timestamp;

	public Search() {
	}

	public Search(int userID, String queryText, Instant timestamp) {
		this.userID = userID;
		this.queryText = queryText;
		this.timestamp = timestamp;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getQueryText() {
		return queryText;
	}

	public void setQueryText(String queryText) {
		this.queryText = queryText;
	}

	public Instant getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Instant timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public String toString() {
		return "Search [userID=" + userID + ", queryText=" + queryText + ", timestamp=" + timestamp + "]";
	}


}
