package com.main;

import java.util.concurrent.Exchanger;

public class TestExchanger2 implements Runnable {
	
	Exchanger<Object> exchanger;
	
	public TestExchanger2(Exchanger<Object> exchanger) {
		this.exchanger = exchanger;
	}

	@Override
	public void run() {
		try {
			Integer message = 1234;
			Object ob = exchanger.exchange(message);
			if(ob instanceof String){
				System.out.println( ob + " recieved at thread2");
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("TestExchanger2 done");
	}

}
