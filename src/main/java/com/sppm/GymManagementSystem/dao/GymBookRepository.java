package com.sppm.GymManagementSystem.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sppm.GymManagementSystem.bean.GymBook;


public interface GymBookRepository extends JpaRepository<GymBook, Long> {
	
	@Query("select max(bookingId) from GymBook")
	public Long findLastBookingById();
	
	@Query(value = "SELECT * FROM gym_book WHERE user_name = ?1", nativeQuery = true)
	List<GymBook> findBookListByUserName(String username);


}
