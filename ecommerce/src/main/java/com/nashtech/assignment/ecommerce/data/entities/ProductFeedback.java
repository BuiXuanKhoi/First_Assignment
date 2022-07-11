package com.nashtech.assignment.ecommerce.data.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "product_feedback")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductFeedback {
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "feedback_id")
	@JsonProperty("id")
	private Integer feedbackId;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "product_id")
	private Products product;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private Users users;
	
	
	@Column(name = "feedback_rating")
	@JsonProperty("rating")
	private Float feedbackRating;
	
	@Column(name = "feedback_comment")
	@JsonProperty("comment")
	private String feedbackComment;
	
	@Column(name = "comment_day")
	@JsonProperty("comment at")
	private Date commentDay;
	
	@Column(name = "update_day")
	@JsonProperty("update at")
	private Date updateDay;

}
