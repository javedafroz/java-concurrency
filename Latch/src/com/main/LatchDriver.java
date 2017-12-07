package com.main;

import java.util.concurrent.CountDownLatch;

public class LatchDriver {
	
	public static void main(String[] args) {
		CountDownLatch latch = new CountDownLatch(3);
		
		Waiter w = new Waiter(latch);
		Decrementer d = new Decrementer(latch);
		
		Thread t1 = new Thread(d);
		Thread t2 = new Thread(w);
		
		t2.start();
		t1.start();
		
		System.out.println("Done");
		
	}

}
