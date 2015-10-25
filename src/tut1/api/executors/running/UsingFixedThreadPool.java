package tut1.api.executors.running;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import tuts.common.LoopTaskA;

// no of thread is fixed
public class UsingFixedThreadPool {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Main thread starts here..");
		
		//creating thread pool executor service
		ExecutorService execService = Executors.newFixedThreadPool(3);
		
		// context switching happens in the background
		execService.execute(new LoopTaskA());
		execService.execute(new LoopTaskA());
		
		execService.execute(new LoopTaskA());
		
		// need to call the shutdown service, otherwise it's going to call memory leak in the application
		execService.shutdown();
		
		System.out.println("Main thread ends here...");

	}

}
