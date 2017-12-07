package com.main;

import java.util.concurrent.CyclicBarrier;

public class CyclicMain {

	public static void main(String[] args) {
		CyclicBarrier barrier1 = new CyclicBarrier(2);
		CyclicBarrier barrier2 = new CyclicBarrier(2);
		
		TestCyclic cyclic1 = new TestCyclic(barrier1, barrier2);
		TestCyclic cyclic2 = new TestCyclic(barrier1, barrier2);
		
		Thread t1 = new Thread(cyclic1, "Alpha");
		Thread t2 = new Thread(cyclic2, "Beta");
		
		t1.start();
		t2.start();
	}
}
