// This multithreaded program estimates pi using
// the Monte Carlo randomized algorithm. Precision
// determined by user input.

#include <pthread.h>
#include <stdio.h>
#include <stdlib.h>
#include <time.h>

// Number of tests to perform
int precision;

// Total number of points within circle boundary 
int circlePoints;

void *monteCarlo()
{
  // Variables for random x, random y, distance from center
  double xCoord, yCoord, distance;
  
  // Number of loops is relative to size of square
  for (int i = 1; i <= precision; i++) { 

    // Generation of x and y corrdinates 
    xCoord = (double)(rand() % (precision + 1)) / precision; 
    yCoord = (double)(rand() % (precision + 1)) / precision;

    // Distance from center calculated 
    distance = xCoord * xCoord + yCoord * yCoord;

    // If distance <= 1, point is within circle 
    if (distance <= 1) 
      circlePoints++; 
  
    // Displays data for each randomized point
    printf("x:%lf y:%lf total:%d circle:%d\n", xCoord, yCoord, i, circlePoints);
  } 
}

int main(int argc, char *argv[]) 
{ 
  // Does not allow user to enter 0 arguments
  if(argc <= 1)
  {
    printf("No arguments");
    exit(1);
  }
  
  // Number of times to loop determined by user
  precision = atoi(argv[1]);

  // Random number generator initialization
  srand(time(NULL)); 

  // Creates a new process for monte carlo calculation
  pthread_t thread;
  pthread_create(&thread, NULL, (void *)monteCarlo, NULL);  

  // Waits for calculations to be complete before proceeding
  pthread_join(thread, NULL);

  // Calculates and prints pi estimate
  double pi = (double)4 * circlePoints / precision; 
  printf("pi: %lf\n", pi);
  
  return 0; 
} 