package com.home.nahusha.concurrency;

import java.util.concurrent.atomic.AtomicInteger;

public class nThreadPrinter {
	Object lock = new Object();
	int threadIdToRun = 1;
	AtomicInteger count = new AtomicInteger(1);
	
	public static void main(String[] args) {
		nThreadPrinter ntp = new nThreadPrinter();
		Thread t1 = new Thread(ntp.new Printer(1));
		Thread t2 = new Thread(ntp.new Printer(2));
		Thread t3 = new Thread(ntp.new Printer(3));
		
		t1.start();
		t2.start();
		t3.start();
	}
	
	class Printer implements Runnable {
		private int threadId;
		
		public Printer(int threadId) {
			this.threadId = threadId;
		}
		
		public void run() {
			try {
				while(count.get() < 100) {
					synchronized (lock) {
						if (threadId != threadIdToRun)
							lock.wait();
						else {
							System.out.println("ThreadId = " + threadId + " value = " + count.getAndIncrement());
							if(threadIdToRun == 1)
								threadIdToRun = 2;
							else if (threadIdToRun == 2)
								threadIdToRun = 3;
							else if (threadIdToRun == 3)
								threadIdToRun = 1;
							lock.notifyAll();
						}
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	
}
