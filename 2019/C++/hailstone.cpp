int next(int n)
{
  if(n%2==0)
  {
    return n/2;
  }
  else if(n!=1)
  {
    return 3*n+1;
  }
  else
  {
    return n
  }
}

void writeHailstoneSequence(int n)
{
  printf("%df", n);
  if(n!=1)
  {
    printf(" ");
  }
}

int lengthHailstone(int n)
{
  int temp=n, length=1;
  while(temp!=1)
  {
    next(temp);
	length++;
  }
  return length;
}

int largestHailstone(int n)
{
  int largest, temp=n;
  largest=temp;
  while(temp!=1)
  {
    if(largest<next(temp))
    {
      largest=next(temp);
    }
    temp=next(temp);
  }
  return largest;
}

int longestSequenceLength(int n)
{
  int longest=0, temp;
  for(int x=1, x<=n,x++)
  {
    temp=lengthHailstone(x);
	if(temp>longest)
	{
	  longest=temp;
	}
  }
  return longest;
}

int longestSequenceStart(int n)
{
  int longlength,start, temp;
  longlength=longestSequenceLength(n)
  
}