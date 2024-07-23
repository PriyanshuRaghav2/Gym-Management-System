package com.sppm.GymManagementSystem.dao;

import java.util.List;
import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sppm.GymManagementSystem.bean.GymUser;

public interface GymUserRepository extends JpaRepository<GymUser, String> {
	Optional<GymUser> findByUsername(String username);

	@Query("SELECT g FROM GymUser g WHERE g.type = 'customer'")
	public List<GymUser> findAllCoustomerUsers();
}
