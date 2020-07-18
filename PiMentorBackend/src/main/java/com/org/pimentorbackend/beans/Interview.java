package com.org.pimentorbackend.beans;

public class Interview {
	private Interviewer interviewer;
	private Aspirant aspirant;
	private String date;
	private String startTime;
	private String endTime;
	private Long interviewId;
	
	public Interviewer getInterviewer() {
		return interviewer;
	}
	public void setInterviewer(Interviewer interviewer) {
		this.interviewer = interviewer;
	}
	public Aspirant getAspirant() {
		return aspirant;
	}
	public void setAspirant(Aspirant aspirant) {
		this.aspirant = aspirant;
	}
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
	public Long getInterviewId() {
		return interviewId;
	}
	public void setInterviewId(Long interviewId) {
		this.interviewId = interviewId;
	}
}
