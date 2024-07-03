package com.sppm.GymManagementSystem.dao;

import java.util.List;

import com.sppm.GymManagementSystem.bean.GymItem;

public interface GymItemDao {
	public void saveNewItem(GymItem gymItem);
	public List<GymItem> displayAllItem();
	public GymItem findItemById(Long id);
	public Long generateItemId();
	public Integer findTotalSeatById(Long id);
}
