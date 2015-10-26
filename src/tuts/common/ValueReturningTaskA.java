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

	}
	
	public int getSum()
	{
		return sum;
	}

}
