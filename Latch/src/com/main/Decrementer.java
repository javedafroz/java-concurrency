package com.main;
import java.util.concurrent.CountDownLatch;

public class Decrementer implements Runnable {
	
	CountDownLatch latch = null;
			
	public Decrementer(CountDownLatch latch) {
		this.latch = latch;
	}

	@Override
	public void run() {
		System.out.println("Decrementer starting");
		
		
		try {
			Thread.sleep(1000);
			latch.countDown();

			Thread.sleep(1000);
			latch.countDown();

			Thread.sleep(1000);
			latch.countDown();
			System.out.println("Decrementer ending");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
