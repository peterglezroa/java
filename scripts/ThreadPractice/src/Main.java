
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * Test extends Thread
		 * 
		ThreadA thread1 = new ThreadA("Juanito", 10);
		ThreadA thread2 = new ThreadA("Panchito", 20, thread1);
		thread1.start();
		thread2.start();*/
		
		
		/*
		 * Test implements Runnable
		 * 
		 * */
		Thread thread1 = new Thread(new RunnableA("Juanito",10));
		Thread thread2 = new Thread(new RunnableA("Panchito",10));
		thread1.start();
		thread2.start();
		
		/*
		 * Test thread join
		 * Java Thread join method can be used to pause the current thread execution until unless the specified thread is dead
		 * *
		 try {
			 thread1.join();
			 thread2.join();
		 }catch(InterruptedException e) {e.printStackTrace();}
		 */
	}

}
