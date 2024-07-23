package com.sppm.GymManagementSystem.bean;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.validation.constraints.NotEmpty;

@Entity
public class Feedback {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long feedbackId;
	@NotEmpty
	private String username;
	@Lob
	@NotEmpty
	private String feedbackContent;
	private LocalDateTime timestamp;
	
	public Feedback() {
		super();
		
	}

	public Feedback(Long feedbackId, String username, String feedbackContent, LocalDateTime timestamp) {
		super();
		this.feedbackId = feedbackId;
		this.username = username;
		this.feedbackContent = feedbackContent;
		this.timestamp = timestamp;
	}

	public Long getFeedbackId() {
		return feedbackId;
	}

	public void setFeedbackId(Long feedbackId) {
		this.feedbackId = feedbackId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFeedbackContent() {
		return feedbackContent;
	}

	public void setFeedbackContent(String feedbackContent) {
		this.feedbackContent = feedbackContent;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
	
	

}
