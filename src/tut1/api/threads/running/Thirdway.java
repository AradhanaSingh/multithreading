package tut1.api.threads.running;

import java.util.concurrent.TimeUnit;

public class Thirdway {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Main thread starts here");
		// first thread
		new ThirdTask();
		// second thread
		new ThirdTask();
		System.out.println("Main thread ends here");
		

	}
	
			

}

// implements Runnable, so doesn't have start() method
// have separated thread from task
// Only a task definition
class ThirdTask implements Runnable
{
	private static int count=0;
	private int id ;
	
	@Override
	public void run()
	{
		for(int i =10;i>0; i--)
		{
			System.out.println("<"+ id +"TICK TICK" + i);
			try {
				TimeUnit.MILLISECONDS.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public ThirdTask()
	{
		this.id=++count;
		// using overloaded constructor of Thread class 
		new Thread(this).start();
		
	}
}