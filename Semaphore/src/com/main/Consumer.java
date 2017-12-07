package com.main;

import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Semaphore;

public class Consumer implements Runnable {

	Semaphore semaphore;
	LinkedList<String> queue;

	public Consumer(Semaphore semaphore, LinkedList<String> queue) {
		this.semaphore = semaphore;
		this.queue = queue;
		ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
	}

	@Override
	public void run() {
		while (true) {
			semaphore.release();
			if(!queue.isEmpty())
				System.out.println("Consuming - " + queue.poll());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
