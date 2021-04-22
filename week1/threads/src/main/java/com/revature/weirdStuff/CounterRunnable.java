package com.revature.weirdStuff;

public class CounterRunnable implements Runnable{

	Counter c;
	
	public CounterRunnable(Counter c) {
		this.c = c;
	}
	@Override
	public void run() {
		for(int i = 0; i < 500; i++) {
			c.increment();
		}
	}

}
