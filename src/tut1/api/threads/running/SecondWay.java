package tut1.api.threads.running;

import java.util.concurrent.TimeUnit;


// Starting the thread from outside rather than constructor of thread cum task definition.
// This gives more control to the calling code as to when start the thread.


public class SecondWay {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Main thread starts here");
		// first thread
		new SecondTask().start();
		// second thread
		Thread t = new SecondTask();
		t.start();
		System.out.println("Main thread ends here");
	}

}
class SecondTask extends Thread
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
	
	
	public SecondTask()
	{
		this.id=++count;
	}

}
