package com.sppm.GymManagementSystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sppm.GymManagementSystem.bean.SlotItem;
import com.sppm.GymManagementSystem.bean.SlotItemEmbed;

public interface SlotItemRepository extends JpaRepository<SlotItem, SlotItemEmbed> {

}
