package com.operationjava;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Deadlock {

	public static void main(String[] args) throws InterruptedException {

		final Lock lock1 = new ReentrantLock();
		final Lock lock2 = new ReentrantLock();

		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {

				synchronized (lock1) {
					System.out.println("Inside thread 1 : acquired lock1");

					synchronized (lock2) {
						System.out.println("Inside thread 1 : acquired lock2");
					}
				}

			}

		});

		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {

				synchronized (lock2) {
					System.out.println("Inside thread 2 : acquired lock2");

					synchronized (lock1) {
						System.out.println("Inside thread 2 : acquired lock1");
					}
				}

			}

		});

		t1.start();
		t2.start();

		t1.join();
		t2.join();

	}

}
