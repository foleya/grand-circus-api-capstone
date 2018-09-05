package co.grandcircus.apicapstone.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EventResults {

	@JsonProperty("_embedded")
	private EventsShell eventsShell;

	public EventsShell getEventsShell() {
		return eventsShell;
	}

	public void setEventsShell(EventsShell eventsShell) {
		this.eventsShell = eventsShell;
	}
	
}
