package tuts.common;

import java.util.concurrent.TimeUnit;

public class LoopTaskC implements Runnable {
	private static int count=0;
	private int instanceNumber;
	private String taskId;
	
	@Override
	public void run()
	{
		// getting the instance of the current thread to get the thread name
		String currentThreadName = Thread.currentThread().getName();
        System.out.println("##### ["+ currentThreadName +"<TASK- "+ taskId +"> STARTING #######" );
			for(int i =10;i>0; i--)
			{
				System.out.println("["+ currentThreadName+"<"+ taskId +"TICK TICK" + i);
				try {
					// making it sleep for random time
					TimeUnit.MILLISECONDS.sleep((long)(Math.random()*1000));
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
        System.out.println("***** [ "+currentThreadName+"<TASK- "+ taskId +"> DONE *****" );
	}	
		public LoopTaskC()
		{
			this.instanceNumber=++count;
			this.taskId = "LoopTaskC" + instanceNumber;
		}
	
}
