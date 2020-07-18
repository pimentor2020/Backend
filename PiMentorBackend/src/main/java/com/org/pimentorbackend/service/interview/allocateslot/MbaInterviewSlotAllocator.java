package com.org.pimentorbackend.service.interview.allocateslot;

import javax.inject.Singleton;

import org.springframework.stereotype.Component;

import com.org.pimentorbackend.beans.Aspirant;
import com.org.pimentorbackend.beans.TimeSlot;
import com.org.pimentorbackend.util.PimentorConstants;

@Singleton
@Component
public class MbaInterviewSlotAllocator implements InterviewSlotAllocator {

	private final String interviewType = PimentorConstants.INTERVIEWTYPE_MBA_ENTRANCE;
	@Override
	public synchronized String alloCateSlot(Aspirant aspirant, String date, 
												String startTime, String endTime) {
		TimeSlot timeSlot = checkSlotExists(date, startTime, endTime);
		if(timeSlot!=null) {
			if(timeSlot.getNumberOfSlotsOpen()==0) {
				return PimentorConstants.SLOT_ALL_BOOKED;
			}else if(timeSlot.getNumberOfSlotsOpen()>0) {
				return String.valueOf(bookSlot(aspirant, date, startTime, endTime));
			}
		}
		return PimentorConstants.SLOT_NOT_CREATED;
	}
	
	private boolean bookSlot(Aspirant aspirant, String date, 
						String startTime, String endTime) {
		//TODO trigger email to both aspirant and interviewer,
		//once Successful.
		return false;
	}
	
	private TimeSlot checkSlotExists(String date, String startTime, String endTime) {
		//getInterViewSlot from DB;
		TimeSlot timeSlot = null;// interViewSlotDao.getInterviewSlots();
		return timeSlot;
	}
}
