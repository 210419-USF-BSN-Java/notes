package com.revature.weirdStuff;

public class Driver {

	public static void main(String[] args) {
		
//		StringBuilder sharedBuilder = new StringBuilder();
//		StringBuffer sharedBuffer = new StringBuffer();
//		
//		Runnable job = new StringRunnable(sharedBuilder, sharedBuffer);
//		
//		Thread t1 = new Thread(job);
//		Thread t2 = new Thread(job);
//		
//		t1.start();
//		t2.start();
//		
//		try {
//			t1.join();
//			t2.join();
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		System.out.println("StringBuilder results:");
//		System.out.println(sharedBuilder);
//		System.out.println("StringBuffer results:");
//		System.out.println(sharedBuffer);
		
		Counter count = new Counter();
		CounterRunnable countJob = new CounterRunnable(count);
		Thread t1 = new Thread(countJob);
		Thread t2 = new Thread(countJob);
		
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Count: " + count.count);
	}
}

class StringRunnable implements Runnable{

	StringBuilder sBuilder;
	StringBuffer sBuffer;
	
	public StringRunnable(StringBuilder sBuilder, StringBuffer sBuffer) {
		super();
		this.sBuffer=sBuffer;
		this.sBuilder=sBuilder;
	}
	@Override
	public void run() {
		for(int i = 0; i < 200; i++) {
			sBuilder.append("~");
			sBuffer.append("~");
		}
		
	}
	
}
