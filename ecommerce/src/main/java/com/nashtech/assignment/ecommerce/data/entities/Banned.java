package com.nashtech.assignment.ecommerce.data.entities;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "banned")
public class Banned {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "banned_id")
	private int bannedId;
	
	@OneToOne
	@JoinColumn(name = "user_id")
	private Users users;
	
	@Column(name = "unban_code")
	private String unbanCode;
	
	@Column(name = "banReason")
	private String banReason;
	
	@Column(name = "explain_ban")
	private String explainBan;

}
