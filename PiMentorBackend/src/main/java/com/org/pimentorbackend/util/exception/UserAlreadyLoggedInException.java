package com.org.pimentorbackend.util.exception;

public class UserAlreadyLoggedInException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7040765240032199714L;

	public UserAlreadyLoggedInException(String message) {
		super(message);
	}
}
