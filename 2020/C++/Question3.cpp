/* Casey Pollock
 * Assignment 1
 * CSCI 3000
 *
 * This method is used to produce a child that will reduce a given integer to 1.
 *
 */

#include <stdio.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/wait.h>

int main(){
	
	pid_t pid;										/*Stores the process id of the process*/
	int value;										/*Inital value to be reduced to 1*/
	printf("Please inset a positive value.\n");
	if(scanf("%d", &value) == 1){
		
		if(value > 0){
			
			pid = fork();							
	
			if (pid == 0) { 						/*Checkes if current process is a child*/
			
				printf("%d ", value);
				while(value != 1){
					
					if(value%2 == 0){				/*If value is even divide by 2*/
						
						value = value/2;
						
					}
					else{							/*Multiply value by 3 then subtract by 1*/
						
						value = (value * 3) + 1;
						
					}
					printf("%d ", value);
				
				}
				printf("\n");
				
			}
			else if (pid > 0) {						/*Checkes if current process is a parent*/
				wait(NULL);
				return 0;
			}

		}

	}
	
}