package com.sppm.GymManagementSystem.dao;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sppm.GymManagementSystem.bean.SlotItem;
import com.sppm.GymManagementSystem.bean.SlotItemEmbed;

@Service
public class SlotItemDaoImpl implements SlotItemDao {

    @Autowired
    private SlotItemRepository repository;
    
    @Override
    public void save(SlotItem slotitem) {
        repository.save(slotitem);
    }

    @Override
    public Integer findSeatBookedById(SlotItemEmbed id) {
        return repository.findSeatBookedById(id);
    }

    @Override
    public Set<SlotItemEmbed> findAllEmbed() {
        return repository.findAllEmbeds();
    }
}
