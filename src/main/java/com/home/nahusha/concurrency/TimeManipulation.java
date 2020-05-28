package com.home.nahusha.concurrency;

import java.time.Duration;
import java.time.Instant;

public class TimeManipulation {
	public static void main(String[] args) throws InterruptedException {
		Instant old = Instant.now();
		System.out.println(old);
		Thread.sleep(2000);
		Instant now = Instant.now();
		System.out.println(Duration.between(old, now).toMillis());
		System.out.println(Duration.between(now, old).toMillis());
		System.out.println(now.isAfter(old));
	}
}
