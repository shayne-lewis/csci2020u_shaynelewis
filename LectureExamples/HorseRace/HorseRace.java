// Let's create a horse race simulation program

public class HorseRace{
	private int nHorses = 5;
	
	public HorseRace(){
		Horse[] horses = new Horse[nHorses];
		String[] hNames = new String[]{"Horse 1", "Horse 2", "Horse 3", "Horse 4", "Horse 5"};
		
		for(int i = 0; i<nHorses; i++){
			horses[i] = new Horse(hNames[i]);			
		}
		
		// simulate the race
		System.out.println("Ready...");
		System.out.println("Set...");
		System.out.println("Go!");
		
		for(int i = 0; i<nHorses; i++){
			horses[i].start();			
		}
		
		
	}
	
	
	
	class Horse extends Thread{
		
		public Horse(String name){
			super(name);
		}
		
		public void run(){
			int ITERATIONS = 1000000000;
			for (int i =0; i<ITERATIONS; i++){
				if ((i % 100000000) == 0) {
					System.out.println(getName() + ": " + (i/100000000) + "m");
				}				
			}
			System.out.println(getName() + ": Finished racing." );
		}
		
	}
	
	
	
	public static void main(String[] args){
		// Instantiate the HorseRace 
		HorseRace hr = new HorseRace();
	}
}