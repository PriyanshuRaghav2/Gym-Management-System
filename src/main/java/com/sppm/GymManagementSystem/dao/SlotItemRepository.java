package com.sppm.GymManagementSystem.dao;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sppm.GymManagementSystem.bean.SlotItem;
import com.sppm.GymManagementSystem.bean.SlotItemEmbed;

public interface SlotItemRepository extends JpaRepository<SlotItem, SlotItemEmbed> {

    @Query("SELECT a.seatBooked FROM SlotItem a WHERE a.embeddedId = ?1")
    public Integer findSeatBookedById(SlotItemEmbed id);
    
    @Query("SELECT a.embeddedId FROM SlotItem a")
    public Set<SlotItemEmbed> findAllEmbeds();
    
    
}
