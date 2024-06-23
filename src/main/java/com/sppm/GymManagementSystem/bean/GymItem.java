package com.sppm.GymManagementSystem.bean;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class GymItem {
	@Id
	private Long itemId;
	private String itemName;
	private Integer totalSeat;
//  private Integer seatBooked;
	public Long getItemId() {
		return itemId;
	}
	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public Integer getTotalSeat() {
		return totalSeat;
	}
	public void setTotalSeat(Integer totalSeat) {
		this.totalSeat = totalSeat;
	}
	public GymItem() {
		super();
	}
	public GymItem(Long itemId, String itemName, Integer totalSeat) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.totalSeat = totalSeat;
	}
	
}
