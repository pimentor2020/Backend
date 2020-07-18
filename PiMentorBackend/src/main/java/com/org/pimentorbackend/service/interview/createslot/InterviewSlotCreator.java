package com.org.pimentorbackend.service.interview.createslot;

import com.org.pimentorbackend.beans.Interviewer;

/*InterviewSlots will be created when one or more Interviwers 
 * are available for taking 
 * Interview */
public interface InterviewSlotCreator {
	public void checkSlot(Interviewer i, String date, String startTime, String endTime);
}
