package tut2.api.threads.naming;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import tuts.common.LoopTaskC;
import tuts.common.NamedThreadsFactory;

public class NamingExecutorThreads {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String currentThreadName = Thread.currentThread().getName();
		System.out.println("[ "+ currentThreadName + "] " +"Main thread starts here...");
		// providing an instance of this factory to the executor
		// this factory names the thread
		ExecutorService execService = Executors.newCachedThreadPool( new NamedThreadsFactory());
		execService.execute(new LoopTaskC());
		execService.execute(new LoopTaskC());
		execService.execute(new LoopTaskC());
		execService.shutdown();
		
		System.out.println("[ "+ currentThreadName + "] " +"Main thread ends here...");
		
	}

}
