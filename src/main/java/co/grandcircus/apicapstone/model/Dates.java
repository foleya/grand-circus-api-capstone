package co.grandcircus.apicapstone.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Dates {
	
	@JsonProperty("start")
	private DateShell dateShell;

	public DateShell getDateShell() {
		return dateShell;
	}

	public void setDateShell(DateShell dateShell) {
		this.dateShell = dateShell;
	}

}
