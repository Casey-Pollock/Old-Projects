// This multithreaded program prints all primes 
// equal to or less than a given integer.

#include <pthread.h>
#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

// Global integer variable
int numb;

// Determines whether a given number is prime
bool primeCheck(int maybePrime)
{
  for(int i = 2; i < maybePrime; i++)
  {
    if (maybePrime % i == 0)
      return false;
  }
  return true;
}

// Prints all primes less than or equal to a given int
void *printPrimes() 
{
  if(numb >= 2)
  { 
    if(primeCheck(numb))
      printf("%d", numb);
    numb -= 1;
    printPrimes();
  }
}

int main(int argc, char *argv[]) 
{
  // Does not allow one to enter 0 arguments
  if(argc <= 1)
  {
    printf("No arguments");
    exit(1);
  }

  // Copies user int into variable 
  numb = atoi(argv[1]);

  // Creates a new process for calculation
  pthread_t thread;
  pthread_create(&thread, NULL, (void *)printPrimes, NULL);
  
  // Waits for calculations to be complete before proceeding
  pthread_join(thread, NULL);

  return 0;
}