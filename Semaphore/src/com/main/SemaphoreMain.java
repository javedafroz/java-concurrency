package com.main;

import java.util.LinkedList;
import java.util.concurrent.Semaphore;

public class SemaphoreMain {

	public static void main(String[] args) {

		LinkedList<String> list = new LinkedList<String>();
		Semaphore semaphore = new Semaphore(2, true);
		
		Producer p = new Producer(semaphore, list);
		Consumer c = new Consumer(semaphore, list);
		
		new Thread(p).start();
		new Thread(c).start();
	}

}
