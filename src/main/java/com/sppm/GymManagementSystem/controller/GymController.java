package com.sppm.GymManagementSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.sppm.GymManagementSystem.bean.GymItem;
import com.sppm.GymManagementSystem.bean.Item;
import com.sppm.GymManagementSystem.bean.Slot;
import com.sppm.GymManagementSystem.bean.SlotItem;
import com.sppm.GymManagementSystem.bean.SlotItemEmbed;
import com.sppm.GymManagementSystem.dao.GymItemDao;
import com.sppm.GymManagementSystem.dao.SlotDao;
import com.sppm.GymManagementSystem.dao.SlotItemDao;
import com.sppm.GymManagementSystem.exception.SeatNotAvailableException;
import com.sppm.GymManagementSystem.service.GymItemService;
import com.sppm.GymManagementSystem.service.GymUserService;


@RestController
public class GymController {
	
	@Autowired
	private GymItemDao gymItemDao;
	
	@Autowired
	private SlotDao slotDao;
	
	@Autowired
	private SlotItemDao slotItemDao;
	
	@Autowired
	private GymItemService itemService;
	
	@Autowired
	private GymUserService userService;
	
	/*---------------------------------------------------------------------*/
	/* Home Page Mapping*/
	@GetMapping("/index")
	public ModelAndView showIndexPage() {
		String indexPage="";
		String userType=userService.getType();
		if(userType.equalsIgnoreCase("Admin"))
			indexPage="AdmIndex";
		else if(userType.equalsIgnoreCase("Customer"))
			indexPage="CusIndex";
			
		return new ModelAndView(indexPage);
	}
	
	/*---------------------------------------------------------------------*/
	/*FeedBack Form page Mapping*/
	
	@GetMapping("/feedback")
	public ModelAndView showQueries() {
		return new ModelAndView("feedback");
	}
	
	/*---------------------------------------------------------------------*/
	/* Gym Service Mappings*/
	
	@GetMapping("/gymServiceEntryPage")
	public ModelAndView showGymServicePage() {
		GymItem gymItem = new GymItem();
		Long newId = gymItemDao.generateItemId();
		gymItem.setItemId(newId);
		ModelAndView mv = new ModelAndView("gymServiceEntryPage");
		mv.addObject("itemRecord",gymItem);
		return mv;
	}
	
	@PostMapping("/gymService")
	public ModelAndView saveGymService(@ModelAttribute("itemRecord") GymItem gymItem) {
		gymItemDao.saveNewItem(gymItem);
		return new ModelAndView("redirect:/index");
	}
	
	@GetMapping("/gymServiceReport")
	public ModelAndView showGymServiceTable() {
		List<GymItem> itemList = gymItemDao.displayAllItem();
		ModelAndView mv = new ModelAndView("gymServiceReport");
		mv.addObject("itemList",itemList);
		return mv;
	}
	
	/*---------------------------------------------------------------------*/
	/* Gym Slot Mappings*/
	
	@GetMapping("/gymSlotEntryPage")
	public ModelAndView showSlotEntryPage() {
		Slot slot = new Slot();
		Long newId = slotDao.generateSlotId();
		slot.setSlotId(newId);
		ModelAndView mv= new ModelAndView("gymSlotEntryPage");
		mv.addObject("itemRecord", slot);
		return mv;
	}
	
	@PostMapping("/gymSlot")
	public ModelAndView saveGymSlot(@ModelAttribute("itemRecord") Slot slot) {
		slotDao.saveNewItem(slot);
		List<GymItem> itemList = gymItemDao.displayAllItem();
		for(GymItem item: itemList) {
			SlotItemEmbed embed = new SlotItemEmbed(slot.getSlotId(), item.getItemId());
			SlotItem slotitem = new SlotItem(embed);
			slotItemDao.save(slotitem);
		}
		return new ModelAndView("redirect:/index");
	}
	
	@GetMapping("/gymSlotReport")
	public ModelAndView showGymSlotTable() {
		List<Slot> slotList = slotDao.displayAllSlot();
		ModelAndView mv = new ModelAndView("gymSlotReport");
		mv.addObject("slotList",slotList);
		return mv;
	}
	
	@GetMapping("/slot-show/{id}")
	public ModelAndView showSlotBookPage(@PathVariable Long id) {
		Slot slot = slotDao.findSlotById(id);
		List<Item> itemList=itemService.getItemList(id);
		ModelAndView mv = new ModelAndView("slotBookingCustomer");
		mv.addObject("slot",slot);
		mv.addObject("itemList", itemList);
		return mv;
	}
	
	@GetMapping("/slot-item-add/{id}")
	public ModelAndView saveItemSlots(@PathVariable Long id) {
		itemService.addNewitemToSlots(id);
		return new ModelAndView("redirect:/index");
	}
	
	@PostMapping("/slot-book")
    public ModelAndView saveSlotBooking(@RequestParam("slotId") Long slotId, @RequestParam("itemId") Long itemId) {
		GymItem gymItem=gymItemDao.findItemById(itemId);
        SlotItemEmbed embed = new SlotItemEmbed(slotId, itemId);
        int totalSeat = gymItem.getTotalSeat();
        SlotItem slotItem = slotItemDao.findById(embed);
        int seatBooked = slotItemDao.findSeatBookedById(embed);
        int available = totalSeat - seatBooked;
        
        if(available>0) {
        	seatBooked++;
        	slotItem.setSeatBooked(seatBooked);
        	slotItemDao.save(slotItem);
        }
        else
        	throw new SeatNotAvailableException();
        
        return new ModelAndView("redirect:/index");
    }
	
	@GetMapping("/slot-book/{id}")
	public ModelAndView showSlotBooking(@PathVariable Long id) {
		String fname="";
		String userType=userService.getType();
		if(userType.equalsIgnoreCase("Admin")) {
			fname="slotBookingAdmin";
		}
		else if(userType.equalsIgnoreCase("Customer")) {
			fname="slotBookingCustomer";
		}
		Slot slot=slotDao.findSlotById(id);
		List<Item> itemList=itemService.getItemList(id);
		ModelAndView mv=new ModelAndView(fname);
		mv.addObject("slot", slot);
		mv.addObject("itemList", itemList);
		if(userType.equalsIgnoreCase("Admin")) {
			List<String> userList=userService.getAllCustomer();
			mv.addObject("userList", userList);
		}
		
		return mv;
	}
	
}
