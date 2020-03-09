package com.home.nahusha.concurrency;

public class EvenOdd implements Runnable {
	private int remainder;
	static int printer = 0;
	private Object lock;

	public EvenOdd(Object lock, int remainder) {
		this.lock = lock;
		this.remainder = remainder;
	}

	@Override
	public void run() {
		while (true) {
			synchronized (lock) {
				while (printer % 2 != remainder) {
					try {
						lock.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println(Thread.currentThread().getName() + " " + printer);
				printer++;
				lock.notifyAll();
			}
		}
	}
}
