package com.sppm.GymManagementSystem.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sppm.GymManagementSystem.bean.GymItem;
import com.sppm.GymManagementSystem.bean.Item;
import com.sppm.GymManagementSystem.bean.SlotItem;
import com.sppm.GymManagementSystem.bean.SlotItemEmbed;
import com.sppm.GymManagementSystem.dao.GymItemDao;
import com.sppm.GymManagementSystem.dao.SlotItemDao;

@Service
public class GymItemService {
	
	@Autowired
	private GymItemDao gymItemDao;
	
	@Autowired
	private SlotItemDao slotItemDao;
	
	public List<Item> getItemList(Long slotId){
		List<Item> itemList =new ArrayList<>();
		List<GymItem> gymList=gymItemDao.displayAllItem();
		for(GymItem gym: gymList) {
			Item item = new Item();
			SlotItemEmbed embed = new SlotItemEmbed(slotId, gym.getItemId());
			Integer seatBooked=slotItemDao.findSeatBookedById(embed);
			if(seatBooked == null)
				seatBooked = 0;
			int seatVacent=gym.getTotalSeat()-seatBooked.intValue();
			item.setSeatVacent(seatVacent);
			itemList.add(item);
		}
		return itemList;
	}
	
//	public void addNewitemToSlots(Long itemId) {
//		Set<SlotItemEmbed> embedSet=slotItemDao.findAllEmbeds();
//		Map<Long, Long> embedMap=new HashMap<>();
//		for(SlotItemEmbed embed:embedSet) {
//			embedMap.put(embed.getItemId(), embed.getSlotId());
//		}
//		if(embedMap.containsKey(itemId)==false) {
//			Set<Long> itemIdSet=embedMap.keySet();
//			for(Long id:itemIdSet) {
//				Long slotId=embedMap.get(id);
//				SlotItemEmbed embed = new SlotItemEmbed(slotId,itemId);
//				SlotItem slotItem = new SlotItem(embed);
//				slotItemDao.save(slotItem);
//			}
//		}
//	}

}
