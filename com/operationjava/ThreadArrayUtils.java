package com.operationjava;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadArrayUtils {

	public static void main(String[] args) throws InterruptedException {

		Lock lock = new ReentrantLock();

		FlagUtil flag = new FlagUtil();
		flag.setFlag(1);

		ExecutorService executor = Executors.newFixedThreadPool(3);

		executor.execute(new Thread(new T7(lock, flag)));
		executor.execute(new Thread(new T8(lock, flag)));
		executor.execute(new Thread(new T9(lock, flag)));

		executor.shutdown();

		executor.awaitTermination(1, TimeUnit.DAYS);

	}

}

class FlagUtil {

	volatile int flag = 0;

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

}

class T7 implements Runnable {

	Lock lock;
	FlagUtil flag;

	T7(Lock lock, FlagUtil flag) {
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

class T8 implements Runnable {

	Lock lock;
	FlagUtil flag;

	T8(Lock lock, FlagUtil flag) {
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

class T9 implements Runnable {

	Lock lock;
	FlagUtil flag;

	T9(Lock lock, FlagUtil flag) {
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