package com.tuf.arrays.misc;

import java.util.HashMap;

public class XorOfArray {
	
	public static int xorArray(int[] arr,int k)
	{
		int n = arr.length;
		int i;
		
		int xr = 0;
		int cnt=0;
		HashMap<Integer,Integer> hm = new HashMap();
		hm.put(xr, 1);
		for(i=0;i<n;i++)
		{
			xr = xr ^ arr[i];
			int x = xr ^ k;
			
			if(hm.containsKey(x))
			{
				cnt += hm.get(x);
			}
			
			if(hm.containsKey(xr)) {
				hm.put(xr, hm.get(xr)+1);
			}
			else
			{
				hm.put(xr, 1);
			}
		}
		return cnt;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
