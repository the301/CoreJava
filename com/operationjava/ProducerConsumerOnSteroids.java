package com.operationjava;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumerOnSteroids {

	public static void main(String[] args) throws InterruptedException {
		AppStr app = new AppStr();
		app.appstart();

	}

}

class AppStr {

	BlockingQueue<String> bq = new ArrayBlockingQueue<String>(10);

	public void appstart() throws InterruptedException {

		System.out.println("X1".startsWith("X"));

		Thread p1 = new Thread(new Producer1(bq));
		Thread c1 = new Thread(new Consumer1(bq));
		Thread p2 = new Thread(new Producer2(bq));
		Thread c2 = new Thread(new Consumer2(bq));
		Thread p3 = new Thread(new Producer3(bq));
		Thread c3 = new Thread(new Consumer3(bq));

		p1.start();
		c1.start();
		p2.start();
		c2.start();
		p3.start();
		c3.start();

		p1.join();
		c1.join();

		p2.join();
		c2.join();

		p3.join();
		c3.join();

		System.out.println("The end");
	}
}

class Producer1 implements Runnable {

	BlockingQueue<String> bq;

	Producer1(BlockingQueue<String> bq) {
		this.bq = bq;
	}

	@Override
	public void run() {
		System.out.println("Producer1 start");
		try {
			for (int i = 0; i < 30; i++) {
				System.out.println("Putting p1: X" + i);
				Thread.sleep(1000);
				bq.put("X" + i);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}

class Consumer1 implements Runnable {

	BlockingQueue<String> bq;

	Consumer1(BlockingQueue<String> bq) {
		this.bq = bq;
	}

	@Override
	public void run() {
		System.out.println("Consumer1 start");
		try {
			for (int i = 0; i < 30; i++) {
				String x = bq.take();

				if (!x.startsWith("X")) {
					bq.put(x);
				} else {

					System.out.println("Taking c1 : " + x);
					Thread.sleep(1000);
				}

			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}

class Producer2 implements Runnable {

	BlockingQueue<String> bq;

	Producer2(BlockingQueue<String> bq) {
		this.bq = bq;
	}

	@Override
	public void run() {
		System.out.println("Producer2 start");
		try {
			for (int i = 0; i < 30; i++) {
				System.out.println("Putting p2: Y" + i);
				Thread.sleep(1000);
				bq.put("Y" + i);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}

class Consumer2 implements Runnable {

	BlockingQueue<String> bq;

	Consumer2(BlockingQueue<String> bq) {
		this.bq = bq;
	}

	@Override
	public void run() {
		System.out.println("Consumer2 start");
		try {
			for (int i = 0; i < 30; i++) {
				String y = bq.take();

				if (!y.startsWith("Y")) {
					System.out.println("Consumer2 put: " + y);
					bq.put(y);
				} else {

					System.out.println("Taking c2 : " + y);
					Thread.sleep(1000);
				}

			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}

class Producer3 implements Runnable {

	BlockingQueue<String> bq;

	Producer3(BlockingQueue<String> bq) {
		this.bq = bq;
	}

	@Override
	public void run() {
		System.out.println("Producer3 start");
		try {
			for (int i = 0; i < 30; i++) {
				System.out.println("Putting p3: Z" + i);
				Thread.sleep(1000);
				bq.put("Z" + i);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}

class Consumer3 implements Runnable {

	BlockingQueue<String> bq;

	Consumer3(BlockingQueue<String> bq) {
		this.bq = bq;
	}

	@Override
	public void run() {
		System.out.println("Consumer3 start");
		try {
			for (int i = 0; i < 30; i++) {
				String z = bq.take();

				if (!z.startsWith("Z")) {
					System.out.println("Consumer3 put: " + z);
					bq.put(z);
				} else {

					System.out.println("Taking c3 : " + z);
					Thread.sleep(1000);
				}

			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}