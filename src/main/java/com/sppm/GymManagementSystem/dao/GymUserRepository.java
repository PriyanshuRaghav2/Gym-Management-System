package com.sppm.GymManagementSystem.dao;

import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;

import com.sppm.GymManagementSystem.bean.GymUser;

public interface GymUserRepository extends JpaRepository<GymUser, String> {
	Optional<GymUser> findByUsername(String username);
}
