package com.home.nahusha.concurrency;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class SeriesPrint {
	public static void main(String[] args) throws InterruptedException {
		Object lock = new Object();
		//Thread t1 = new Thread(new EvenOdd(lock, 0), "Even");
		//Thread t2 = new Thread(new EvenOdd(lock, 1), "Odd");
		//t1.start();
		//t2.start();
		EvenOdd evenRunnable = new EvenOdd(lock, 0);
		EvenOdd oddRunnable = new EvenOdd(lock, 1);
		Executor executor = Executors.newFixedThreadPool(2);
		executor.execute(evenRunnable);
		executor.execute(oddRunnable);
	}
}

