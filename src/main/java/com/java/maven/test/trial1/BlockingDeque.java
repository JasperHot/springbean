package com.java.maven.test.trial1;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;

public class BlockingDeque {
	// 阻塞队列，FIFO
	private static LinkedBlockingQueue<Integer> concurrentLinkedQueue = new LinkedBlockingQueue<Integer>();

	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(2);

		Future<?> p1 = executorService.submit(new Producer("producer1"));
		Future<?> p2 = executorService.submit(new Producer("producer2"));
		Future<?> p3 = executorService.submit(new Producer("producer3"));
		Future<?> c1 = executorService.submit(new Consumer("consumer1"));
		Future<?> c2 = executorService.submit(new Consumer("consumer2"));
		Future<?> c3 = executorService.submit(new Consumer("consumer3"));
		executorService.shutdown();
		System.out.println("Main is finished");
		try {
			if (p1.get() == null) {
				System.out.println("Main producer1 is finished");
			}
			if (c1.get() == null) {
				System.out.println("Main consumer1 is finished");
			}
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	static class Producer implements Runnable {
		private String name;

		public Producer(String name) {
			this.name = name;
		}

		public void run() {
			for (int i = 1; i < 10; ++i) {
				System.out.println(name + "  生产： " + i);
				// concurrentLinkedQueue.add(i);
				try {
					concurrentLinkedQueue.put(i);
					Thread.sleep(200); // 模拟慢速的生产，产生阻塞的效果
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

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
					// 必须要使用take()方法在获取的时候阻塞
					System.out.println(
							name + "消费： " + concurrentLinkedQueue.take());
					// 使用poll()方法 将产生非阻塞效果
					// System.out.println(name+"消费： " +
					// concurrentLinkedQueue.poll());

					// 还有一个超时的用法，队列空时，指定阻塞时间后返回，不会一直阻塞
					// 但有一个疑问，既然可以不阻塞，为啥还叫阻塞队列？
					// System.out.println(name+" Consumer " +
					// concurrentLinkedQueue.poll(300, TimeUnit.MILLISECONDS));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
			System.out.println("Consumer " + name + " is finished");
		}
	}
}
