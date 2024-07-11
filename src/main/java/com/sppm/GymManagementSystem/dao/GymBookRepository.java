package com.sppm.GymManagementSystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sppm.GymManagementSystem.bean.GymBook;

public interface GymBookRepository extends JpaRepository<GymBook, Long> {
	
	@Query("select max(bookingId) from GymBook")
	public Long findLastBookingById();

}
