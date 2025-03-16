package com.tuf.day1.binary;

public class MissingNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method 

		int arr[] = {0,1,3};

		System.out.println("mssing: "+missing(arr));
	}

	public static int missing(int arr[])
	{
		int i;
		int ans=0;
		for(i=0;i<=arr.length;i++)
		{
			ans = ans ^ i;
		}
		
		for(i=0;i<arr.length;i++)
		{
			ans = ans ^ arr[i];
		}
		return ans;
	}
	
	public static int bitCount(int n)
    {
        int cnt=0;
        while(n!=0)
        {
            int set = n & 1;
            if(set==1)
                cnt++;
            n=n>>1;
        }
        return cnt;
    }
	
	 public int getSum(int a, int b) {
	        if (b==0)
	            return a;
	        
	        return getSum(a^b,(a&b)<<1);
	    }
}
