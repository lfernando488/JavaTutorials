package MyFirstThread;

public class MyThread extends Thread{

	private String name; 
	private int time;
	
	public MyThread(String name, int time){
		this.name = name;
		this.time = time;
		start();
	}
	
	public void run(){
		System.out.println("Runnig thread 1");
		
		try {
			for(int x = 1; x <6; x ++){
				System.out.println("Thread: " + this.name + " | value of x = " + x);
				Thread.sleep(this.time);
			}
			System.out.println("\n=========================");
			System.out.println("======= " + this.name + " =======");
			System.out.println("========== END ==========\n");
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

