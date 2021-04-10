import java.util.concurrent.Semaphore;

public class VillageBridge {
	
	static Semaphore semaphore = new Semaphore(1);
	
	static class VillageTruck extends Thread{
		
		int VillagerNum;
		char Village;
		
		VillageTruck(char village, int num){
			
			this.Village=village;
			this.VillagerNum=num;
			
		}
		
		public void run() {
			
			System.out.println("Villager "+this.VillagerNum+" from Village "+this.Village+" is approaching the bridge.");
			try {
				
				semaphore.acquire();
				System.out.println("Villager "+this.VillagerNum+" is on the bridge.");
				Thread.sleep((long)(Math.random()*1000));
				System.out.println("Villager "+this.VillagerNum+" is exiting the bridge.");
				semaphore.release();
				
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
			
		}
		
	}
	
	public static void main(String[] args) {
		
		System.out.println("Four villager set out to sell their crops to their opposite village."
				+"  Two from Village A and two from Village B.");
		VillageTruck truck1 = new VillageTruck('A', 1);
		VillageTruck truck2 = new VillageTruck('B', 2);
		VillageTruck truck3 = new VillageTruck('A', 3);
		VillageTruck truck4 = new VillageTruck('B', 4);
		truck1.start();
		truck2.start();
		truck3.start();
		truck4.start();
		
	}

}
