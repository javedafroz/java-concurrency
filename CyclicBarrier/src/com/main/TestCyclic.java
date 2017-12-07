package com.main;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class TestCyclic implements Runnable {
	
	CyclicBarrier barrier1;
	CyclicBarrier barrier2;

	public TestCyclic(CyclicBarrier barrier1, CyclicBarrier barrier2) {
		this.barrier1 = barrier1;
		this.barrier2 = barrier2;
	}
	
	@Override
	public void run() {
		try {
			System.out.println(Thread.currentThread().getName() + "Processing before reaching barrier1");
			Thread.sleep(3000);
			System.out.println(Thread.currentThread().getName() + "Calling await on barrier1");
			barrier1.await();
			System.out.println(Thread.currentThread().getName() + "Released from barrier1. Processing before reaching barrier2");
			Thread.sleep(3000);
			System.out.println(Thread.currentThread().getName() + "Calling await on barrier2");
			barrier2.await();
			System.out.println(Thread.currentThread().getName() + "Released from barrier2.");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
