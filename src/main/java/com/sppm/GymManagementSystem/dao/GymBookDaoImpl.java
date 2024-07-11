package com.sppm.GymManagementSystem.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.sppm.GymManagementSystem.bean.GymBook;
@Service
@Repository
public class GymBookDaoImpl implements GymBookDao {
	
	@Autowired
	private GymBookRepository repository;
	
	@Override
	public void save(GymBook gymBook) {
		repository.save(gymBook);
	}

	@Override
	public List<GymBook> getBookList() {
		return repository.findAll();
	}

	@Override
	public GymBook findBookInfoById(Long id) {
		return repository.findById(id).get();
	}

	@Override
	public Long generateBookingId() {
		Long newId=repository.findLastBookingById();
		if(newId==null)
		{
			newId=1000001L;
		}
		else {
			newId=newId+1L;
		}
		return newId;
	}

	@Override
	public void deleteById(Long id) {
		repository.deleteById(id);
	}
}