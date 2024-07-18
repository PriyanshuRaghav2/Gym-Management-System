package com.sppm.GymManagementSystem.bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class GymBook {
    @Id
    private Long bookingId;
    private Long slotId;
    private Long itemId;
    private String userName;

    @Transient
    private GymItem item;

    public Long getBookingId() {
        return bookingId;
    }

    public void setBookingId(Long bookingId) {
        this.bookingId = bookingId;
    }

    public Long getSlotId() {
        return slotId;
    }

    public void setSlotId(Long slotId) {
        this.slotId = slotId;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public GymItem getItem() {
        return item;
    }

    public void setItem(GymItem item) {
        this.item = item;
    }

    public GymBook() {
        super();
    }

    public GymBook(Long bookingId, Long slotId, Long itemId, String userName, GymItem item) {
        super();
        this.bookingId = bookingId;
        this.slotId = slotId;
        this.itemId = itemId;
        this.userName = userName;
        this.item = item;
    }
}
