package com.org.pimentorbackend.util;

import org.springframework.stereotype.Component;

@Component
public class RandomGenerator {
	public String getRandomValue() {
		int length = 6;
		String randomValue = String.valueOf(Math.random() * (9*Math.pow(10, length)) );
		return randomValue.substring(0,6);
	}
}
