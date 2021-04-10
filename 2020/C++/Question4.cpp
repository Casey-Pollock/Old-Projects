/* Casey Pollock
 * Assignment 1
 * CSCI 3000
 *
 * This method will create a new thread that will generate an array of the 
 * Fibonacci Sequence up to an inputed number.  The array will then be printed 
 * to the screen starting with 0.
 *
 */

#include <pthread.h>
#include <stdio.h>
#include <stdlib.h>

int * array; /* this data is shared by the thread(s) */

void *Fib(void *param); /* the thread */

int main(int argc, char *argv[])
{
	pthread_t tid; /* the thread identifier */
	pthread_attr_t attr; /* set of attributes for the thread */

	if (argc != 2) {
		fprintf(stderr,"usage: a.out <integer value>\n");
		return -1;
	}

	if (atoi(argv[1]) < 0) {
		fprintf(stderr,"Argument %d must be non-negative\n",atoi(argv[1]));
		return -1;
	}

	int size = atoi(argv[1]), fib[size]; //The number of Fibonacci Numbers that will be put in the array.
	array = & fib[size];  //Creating a pointer to the array.
	
	/* get the default attributes */
	pthread_attr_init(&attr);
	
	if(size > 0){
		/* create the thread */
		pthread_create(&tid,&attr, Fib, (void *) argv[1]);

		/* now wait for the thread to exit */
		pthread_join(tid,NULL);
	}

	printf("Fibonacci sequence is\n0 ");
	for(int count = 0; count < size; count++){
		printf("%d ", array[count]);
	}
	printf("\n");
}

/**
 * The thread will begin control in this function
 */
void *Fib(void *param) 
{
	int count = 0, arraySize = atoi((char *) param);
	int fib0 = 0, fib1 = 1, fib2; //Initial Fibonacci Setup
	
	//For a Fibonacci Sequence of 1.
	if (arraySize == 1) { 
		array[count] = fib1; 
	}
	//For a Fibonacci Sequence greater than 1.
	if(arraySize > 1){
		array[count++] = fib1;
		for(count; count < arraySize; count++){
			fib2 = fib0 + fib1;						//Next number in the sequence.
			fib0 = fib1;
			fib1 = fib2;
			array[count] = fib2;					//Adds the next number to the array.
		}
	}

	pthread_exit(0);
}
