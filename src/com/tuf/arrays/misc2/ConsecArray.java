package com.tuf.arrays.misc2;

import java.util.HashSet;
import java.util.Iterator;

public class ConsecArray {
	
	/*
	 * TC - On
	 * S - On
	 */
	
	public static int LongestConsecArr(int[] arr)
	{
		HashSet<Integer> hs = new HashSet();
		for(int it : arr)
		{
			hs.add(it);
		}
		
		int cnt=1;
		int ans=0;
		Iterator<Integer> itr = hs.iterator();
		while(itr.hasNext())
		{
			int x = itr.next();
			while(hs.contains(x-1))
			{
				cnt++;
				ans = Math.max(ans, cnt);
				x--;
			}
			cnt=1;
		}
		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {100, 200, 1, 3, 2, 4};
		System.out.println("consec "+LongestConsecArr(arr));
	}

}
