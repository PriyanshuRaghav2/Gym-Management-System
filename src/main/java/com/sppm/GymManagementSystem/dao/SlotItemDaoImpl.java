package com.sppm.GymManagementSystem.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.sppm.GymManagementSystem.bean.SlotItem;

@Service
@Repository
public class SlotItemDaoImpl implements SlotItemDao {

	@Autowired
	private SlotItemRepository repository;
	
	@Override
	public void save(SlotItem slotitem) {
		repository.save(slotitem);
	}
}
