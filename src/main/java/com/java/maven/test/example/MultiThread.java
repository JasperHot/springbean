package com.java.maven.test.example;

import java.util.concurrent.Executors;

public class MultiThread {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Thread(new Thread1()).start();
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Executors.newSingleThreadExecutor().execute(new Thread2());
	}

	private static class Thread1 implements Runnable {

		@Override
		public void run() {
			// TODO Auto-generated method stub
			// 由于这里的Thread1和下面的Thread2内部run方法要用同一对象作为监视器，我们这里不能用this，因为在Thread2里面的this和这个Thread1的this不是同一个对象。我们用MultiThread.class这个字节码对象，当前虚拟机里引用这个变量时，指向的都是同一个对象。
			synchronized (MultiThread.class) {

				System.out.println(
						"enterthread1..." + Thread.currentThread().getName());

				System.out.println("thread1 iswaiting");
				try {
					// 释放锁有两种方式，第一种方式是程序自然离开监视器的范围，也就是离开了synchronized关键字管辖的代码范围，另一种方式就是在synchronized关键字管辖的代码内部调用监视器对象的wait方法。这里，使用wait方法释放锁。
					MultiThread.class.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				System.out.println("thread1 is goingon...");

				System.out.println("thread1 is beingover!");
				MultiThread.class.notify();// resume

			}
		}

	}

	private static class Thread2 implements Runnable {

		@Override
		public void run() {
			// TODO Auto-generated method stub
			synchronized (MultiThread.class) {

				System.out.println(
						"enterthread2..." + Thread.currentThread().getName());

				System.out.println(
						"thread2 notify otherthread can release wait status..");
				// 由于notify方法并不释放锁，即使thread2调用下面的sleep方法休息了10毫秒，但thread1仍然不会执行，因为thread2没有释放锁，所以Thread1无法得不到锁。

				MultiThread.class.notify();

				System.out.println("thread2 is sleeping tenmillisecond...");
				try {
					Thread.sleep(10);// Not release lock
					MultiThread.class.wait();// release lock
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				System.out.println("thread2 is goingon...");
				System.out.println("thread2 is beingover!");

			}
		}

	}

}
