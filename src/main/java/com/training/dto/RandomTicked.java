package com.training.dto;

import java.util.Random;

public class RandomTicked {
	long tickedNumber;
	Random random = new Random();
	long randomTickedNumber = random.nextInt(100000) + 1;

	public long getTickedNumber() {
		return tickedNumber;
	}

	public void setTickedNumber(long randomTickedNumber) {
		this.randomTickedNumber = randomTickedNumber;
	}

}
