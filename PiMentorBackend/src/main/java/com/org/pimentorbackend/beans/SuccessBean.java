package com.org.pimentorbackend.beans;

import org.springframework.stereotype.Component;

@Component
public class SuccessBean {
	private String successMessage;
	private String authorizeToken;

	public String getSuccessMessage() {
		return successMessage;
	}

	public void setSuccessMessage(String successMessage) {
		this.successMessage = successMessage;
	}

	public String getAuthorizeToken() {
		return authorizeToken;
	}

	public void setAuthorizeToken(String authorizeToken) {
		this.authorizeToken = authorizeToken;
	}
}
