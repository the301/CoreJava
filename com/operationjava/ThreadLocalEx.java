package com.operationjava;

public class ThreadLocalEx {

	public static void main(String[] args) {

		Thread t1 = new Thread(new ThreadLokal());
		Thread t2 = new Thread(new ThreadLokal());

		t1.start();
		t2.start();

	}

}

class ThreadLokal implements Runnable {

	double count = 0;

	@Override
	public void run() {
		count = ((int) Math.random() * 100D);

		System.out.println(count);

	}

}
