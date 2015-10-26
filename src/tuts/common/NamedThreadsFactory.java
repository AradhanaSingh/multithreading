package tuts.common;
import java.util.concurrent.ThreadFactory;

// implementing ThreadFactory for Thread Naming Strategy in ExecutorService 
public class NamedThreadsFactory implements ThreadFactory
{
	private static int count=0;
	private static String Name = "MyThread-";
	@Override
	public Thread newThread(Runnable r)
	{
		// creating a thread , naming it
		Thread t = new Thread(r, Name+ ++count );
		return t;
	}

}
