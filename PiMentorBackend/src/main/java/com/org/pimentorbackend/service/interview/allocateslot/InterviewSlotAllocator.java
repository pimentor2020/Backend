package com.org.pimentorbackend.service.interview.allocateslot;

import com.org.pimentorbackend.beans.Aspirant;

//For Aspirant
public interface InterviewSlotAllocator {
	public String alloCateSlot(Aspirant aspirant, String date, String startTime, String endTime);
}
