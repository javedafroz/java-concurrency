package com.main;

import java.util.LinkedList;
import java.util.concurrent.Semaphore;

public class Producer implements Runnable {

	Semaphore semaphore;
	LinkedList<String> queue;

	public Producer(Semaphore semaphore, LinkedList<String> queue) {
		this.semaphore = semaphore;
		this.queue = queue;
	}

	@Override
	public void run() {
		while (true) {
			try {
				System.out.println("Producing - ");
				queue.add("M-" + System.currentTimeMillis());
				Thread.sleep(1000);
				semaphore.acquire();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
