
public class RunnableA implements Runnable{
	protected String name;
	protected int count;
	protected int MAXCOUNT;
	protected ThreadA friendlyThread;
	
	public RunnableA(String name, int maxCount) {
		super();
		this.name = name;
		count = 0;
		this.MAXCOUNT = maxCount;
		this.friendlyThread = null;
	}
	
	public RunnableA(String name, int maxCount, ThreadA friend) {
		super();
		this.name = name;
		count = 0;
		this.MAXCOUNT = maxCount;
		this.friendlyThread = friend;
	}
	
	public void run() {
		while(count <= MAXCOUNT) {
			count++;
			System.out.println("Runnable " + name + " counting in thread " + Thread.currentThread().getId() + ": " + count);
			if(friendlyThread != null && count%5 == 0) {
				this.askCount(friendlyThread);
			}
		}
		System.out.println(name + "Finished");
		
		try {
			System.out.println(name + "Sleeping");
			Thread.sleep(100);
		}catch(Exception e) {e.printStackTrace();}
	}
	
	public void askCount(ThreadA otherThread) {
		System.out.println(name + " asked for " + otherThread.name() + " count. It is: " + otherThread.getCount());
	}
	
	public void sayHello() {
		System.out.println(name + " says hellooo");
	}
	
	public int getCount() {
		return count;
	}
	
	public String name() {
		return name;
	}
}
