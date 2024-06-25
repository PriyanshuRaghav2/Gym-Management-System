package com.sppm.GymManagementSystem.dao;

import java.util.List;

import com.sppm.GymManagementSystem.bean.Slot;

public interface SlotDao {
	public void saveNewItem(Slot slot);
	public List<Slot> displayAllSlot();
	public Slot findSlotById(Long id);
	public Long generateSlotId();
}
