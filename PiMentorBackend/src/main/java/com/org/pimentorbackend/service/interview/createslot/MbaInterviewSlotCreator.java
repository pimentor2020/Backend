package com.org.pimentorbackend.service.interview.createslot;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Singleton;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.org.pimentorbackend.beans.InterviewSlot;
import com.org.pimentorbackend.beans.Interviewer;
import com.org.pimentorbackend.beans.TimeSlot;
import com.org.pimentorbackend.util.PimentorConstants;

@Singleton
@Component
public class MbaInterviewSlotCreator implements InterviewSlotCreator{
	@Autowired
	TimeSlot tSlot;
	@Autowired
	InterviewSlot intrvwSlot;
	
	private static String interview_type = PimentorConstants.INTERVIEWTYPE_MBA_ENTRANCE;
	
	public synchronized void createSlot(Interviewer i, String date, 
							String startTime, String endTime) {
		tSlot.setActive(true);
		tSlot.setDate(date);
		tSlot.setEndTime(endTime);
		tSlot.setStartTime(startTime);
		tSlot.setInterviewType(interview_type);
		tSlot.setNumberOfSlots(1);
		tSlot.setNumberOfSlotsOpen(1);
		intrvwSlot.setInterviewer(i);
		
		List<InterviewSlot> listOfSlots = new ArrayList<>();
		listOfSlots.add(intrvwSlot);
		
		tSlot.setInvSlotList(listOfSlots);
		
		//TODO save the slot.
	}

	@Override
	public void checkSlot(Interviewer i, String dates, 
							String startTime, String endTime) {
		TimeSlot tSlot = getInterviewSlotDetails(dates, startTime, 
													endTime, interview_type);
		if(tSlot != null) {
			addSlot(i, dates, startTime, endTime, tSlot);
		} else {
			createSlot(i, dates, startTime, endTime);
		}
	}
	
	private void addSlot(Interviewer i, String dates, 
							String startTime, String endTime, TimeSlot tSlot) {
		List<InterviewSlot> slotList = tSlot.getInvSlotList();
		intrvwSlot.setInterviewer(i);
		slotList.add(intrvwSlot);
		tSlot.setInvSlotList(slotList);
		
		int sltCnt = tSlot.getNumberOfSlots();
		tSlot.setNumberOfSlots(sltCnt+1);
		
		int openSlots = tSlot.getNumberOfSlotsOpen();
		tSlot.setNumberOfSlotsOpen(openSlots+1);
		
		//TODO save the slot 
	}
	
	private TimeSlot getInterviewSlotDetails(String Date, String startTime, 
										String endTime, String interviewtype) {		
		TimeSlot tSlot = null;
		/*TODO get The corresponding time-slot from Database*/
		
		return tSlot;	
	}

}
