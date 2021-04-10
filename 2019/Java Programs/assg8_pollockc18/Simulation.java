/* @author Casey Pollock
 * Assignment 8
 * CSCI 2540
 *
 * This class will use the Event and EventList class to 
 * process the events of a single teller operated bank.
 * The arrival and departure of each patron will be shown 
 * and once everyone has been served statistics about the 
 * transactions will be shown.  The statistics will include 
 * the number of patrons and the average wait time of 
 * each patron.
*/

package assg8_pollockc18;

import java.io.*;
import java.util.Scanner;

class Simulation {
	
	
	/**
	 * Loads Events from an input file. The file will be in the 
	 * format of an arrival time a tab and a transaction time on 
	 * a line.  Each line will contain a new patron.  The number of
	 * patrons will be returned.
	 * @param queue the EventList where events will be stored.
	 * @param input The file name for arrival and transaction times
	 * @return The number of patrons that will be serviced.
	 * @throws FileNotFoundException
	 */
	public static int loadList(EventList queue, String input) throws FileNotFoundException{
		
		Scanner inputFile=new Scanner(new File(input));
		int patrons=0, nxtdepart=0, arrival, transaction;
		
		while(inputFile.hasNext()) {
			
			arrival=inputFile.nextInt();
			transaction=inputFile.nextInt();
			queue.add(new Event("arrival", patrons, arrival));
			if(arrival>nxtdepart)
				nxtdepart=arrival+transaction;
			else
				nxtdepart=nxtdepart+transaction;
			queue.add(new Event("departure", patrons, nxtdepart));
			patrons++;
			
		}
		
		inputFile.close();
		return patrons;
		
	}
	

	public static void main(String[] args) {
		
		EventList queue=new EventList();
		int patrons, patron; Event temp;
		double wait=0;
		
		try {
			
			patrons=loadList(queue, "C:\\Users\\HP\\Desktop\\Test\\input.txt");
			
		}
		catch (FileNotFoundException e){
			
			System.out.println("Error:  Could not open file");
			return;
			
		}
		
		int[] waitTime=new int[patrons];
		
		for(int count=0; count<patrons; count++)
			waitTime[count]=-1;
		System.out.println("Simulation Begins");
		while(!queue.isEmpty()) {
			
			temp=queue.nextEvent();
			System.out.println("Processing "+temp.toString());
			patron=temp.getPatronNum();
			if(temp.getType().equals("arrival")) {
				
				if(patron==0)
					waitTime[patron]=0;
				else if(waitTime[patron]!=0)
					waitTime[patron]=temp.getTime();
				
			}
			else {
					
				if(patrons-1!=patron) {
						
					if(waitTime[patron+1]==-1)
						waitTime[patron+1]=0;
					else
						waitTime[patron+1]=temp.getTime()-waitTime[patron+1];
						
				}
					
			}
			
			
		}
		for(int count=0; count<patrons; count++) {
			
			wait=wait+waitTime[count];
			
		}
		wait=wait/patrons;
		System.out.println("Simulation Ends\n\nSimulation Statistics:\nTotal number of people processed:\t"+patrons+"\nAverage of time spent waiting:\t\t"+wait);

	}

}
