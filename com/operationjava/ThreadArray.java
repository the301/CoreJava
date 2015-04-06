package com.operationjava;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadArray {

	public static void main(String[] args) throws InterruptedException {

		Lock lock = new ReentrantLock();
		Flag flag = new Flag();

		Thread t4 = new Thread(new T4(lock, flag));
		Thread t5 = new Thread(new T5(lock, flag));
		Thread t6 = new Thread(new T6(lock, flag));

		flag.setFlag(1);

		t4.start();
		t5.start();
		t6.start();

	}

}

class Flag {

	volatile int flag = 0;

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

}

class T4 implements Runnable {

	Lock lock;
	Flag flag;

	T4(Lock lock, Flag flag) {
		this.lock = lock;
		this.flag = flag;
	}

	@Override
	public void run() {

		synchronized (lock) {

			int i = 1;

			while (i < 10) {

				if (flag.getFlag() != 1) {
					try {
						lock.notifyAll();
						lock.wait();
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
				} else {
					System.out.println("T4 " + i);

					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					i = i + 3;
					flag.setFlag(2);
					lock.notifyAll();
				}
			}
		}

	}

}

class T5 implements Runnable {

	Lock lock;
	Flag flag;

	T5(Lock lock, Flag flag) {
		this.lock = lock;
		this.flag = flag;
	}

	@Override
	public void run() {

		synchronized (lock) {

			int i = 2;

			while (i < 10) {

				if (flag.getFlag() != 2) {
					try {
						lock.notifyAll();
						lock.wait();
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
				} else {

					System.out.println("T5 " + i);

					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					i = i + 3;
					flag.setFlag(3);
					lock.notifyAll();
				}
			}
		}

	}

}

class T6 implements Runnable {

	Lock lock;
	Flag flag;

	T6(Lock lock, Flag flag) {
		this.lock = lock;
		this.flag = flag;
	}

	@Override
	public void run() {

		synchronized (lock) {

			int i = 3;

			while (i < 10) {

				if (flag.getFlag() != 3) {
					try {
						lock.notifyAll();
						lock.wait();
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
				} else {

					System.out.println("T6 " + i);

					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					i = i + 3;
					flag.setFlag(1);
					lock.notifyAll();
				}
			}
		}

	}

}