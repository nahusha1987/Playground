package com.home.nahusha.concurrency;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TestCallable {
	
	static class MyCallable implements Callable<String> {
		private CountDownLatch latch;
		public MyCallable(CountDownLatch latch) {
			this.latch = latch;
		}
		@Override
		public String call() throws Exception {
			//latch.countDown();
			return Thread.currentThread().getName();
		}
	}
	
	
	
	public static void main(String[] args) {
		/*Callable<String> callableTask = () -> {
			return Thread.currentThread().getName();
		};*/
		ExecutorService executor = Executors.newFixedThreadPool(2);
		CountDownLatch latch = new CountDownLatch(1);
		Future<String> fut = executor.submit(new MyCallable(latch));
		try {
			//latch.await();
			System.out.println(fut.get());
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName());
		executor.shutdown();
	}
}
