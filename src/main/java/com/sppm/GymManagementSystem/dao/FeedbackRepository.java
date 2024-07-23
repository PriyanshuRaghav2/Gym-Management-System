package com.sppm.GymManagementSystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sppm.GymManagementSystem.bean.Feedback;

public interface FeedbackRepository extends JpaRepository<Feedback, Long> {

	@Query("select max(feedbackId) from Feedback")
	Long findLastFeedbackId();


}
