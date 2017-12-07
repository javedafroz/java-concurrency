package com.main;

import java.util.concurrent.Exchanger;

public class TestExchanger1 implements Runnable {
	
	Exchanger<Object> exchanger;
	
	public TestExchanger1(Exchanger<Object> exchanger) {
		this.exchanger = exchanger;
	}

	@Override
	public void run() {
		try {
			String message = "String message from TestExchanger1";
			Object ob = exchanger.exchange(message);
			if(ob instanceof Integer){
				System.out.println("Integer " + ob + "recieved at thread1");
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("TestExchanger1 done");
	}

}
