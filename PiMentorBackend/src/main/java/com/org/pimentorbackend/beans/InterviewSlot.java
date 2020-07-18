package com.org.pimentorbackend.beans;


public class InterviewSlot {
	
	private Aspirant candidate;
	private Interviewer Interviewer;
	
	public Aspirant getCandidate() {
		return candidate;
	}
	public void setCandidate(Aspirant candidate) {
		this.candidate = candidate;
	}
	public Interviewer getInterviewer() {
		return Interviewer;
	}
	public void setInterviewer(Interviewer interviewer) {
		Interviewer = interviewer;
	}
}
