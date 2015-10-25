package tut2.api.threads.naming;

import tuts.common.LoopTaskB;
import tuts.common.LoopTaskC;

public class NamingThreadsSecondway {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String currentThreadName = Thread.currentThread().getName();
		
		System.out.println("[" + currentThreadName + "] main thread starts here...");
		// added name of thread at time of creation
		new Thread(new LoopTaskC(), "MyThread-1").start();
		Thread t2 = new Thread(new LoopTaskC());
		// adding name to thread after creation but before running
		t2.setName("MyThread-2");
		t2.start();
		
		System.out.println("["+ currentThreadName+"Main thread ends here ...");
	}

}
