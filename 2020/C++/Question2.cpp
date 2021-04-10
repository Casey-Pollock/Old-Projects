/* Casey Pollock
 * Assignment 1
 * CSCI 3000
 *
 * This method is used to create an orphan child.
 *
 */

#include <stdio.h>
#include <unistd.h> 
#include <time.h>

int main(){

	pid_t pid;											/*Stores the process id of the process*/
	pid = fork();
	
	if(pid == 0){										/*Checkes if current process is a child*/
		
		printf("Child has started.\n");
		clock_t originalTicks;							/*Holds the original tick number*/
		clock_t ticks;									/*Holds temporary tick numbers for checking*/
		originalTicks = clock(); 						/*Gets original tick number*/
		ticks = clock();								/*Gets updatedtick number*/
		ticks = ticks - originalTicks;
		while(((float)ticks)/CLOCKS_PER_SEC < 15.0){	/*Sarts a clock based on ticks*/

			ticks = clock();
			ticks = ticks - originalTicks;

		}
		printf("Child is still alive.\n");
		
		
	}
	else{												/*Checkes if current process is a child*/
	
		printf("Parent is dying.\n");
	
	}

}