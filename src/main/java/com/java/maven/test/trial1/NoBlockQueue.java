package com.java.maven.test.trial1;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NoBlockQueue {
	private static ConcurrentLinkedQueue<Integer> concurrentLinkedQueue = new ConcurrentLinkedQueue<Integer>();

	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(2);

		executorService.submit(new Producer("producer1"));
		executorService.submit(new Producer("producer2"));
		executorService.submit(new Producer("producer3"));
		executorService.submit(new Consumer("consumer1"));
		executorService.submit(new Consumer("consumer2"));
		executorService.submit(new Consumer("consumer3"));
		System.out.println("Main is finished");
		executorService.shutdown();
	}

	static class Producer implements Runnable {
		private String name;

		public Producer(String name) {
			this.name = name;
		}

		public void run() {
			for (int i = 1; i < 10; ++i) {
				System.out.println(name + " start producer " + i);
				concurrentLinkedQueue.offer(i);
				try {
					Thread.sleep(20);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// System.out.println(name+"end producer " + i);
			}
			System.out.println("Producer " + name + " is finished");
		}
	}

	static class Consumer implements Runnable {
		private String name;

		public Consumer(String name) {
			this.name = name;
		}
		public void run() {
			for (int i = 1; i < 10; ++i) {
				try {

					System.out.println(
							name + " Consumer " + concurrentLinkedQueue.poll());

				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// System.out.println();
				// System.out.println(name+" end Consumer " + i);
			}
			System.out.println("Consumer " + name + " is finished");
		}
	}
}
