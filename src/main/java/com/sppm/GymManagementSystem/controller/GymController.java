package com.sppm.GymManagementSystem.controller;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.sppm.GymManagementSystem.bean.Feedback;
import com.sppm.GymManagementSystem.bean.GymBook;
import com.sppm.GymManagementSystem.bean.GymItem;
import com.sppm.GymManagementSystem.bean.GymUser;
import com.sppm.GymManagementSystem.bean.Item;
import com.sppm.GymManagementSystem.bean.Slot;
import com.sppm.GymManagementSystem.bean.SlotItem;
import com.sppm.GymManagementSystem.bean.SlotItemEmbed;
import com.sppm.GymManagementSystem.dao.FeedbackDao;
import com.sppm.GymManagementSystem.dao.GymBookDao;
import com.sppm.GymManagementSystem.dao.GymItemDao;
import com.sppm.GymManagementSystem.dao.SlotDao;
import com.sppm.GymManagementSystem.dao.SlotItemDao;
import com.sppm.GymManagementSystem.exception.SeatAlreadyBookedException;
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

	@Autowired
	private GymBookDao gymBookDao;

	@Autowired
	private GymUser user;
	
	@Autowired
	private FeedbackDao feedbackDao;

	/*---------------------------------------------------------------------*/
	/* Home Page Mapping */
	@GetMapping("/index")
	public ModelAndView showIndexPage() {
		String indexPage = "";
		String userType = userService.getType();
		if (userType.equalsIgnoreCase("Admin"))
			indexPage = "AdmIndex";
		else if (userType.equalsIgnoreCase("Customer"))
			indexPage = "CusIndex";

		return new ModelAndView(indexPage);
	}

	
	/*---------------------------------------------------------------------*/
	/* Gym Service Mappings */

	@GetMapping("/gymServiceEntryPage")
	public ModelAndView showGymServicePage() {
		GymItem gymItem = new GymItem();
		Long newId = gymItemDao.generateItemId();
		gymItem.setItemId(newId);
		ModelAndView mv = new ModelAndView("gymServiceEntryPage");
		mv.addObject("itemRecord", gymItem);
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
		mv.addObject("itemList", itemList);
		return mv;
	}

	/*---------------------------------------------------------------------*/
	/* Gym Slot Mappings */

	@GetMapping("/gymSlotEntryPage")
	public ModelAndView showSlotEntryPage() {
		Slot slot = new Slot();
		Long newId = slotDao.generateSlotId();
		slot.setSlotId(newId);
		ModelAndView mv = new ModelAndView("gymSlotEntryPage");
		mv.addObject("itemRecord", slot);
		return mv;
	}

	@PostMapping("/gymSlot")
	public ModelAndView saveGymSlot(@ModelAttribute("itemRecord") Slot slot) {
		slotDao.saveNewItem(slot);
		List<GymItem> itemList = gymItemDao.displayAllItem();
		for (GymItem item : itemList) {
			SlotItemEmbed embed = new SlotItemEmbed(slot.getSlotId(), item.getItemId());
			SlotItem slotitem = new SlotItem(embed);
			slotItemDao.save(slotitem);
		}
		return new ModelAndView("redirect:/index");
	}

	@GetMapping("/admin-gymSlotReport")
	public ModelAndView showAdminGymSlotTable() {
		List<Slot> slotList = slotDao.displayAllSlot();
		ModelAndView mv = new ModelAndView("admin-gymSlotReport");
		mv.addObject("slotList", slotList);
		return mv;
	}
	
	@GetMapping("/customer-gymSlotReport")
	public ModelAndView showCustomerGymSlotTable() {
		List<Slot> slotList = slotDao.displayAllSlot();
		ModelAndView mv = new ModelAndView("customer-gymSlotReport");
		mv.addObject("slotList", slotList);
		return mv;
	}

