package com.tuf.arrays.misc;

import java.util.HashMap;

public class LongestRepeatingChar {
	
	
	public static int longest(String s)
	{
		int n = s.length();
		int left=0,right=0,cnt=0;
		HashMap<Character,Integer> hm = new HashMap();
		while(right<n)
		{
			if(hm.containsKey(s.charAt(right)))
				left = Math.max(left, hm.get(s.charAt(i)+1));
			else
				hm.put(s.charAt(right), 1);
			
			cnt = Math.max(cnt, right-left+1);
		}
		return cnt;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
