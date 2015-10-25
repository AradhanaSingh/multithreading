package tut1.api.executors.running;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import tuts.common.LoopTaskA;

public class UsingSingleThreadExecutor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Main thread starts here..");
		
		//creating thread pool executor service
		ExecutorService execService = Executors.newSingleThreadExecutor();
		
		// context switching happens in the background
		// any task and any number of tasks can be added
		execService.execute(new LoopTaskA());
		execService.execute(new LoopTaskA());
		execService.execute(new LoopTaskA());
		// more tasks are added, but  number of loop concurrently running doesn't exceed 3
		execService.execute(new LoopTaskA());
		execService.execute(new LoopTaskA());
		execService.execute(new LoopTaskA());
		
		// need to call the shutdown service, otherwise it's going to call memory leak in the application
		execService.shutdown();
		
		System.out.println("Main thread ends here...");	

	}

}
