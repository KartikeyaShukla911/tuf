package com.tuf.arrays.misc2;

import java.util.HashMap;

public class LongestSubArrayWith0Sum {
	
	public static int longestSubArryay(int[] arr)
	{
		HashMap<Integer,Integer> hm = new HashMap();
		int i;
		int sum=0,ans=0;
		for(i=0;i<arr.length;i++)
		{
			sum+=arr[i];
			if(sum==0)
			{
				ans = i+1;
			}
			else
			{
				if(hm.containsKey(sum))
				{
					ans = Math.max(ans, i - hm.get(sum));
				}
				hm.put(sum, i);
			}
		}
		return ans;
	}
	/*
	 * ON, SN
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = {9, -3, 3, -1, 6, -5};
		System.out.println(longestSubArryay(a));
	}

}
