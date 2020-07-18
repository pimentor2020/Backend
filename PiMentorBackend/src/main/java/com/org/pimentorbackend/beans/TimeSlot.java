package com.org.pimentorbackend.beans;

import java.util.List;

import org.springframework.stereotype.Component;


@Component
public class TimeSlot {
	private String interviewType;
	private String date;
	private String startTime;
	private String endTime;
	private boolean isActive;
	private int numberOfSlots;
	private int numberOfSlotsOpen;
	private List<InterviewSlot> invSlotList;
		
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getInterviewType() {
		return interviewType;
	}
	public void setInterviewType(String interviewType) {
		this.interviewType = interviewType;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public int getNumberOfSlots() {
		return numberOfSlots;
	}
	public void setNumberOfSlots(int numberOfSlots) {
		this.numberOfSlots = numberOfSlots;
	}
	public int getNumberOfSlotsOpen() {
		return numberOfSlotsOpen;
	}
	public void setNumberOfSlotsOpen(int numberOfSlotsOpen) {
		this.numberOfSlotsOpen = numberOfSlotsOpen;
	}
	public List<InterviewSlot> getInvSlotList() {
		return invSlotList;
	}
	public void setInvSlotList(List<InterviewSlot> invSlotList) {
		this.invSlotList = invSlotList;
	}
}
