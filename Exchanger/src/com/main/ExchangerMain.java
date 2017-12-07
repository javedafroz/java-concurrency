package com.main;

import java.util.concurrent.Exchanger;

public class ExchangerMain {

	public static void main(String[] args) {

		Exchanger<Object> exchanger = new Exchanger<Object>();
		
		TestExchanger1 o1 = new TestExchanger1(exchanger);
		TestExchanger2 o2 = new TestExchanger2(exchanger);
		
		new Thread(o1).start();
		new Thread(o2).start();
	}

}
