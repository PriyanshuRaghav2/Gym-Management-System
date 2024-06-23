package com.sppm.GymManagementSystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sppm.GymManagementSystem.bean.GymItem;

public interface GymItemRepository extends JpaRepository<GymItem, Long> {

	@Query("select max(itemId) from GymItem")
	public Long findLastItemId();
}