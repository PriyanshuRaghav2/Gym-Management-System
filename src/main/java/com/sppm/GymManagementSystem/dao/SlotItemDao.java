package com.sppm.GymManagementSystem.dao;

import java.util.Set;

import com.sppm.GymManagementSystem.bean.SlotItem;
import com.sppm.GymManagementSystem.bean.SlotItemEmbed;

public interface SlotItemDao {
	
	public void save(SlotItem slotitem);
	public Integer findSeatBookedById(SlotItemEmbed id);
	public Set<SlotItemEmbed> findAllEmbed();
}
