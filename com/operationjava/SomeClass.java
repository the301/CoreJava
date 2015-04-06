package com.operationjava;

public class SomeClass {

	Signal signal = new Signal();
	TheThread thethread = new TheThread();
	TheThreadTwo threadtwo = new TheThreadTwo();

	public static void main(String[] args) throws InterruptedException {
		
		SomeClass someclass = new SomeClass();
		
		Thread t1 = new Thread(someclass.thethread);
		
		Thread t2 = new Thread(someclass.threadtwo);

		t1.start();

		t2.start();

		t1.join();
		t2.join();

		System.out.println("Exiting main");

	}

	class TheThread implements Runnable {

		@Override
		public void run() {

			System.out.println(signal.getSignal());

			while (!signal.getSignal()) {
				System.out.println("...");
			}

			System.out.println("... exiting thread1...");

		}

	}

	class TheThreadTwo implements Runnable {

		@Override
		public void run() {

			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			signal.setSignal(true);

			System.out.println("... exiting thread2...");

		}

	}

}

class Signal {

	private boolean signal = false;

	public synchronized boolean getSignal() {
		return signal;
	}

	public synchronized void setSignal(boolean signal) {
		this.signal = signal;
	}

}

/**/