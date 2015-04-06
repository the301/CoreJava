package com.operationjava;

public class ThreadSerialParallel {

	public static void main(String[] args) throws InterruptedException {

		Thread t1 = new Thread(new T1());
		Thread t2 = new Thread(new T2());
		Thread t3 = new Thread(new T3());

		t1.start();
		t1.join();
		t2.start();
		t2.join();
		t3.start();
	}

}

class T1 implements Runnable {

	@Override
	public void run() {

		for (int i = 0; i < 30; i = i + 3) {
			System.out.println("T1 " + i);

			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}

class T2 implements Runnable {

	@Override
	public void run() {

		for (int i = 1; i < 30; i = i + 3) {
			System.out.println("T2 " + i);

			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}

class T3 implements Runnable {

	@Override
	public void run() {

		for (int i = 2; i < 30; i = i + 3) {
			System.out.println("T3 " + i);

			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
