package com.sppm.GymManagementSystem.bean;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@Embeddable
public class SlotItemEmbed implements Serializable{
	@NotNull
	private Long slotId;
	@NotNull 
	private Long itemId;
	
	public SlotItemEmbed() {
		super();
	}

	public SlotItemEmbed(@NotNull Long slotId, @NotNull Long itemId) {
		super();
		this.slotId = slotId;
		this.itemId = itemId;
	}

	@Override
	public int hashCode() {
		String ss=""+slotId+itemId;
		int val=Integer.parseInt(ss);
		return val;
	}

	@Override
	public boolean equals(Object obj) {
		
		SlotItemEmbed other = (SlotItemEmbed) obj;
		if(this.hashCode()==other.hashCode())
			return true;
		else
			return false;
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
	
	
	
}
