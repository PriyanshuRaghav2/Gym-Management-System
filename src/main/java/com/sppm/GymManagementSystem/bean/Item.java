package com.sppm.GymManagementSystem.bean;

public class Item {
	private Long itemId;
	private String itemName;
	private Integer totalSeat;
	private Integer seatVacent;
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
	public Integer getSeatVacent() {
		return seatVacent;
	}
	public void setSeatVacent(Integer seatVacent) {
		this.seatVacent = seatVacent;
	}
	public Item() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Item(Long itemId, String itemName, Integer totalSeat, Integer seatVacent) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.totalSeat = totalSeat;
		this.seatVacent = seatVacent;
	}
	public Item(GymItem gym) {
		super();
		this.itemId = gym.getItemId();
		this.itemName = gym.getItemName();
		this.totalSeat = gym.getTotalSeat();
		this.seatVacent = 0;
	}

}
