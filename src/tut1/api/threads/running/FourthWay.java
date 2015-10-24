package tut1.api.threads.running;

import java.util.concurrent.TimeUnit;

public class FourthWay {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Main thread starts here");
		// starting the thread from the main method
		// outside the constructor
		// task definition is separate from thread related code, thus can be used by executors and normal threads
		// this allows a greater control i.e when to create them and when to run them
		new Thread(new FourthTask()).start();
		// second thread
		new Thread(new FourthTask()).start();
		System.out.println("Main thread ends here");
		
	}

}
//implements Runnable, so doesn't have start() method
//have separated thread from task
//Only a task definition
class FourthTask implements Runnable
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
	
	public FourthTask()
	{
		this.id=++count;
	}
}