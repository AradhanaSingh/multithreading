package tut2.api.threads.naming;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import tuts.common.LoopTaskC;

public class NamingExecutorThreads {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String currentThreadName = Thread.currentThread().getName();
		System.out.println("[ "+ currentThreadName + "] " +"Main thread starts here...");
		ExecutorService execService = Executors.newCachedThreadPool();
		execService.execute(new LoopTaskC());
		execService.execute(new LoopTaskC());
		execService.execute(new LoopTaskC());
		execService.shutdown();
		
		System.out.println("[ "+ currentThreadName + "] " +"Main thread ends here...");
		
	}

}
