package com.revature.basics;

public class Driver {
	public static void main(String[] args) {
		Runnable job = () -> {
			System.out.println("This is a lambda expression");
		};

		HelloThread t1 = new HelloThread();
		Thread t2 = new Thread(new GoodbyeRunnable());
		Thread t3 = new Thread(job);
		
		System.out.println("The state of t1 is: " + t1.getState());
		
		t1.start();
		t2.start();
		t3.start();
		System.out.println("The state of t1 is: " + t1.getState());
		System.out.println("The state of t1 is: " + t1.getState());
		System.out.println("The state of t1 is: " + t1.getState());
		System.out.println("The state of t1 is: " + t1.getState());
		System.out.println("The state of t1 is: " + t1.getState());
		System.out.println("The state of t1 is: " + t1.getState());
		
		try {
			t1.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("End of main method!");
	}
}

class HelloThread extends Thread {
	public void run() {
		System.out.println("HelloThread has started.");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Hello");
	}
}

class GoodbyeRunnable implements Runnable {

	@Override
	public void run() {
		System.out.println("Goodbye");
	}

}
