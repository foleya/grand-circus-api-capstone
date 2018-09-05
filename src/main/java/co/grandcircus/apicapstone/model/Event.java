package co.grandcircus.apicapstone.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Event {
	
	private String id;
	private String name;
	private Dates dates;
	private String url;
	
	@JsonProperty("_embedded")
	private VenueShell venueShell;
	
	private List<Classification> classifications;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Dates getDates() {
		return dates;
	}

	public void setDates(Dates dates) {
		this.dates = dates;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public VenueShell getVenueShell() {
		return venueShell;
	}

	public void setVenueShell(VenueShell venueShell) {
		this.venueShell = venueShell;
	}

	public List<Classification> getClassifications() {
		return classifications;
	}

	public void setClassifications(List<Classification> classifications) {
		this.classifications = classifications;
	}
	
}
