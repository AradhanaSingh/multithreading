package tut1.api.threads.running;

import java.util.concurrent.TimeUnit;

public class FifthWay {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Main thread starts here");
		//anonymous implementation cannot be reused
		// created an inline task 
		// Generally used to handle UI event
		// To handle UI event need not create multiple instance of the class at a time instead whenever an event occurs task object is generated from 
		// the inline definition and is used there and then to handle the event
		Thread t = new Thread(new Runnable(){		
		@Override
		public void run()
		{
			for(int i=10; i>0; i--)
			{
				System.out.println("TICK TICK" + i);
				try {
					TimeUnit.MILLISECONDS.sleep(200);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
				
		});
		
		t.start();
		
		System.out.println("Main thread ends here");
	}

}
