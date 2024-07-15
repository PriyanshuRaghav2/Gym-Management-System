package com.sppm.GymManagementSystem.dao;

import java.util.List;

import com.sppm.GymManagementSystem.bean.GymBook;


public interface GymBookDao {
	public void save(GymBook gymBook);
	public Long generateBookingId();
	public List<GymBook> getBookList();
	public GymBook findBookInfoById(Long Id);
	public void deleteById(Long Id);
	List<GymBook> getUserNameBookList(String username);
}
