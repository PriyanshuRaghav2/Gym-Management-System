package com.sppm.GymManagementSystem.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.sppm.GymManagementSystem.bean.GymItem;

@Repository
@Service
public  class GymItemDaoImpl implements GymItemDao {

	@Autowired
	private GymItemRepository repository;
	
	@Override
	public void saveNewItem(GymItem gymItem) {
		repository.save(gymItem);	
	}

	@Override
	public List<GymItem> displayAllItem() {
		return repository.findAll();
	}

	@Override
	public GymItem findItemById(Long id) {
		return repository.findById(id).get();
	}
	
	@Override
	public Long generateItemId() {
		Long val=repository.findLastItemId();
		if(val==null)
			val=101L;
		else
			val+=1;
		
		return val;
	}
	
	@Override
	public Integer findTotalSeatById(Long id){
		return repository.findTotalSeatById(id);
	}
}
