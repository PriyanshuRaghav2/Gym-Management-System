package com.sppm.GymManagementSystem.dao;

import java.util.List;

import com.sppm.GymManagementSystem.bean.Feedback;

public interface FeedbackDao {

	public void saveFeedback(Feedback feedback);

	public List<Feedback> getAllFeedbacks();

	public Feedback getFeedbackById(Long id);

	public void deleteFeedback(Long id);
	
	public Long generateFeedbackId();

}
