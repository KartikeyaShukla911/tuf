package com.tuf.binarySearch;

public class findNthRoot {
	
	/*
	 * brute
	 * basicall, generate all N pow number and check if it's equal to the M
	 * if not or greater, return -1
	 * else return the answer
	 * 
	 * TC- O M = where M is the number
	 * S - 1,
	 */
	
	static int bruteFn(int n, int m)
	{
		// here n is the multiple like 3,4, m = 27
		int i,j;
		for(i=1;i<=m;i++)
		{
			int fact = fnPow(i,n);
			System.out.println("facct: "+fact);
			if(fact==m)
				return i;
			else if(fact>m)
				return -1;
		}
		return -1;
	}
	
	public static int fnPow(int x,int pow)
	{
		// use exponential power calculation
		// TC - log pow
		//  x = 2, pow = 3
		int num=1;
		while(pow!=0)
		{
			if(pow%2==1)
			{
				pow--;
				num *=x;
			}
			else
			{
				pow=pow/2;
				x=x*x;
			}
		}
		return num;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 3, m = 27;
        int ans = bruteFn(n, m);
        System.out.println("The answer is: " + ans);
        System.out.println("The answer is: " +binarySearchRoot(n, m));
	}
	
	public static int binarySearchRoot(int n,int m)
	{
		// n = 3, m = 27
		int low=1,mid,high=m;
		while(low<=high)
		{
			mid = (low+high)>>1;
			int fact = fnPow(mid,n);
			{
				if(fact==m)
					return mid;
				else if(fact>mid)
					high=mid-1;
				else
					low=mid+1;
			}
		}
		return -1;
	}

}
