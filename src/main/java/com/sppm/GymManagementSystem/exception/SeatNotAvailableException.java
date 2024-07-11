package com.sppm.GymManagementSystem.exception;

public class SeatNotAvailableException extends RuntimeException {
	
	public SeatNotAvailableException() {
        super("No seats available for the selected slot and item.");
    }

}
