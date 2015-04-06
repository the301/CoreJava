package com.operationjava;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumer {

	public static void main(String[] args) throws InterruptedException {
		App app = new App();
		app.appstart();

	}

}

class App {

	BlockingQueue<Integer> bq = new ArrayBlockingQueue<Integer>(10);

	public void appstart() throws InterruptedException {

		Thread p = new Thread(new Producer(bq));
		Thread c = new Thread(new Consumer(bq));

		p.start();
		c.start();

		p.join();
		c.join();

		System.out.println("The end");
	}
}

class Producer implements Runnable {

	BlockingQueue<Integer> bq;

	Producer(BlockingQueue<Integer> bq) {
		this.bq = bq;
	}

	@Override
	public void run() {
		System.out.println("Producer start");
		try {
			for (int i = 0; i < 30; i++) {
				System.out.println("Putting : " + i);
				Thread.sleep(1000);
				bq.put(i);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}

class Consumer implements Runnable {

	BlockingQueue<Integer> bq;

	Consumer(BlockingQueue<Integer> bq) {
		this.bq = bq;
	}

	@Override
	public void run() {
		System.out.println("Consumer start");
		try {
			for (int i = 0; i < 30; i++) {
				System.out.println("Taking : " + bq.take());
				Thread.sleep(1000);

			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}