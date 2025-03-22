package com.tuf.linkedList;

import java.util.HashMap;

public class CountXorSubarray {
	
	public static int countXorArray(int arr[],int k)
	{
		int n = arr.length;
		int i,ans = 0;
		int cnt=0;
		HashMap<Integer,Integer> hm = new HashMap();
		
		for(i=0;i<n;i++)
		{
			ans = ans ^ arr[i];
			int x = ans ^ k;
			
			if(hm.containsKey(x))
			{
				cnt += hm.get(x);
			}
			
			if(hm.containsKey(ans))
			{
				hm.put(ans, hm.get(ans)+1);
			}
			else
				hm.put(ans, 1);
		}
		return cnt;
		
		//O-N 
		// S-N
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//
		int[] a = {4, 2, 2, 6, 4};
        int k = 6;
        int ans = countXorArray(a, k);
        System.out.println("The number of subarrays with XOR k is: " + ans);
	}

}
