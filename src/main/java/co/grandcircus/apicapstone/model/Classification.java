package co.grandcircus.apicapstone.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Classification {
	
	@JsonProperty("segment")
	private PrimaryCategory primaryCategory;

	@JsonProperty("genre")
	private SubCategory subCategory;

	public PrimaryCategory getPrimaryCategory() {
		return primaryCategory;
	}

	public void setPrimaryCategory(PrimaryCategory primaryCategory) {
		this.primaryCategory = primaryCategory;
	}

	public SubCategory getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(SubCategory subCategory) {
		this.subCategory = subCategory;
	}
	
	
	
}
