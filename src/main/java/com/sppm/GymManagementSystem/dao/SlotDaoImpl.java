package com.sppm.GymManagementSystem.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.sppm.GymManagementSystem.bean.Slot;


@Repository
@Service
public class SlotDaoImpl implements SlotDao {

	@Autowired
	private SlotRepository repository;
	
	@Override
	public void saveNewItem(Slot slot) {
		repository.save(slot);
	}

	@Override
	public List<Slot> displayAllSlot() {
		return repository.findAll();
	}

	@Override
	public Slot findSlotById(Long id) {
		return repository.findById(id).get();
	}
	
	@Override
	public Long generateSlotId() {
		Long val=repository.findLastSlotId();
		if(val==null)
			val=1L;
		else
			val+=1;
		
		return val;
	}

}