//	@GetMapping("/slot-show/{id}")
//	public ModelAndView showSlotBookPage(@PathVariable Long id) {
//		Slot slot = slotDao.findSlotById(id);
//		List<Item> itemList=itemService.getItemList(id);
//		ModelAndView mv = new ModelAndView("slotBookingCustomer");
//		mv.addObject("slot",slot);
//		mv.addObject("itemList", itemList);
//		return mv;
//	}

	@GetMapping("/slot-item-add/{id}")
	public ModelAndView saveItemSlots(@PathVariable Long id) {
		itemService.addNewitemToSlots(id);
		return new ModelAndView("redirect:/index");
	}

	@PostMapping("/admin-slot-book")
	public ModelAndView saveAdminSlotBooking(@RequestParam("slotId") Long slotId, @RequestParam("itemId") Long itemId,@RequestParam("username") String username,
	        Principal principal) {

	    List<GymBook> bookingList = gymBookDao.getUserNameBookList(username);

	    
	    for (GymBook booking : bookingList) {
	        if (booking.getSlotId().equals(slotId)) {
	            return new ModelAndView("seatAlreadyBooked");
	        }
	    }
	    try {
	        GymItem gymItem = gymItemDao.findItemById(itemId);
	        SlotItemEmbed embed = new SlotItemEmbed(slotId, itemId);
	        int totalSeat = gymItem.getTotalSeat();
	        SlotItem slotItem = slotItemDao.findById(embed);
	        int seatBooked = slotItemDao.findSeatBookedById(embed);
	        int available = totalSeat - seatBooked;

	        if (available > 0) {
	            
	            seatBooked++;
	            slotItem.setSeatBooked(seatBooked);
	            slotItemDao.save(slotItem);
	        } else {
	            
	            throw new SeatNotAvailableException();
	        }

	        
	        GymBook gymBook = new GymBook();
	        Long bookingId = gymBookDao.generateBookingId();
	        gymBook.setBookingId(bookingId);
	        gymBook.setSlotId(slotId);
	        gymBook.setItemId(itemId);
	        gymBook.setUserName(username);
	        gymBookDao.save(gymBook);

	        ModelAndView mv = new ModelAndView("bookingSuccess");
	        Slot slot = slotDao.findSlotById(slotId);
	        GymItem item = gymItemDao.findItemById(itemId);
	        mv.addObject("slot", slot);
	        mv.addObject("item", item);

	        return mv;
	    } catch (SeatNotAvailableException e) {
	        
	        return new ModelAndView("seatNotAvailable");
	    }
	}

	@PostMapping("/slot-book")
	public ModelAndView saveSlotBooking(@RequestParam("slotId") Long slotId, @RequestParam("itemId") Long itemId,
	        Principal principal) {

		String username= userService.getUser().getUsername();
	    List<GymBook> bookingList = gymBookDao.getUserNameBookList(username);

	    
	    for (GymBook booking : bookingList) {
	        if (booking.getSlotId().equals(slotId)) {
	            return new ModelAndView("seatAlreadyBooked");
	        }
	    }
	    try {
	        GymItem gymItem = gymItemDao.findItemById(itemId);
	        SlotItemEmbed embed = new SlotItemEmbed(slotId, itemId);
	        int totalSeat = gymItem.getTotalSeat();
	        SlotItem slotItem = slotItemDao.findById(embed);
	        int seatBooked = slotItemDao.findSeatBookedById(embed);
	        int available = totalSeat - seatBooked;

	        if (available > 0) {
	            
	            seatBooked++;
	            slotItem.setSeatBooked(seatBooked);
	            slotItemDao.save(slotItem);
	        } else {
	            
	            throw new SeatNotAvailableException();
	        }

	        
	        GymBook gymBook = new GymBook();
	        Long bookingId = gymBookDao.generateBookingId();
	        gymBook.setBookingId(bookingId);
	        gymBook.setSlotId(slotId);
	        gymBook.setItemId(itemId);
	        gymBook.setUserName(username);
	        gymBookDao.save(gymBook);

	        ModelAndView mv = new ModelAndView("bookingSuccess");
	        Slot slot = slotDao.findSlotById(slotId);
	        GymItem item = gymItemDao.findItemById(itemId);
	        mv.addObject("slot", slot);
	        mv.addObject("item", item);

	        return mv;
	    } catch (SeatNotAvailableException e) {
	        
	        return new ModelAndView("seatNotAvailable");
	    }
	}

	@GetMapping("/slot-book/{id}")
	public ModelAndView showSlotBooking(@PathVariable Long id) {
		String fname = "";
		String userType = userService.getType();
		if (userType.equalsIgnoreCase("Admin")) {
			fname = "slotBookingAdmin";
		} else if (userType.equalsIgnoreCase("Customer")) {
			fname = "slotBookingCustomer";
		}
		Slot slot = slotDao.findSlotById(id);
		List<Item> itemList = itemService.getItemList(id);
		ModelAndView mv = new ModelAndView(fname);
		mv.addObject("slot", slot);
		mv.addObject("itemList", itemList);
		if (userType.equalsIgnoreCase("Admin")) {
			List<GymUser> userList = userService.getAllCustomer();
			mv.addObject("userList", userList);
		}

		return mv;
	}

	@GetMapping("/adminBookingDetails")
	public ModelAndView showAdminBookingDetails(Principal principal) {
		List<GymBook> bookingList = gymBookDao.getBookList();

		ModelAndView mv = new ModelAndView("adminBookingDetails");
		mv.addObject("bookingList", bookingList);

		return mv;
	}

	@GetMapping("/customerBooking")
	public ModelAndView showMyBookings(Principal principal) {
		String username = principal.getName();
		List<GymBook> bookingList = gymBookDao.getUserNameBookList(username);

		for (GymBook booking : bookingList) {
			GymItem item = gymItemDao.findItemById(booking.getItemId());
			booking.setItem(item);
		}

		ModelAndView mv = new ModelAndView("customerBooking");
		mv.addObject("bookingList", bookingList);

		return mv;
	}

	@GetMapping("/cancel-booking/{id}")
	public ModelAndView deleteCustomerBooking(@PathVariable Long id) {
		GymBook booking = gymBookDao.findBookInfoById(id);
		String username=userService.getUser().getUsername();

			SlotItemEmbed embed = new SlotItemEmbed(booking.getSlotId(), booking.getItemId());
			SlotItem slotItem = slotItemDao.findById(embed);

			if (slotItem != null && slotItem.getSeatBooked() > 0) {
				slotItem.setSeatBooked(slotItem.getSeatBooked() - 1);
				slotItemDao.save(slotItem);
			}

			gymBookDao.deleteById(id);


		return new ModelAndView("redirect:/customerBooking");
	}

	@GetMapping("/delete-booking/{id}")
	public ModelAndView deleteBooking(@PathVariable Long id) {
		GymBook booking = gymBookDao.findBookInfoById(id);

		if (booking != null) {
			SlotItemEmbed embed = new SlotItemEmbed(booking.getSlotId(), booking.getItemId());
			SlotItem slotItem = slotItemDao.findById(embed);

			if (slotItem != null && slotItem.getSeatBooked() > 0) {
				slotItem.setSeatBooked(slotItem.getSeatBooked() - 1);
				slotItemDao.save(slotItem);
			}

			gymBookDao.deleteById(id);
		}

		return new ModelAndView("redirect:/adminBookingDetails");
	}
	
	 @GetMapping("/updateGymItem/{id}")
	    public ModelAndView showUpdateGymItemPage(@PathVariable("id") Long id) {
	        GymItem gymItem = gymItemDao.findItemById(id);
	            ModelAndView mv = new ModelAndView("updateGymItem");
	            mv.addObject("gymItem", gymItem);
	            return mv;
	    }

    @PostMapping("/updateGymItem")
    public ModelAndView updateGymItem(@RequestParam("itemId") Long itemId,
                                      @RequestParam("itemName") String itemName,
                                      @RequestParam("totalSeat") int totalSeat) {
        GymItem gymItem = gymItemDao.findItemById(itemId);
        if (gymItem != null) {
            gymItem.setItemName(itemName);
            gymItem.setTotalSeat(totalSeat);
            gymItemDao.saveNewItem(gymItem);
        }
        return new ModelAndView("redirect:/gymServiceReport");
    }
    
    
    @GetMapping("/slot-update/{id}")
    public ModelAndView showUpdateSlotItemPage(@PathVariable("id") Long id) {
    	Slot slot = slotDao.findSlotById(id);
    	ModelAndView mv = new ModelAndView("updateSlot");
    	mv.addObject("itemRecord", slot);
    	return mv;
    }
   
    
    @PostMapping("/slot-update")
    public ModelAndView updateSlotPage(@RequestParam("slotTime") String slotTime,
    								   @RequestParam("pricing") Double pricing,
    								   @RequestParam("slotId") Long slotId){
		
    	Slot slot = slotDao.findSlotById(slotId);
    	if(slot != null) {
    		slot.setSlotTime(slotTime);
    		slot.setPricing(pricing);
    		slotDao.saveNewItem(slot);
    	}
    	
    	return new ModelAndView("redirect:/admin-gymSlotReport");
    }
    	
    	/*---------------------------------------------------------------------*/
    	/* FeedBack Form page Mapping */

    	@GetMapping("/feedback")
        public ModelAndView showFeedbackForm() {
            return new ModelAndView("feedback");
        }

        @PostMapping("/feedback")
        public ModelAndView submitFeedback(@ModelAttribute Feedback feedback, @RequestParam("username") String username,@RequestParam("feedbackContent") String feedbackContent) {
        	feedback.setTimestamp(LocalDateTime.now());
        	feedbackDao.saveFeedback(feedback);
            return new ModelAndView("thankyou");
        }
        
        @GetMapping("/Feedback-Details")
        public ModelAndView showFeedbackDetails() {
            List<Feedback> feedbackList = feedbackDao.getAllFeedbacks();
            System.out.println("Feedback List: " + feedbackList);
            ModelAndView mv = new ModelAndView("Feedback-Details");
            mv.addObject("feedbackList", feedbackList);
            return mv;
        }

        /*------------------------------------------------------------------------------------------*/
        
        @GetMapping("/customer-details")
        public ModelAndView showCustomerDetails() {
            List<GymUser> userList = userService.getAllCustomer();
            System.out.println("User List: " + userList);
            ModelAndView mv = new ModelAndView("Customer-Details");
            mv.addObject("userList", userList);
            return mv;
        }
        
        @GetMapping("/deleteCustomer/{username}")
        public ModelAndView deleteCustomer(@PathVariable("username") String username) {
            System.out.println("Deleting user: " + username);
            userService.deleteUserById(username);
            return new ModelAndView("redirect:/customer-details");
        }
}
