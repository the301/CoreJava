package com.operationjava;

public class ThreadException {

	public static void main(String[] args) throws InterruptedException {

		Thread t1 = new Thread(new ThreadEx());

		Thread.UncaughtExceptionHandler ueh = new Thread.UncaughtExceptionHandler() {

			@Override
			public void uncaughtException(Thread t, Throwable e) {
				System.out.println("Uncaught exception from thread "
						+ t.getName() + " with message: " + e.getMessage());
			}
		};

		t1.setName("Exceptional Thread");
		t1.setUncaughtExceptionHandler(ueh);

		t1.start();
		t1.join();

		System.out.println("Main done");

	}

}

class ThreadEx implements Runnable {

	@Override
	public void run() {

		try {
			throw new RuntimeException("This exception is from thread");
		} catch (RuntimeException e) {
			throw e;
		}
	}
}