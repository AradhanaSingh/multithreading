package tuts.common;

import java.util.concurrent.TimeUnit;

public class ValueReturningTaskA implements Runnable {

	private int a;
	private int b;
	private long sleepTime;
	private int sum;
	
	private static int count = 0;
	private int instanceNumber;
	private String taskId;
	
	// volatile so that it's values are read accurately from reader threads
	// after task is done value of done boolean variable should be set to True
	private volatile boolean done = false;
	
	public ValueReturningTaskA(int a, int b, long sleepTime)
	{
		this.a=a;
		this.b=b;
		this.sleepTime = sleepTime;
		
		this.instanceNumber = ++count;
		this.taskId="ValReturnTaskA-"+instanceNumber;
	}

	// run method doesn't return anything
	// so how do we return a value
	@Override
	public void run() {
		// TODO Auto-generated method stub
		String currentThreadName = Thread.currentThread().getName();
		System.out.println("#### [ " + currentThreadName + "] <"+ taskId + "> STARTING #####");
		System.out.println("#### [ " + currentThreadName + "] <"+ taskId + "> Sleeping for "+ sleepTime + " millis");
	
		try {
			TimeUnit.MILLISECONDS.sleep(sleepTime);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sum = a + b;
		System.out.println("***** [ "+ currentThreadName + "] < "+ taskId + "> Done executing");
		done = true;
		// it should be synchronized on the same object
		synchronized(this)
		{
			System.out.println("[ "+ currentThreadName + " ] "+ taskId+ "> NOTIFYING ......");
			this.notifyAll();
		}
	}
	
	public int getSum()
	{
		if (!done){
			synchronized(this)
			{
				try {
					System.out.println("[" + Thread.currentThread().getName()+ "]  ===== WAITING for result from " + taskId + "... ####");
					// if this task is waiting, then some other thread should also notify
					this.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		// print statement when a caller thread wakes up
		System.out.println("[ " + Thread.currentThread().getName()+ "] === WOKEN-UP for "+ taskId + "... ####");
		
		return sum;
	}

}
