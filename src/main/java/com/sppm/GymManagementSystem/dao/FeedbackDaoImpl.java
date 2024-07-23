package com.sppm.GymManagementSystem.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.sppm.GymManagementSystem.bean.Feedback;

@Service
@Repository
public class FeedbackDaoImpl implements FeedbackDao {

	@Autowired
	private FeedbackRepository repository;

	@Override
	public void saveFeedback(Feedback feedback) {
		repository.save(feedback);
	}

	@Override
	public List<Feedback> getAllFeedbacks() {
		return repository.findAll();
	}

	@Override
	public Feedback getFeedbackById(Long id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	public void deleteFeedback(Long id) {
		repository.deleteById(id);
	}

	@Override
	public Long generateFeedbackId() {
		Long newId = repository.findLastFeedbackId();
		if(newId == null)
			newId = 101L;
		else
			newId += 1L;
		return newId;
	}

}
