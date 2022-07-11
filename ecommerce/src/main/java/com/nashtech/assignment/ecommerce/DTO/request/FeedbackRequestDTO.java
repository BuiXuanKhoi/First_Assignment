package com.nashtech.assignment.ecommerce.DTO.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nashtech.assignment.ecommerce.data.entities.Products;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class FeedbackRequestDTO {
	
	@JsonProperty("comment")
	private String feedbackComment;
	
	@JsonProperty("rating")
	private Float feedbackRating;
	

}
