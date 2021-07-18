package training.java_training.problem_solving;

public class DeadLockExampleInThreads {

	public static void main(String[] args) throws InterruptedException {
		
		Thread t1 = new Thread() {
			@Override
			public void run() {
				method1("thread1");
			}
		};
		
		Thread t2 = new Thread() {
			@Override
			public void run() {
				method2("thread2");
			}
		};
		t1.start();
		t2.sleep(1000); // if we remove this - deadlock will occur
		t2.start();
	}

	private static void method1(String threadName) {
		synchronized (String.class) {
			System.out.println(threadName+" - Aquired lock on String.class object");
			synchronized (Integer.class) {
				System.out.println(threadName+" - Aquired lock on Integer.class object");
			}
		}
	}

	private static void method2(String threadName) {
		synchronized (Integer.class) {
			System.out.println(threadName+" - Aquired lock on Integer.class object");
			synchronized (String.class) {
				System.out.println(threadName+" - Aquired lock on String.class object");
			}
		}
	}

}
