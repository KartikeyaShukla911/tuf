package com.tuf.String;

import java.util.HashMap;
import java.util.Map;

public class RomanToIntViceVersa {
	
	public static int romanToInt(String s)
	{
		Map<Character,Integer> hm = new HashMap();
		hm.put('I', 1);
		hm.put('V', 5);
		hm.put('X', 10);
		hm.put('L', 50);
		hm.put('C', 100);
		hm.put('D', 500);
		hm.put('M', 1000);
		
		int ans=0;
		int prev=0;
		int i,n=s.length();
		for(i=n-1;i>=0;i--)
		{
			int curr = hm.get(s.charAt(i));
			if(curr<prev)
			{
				ans -=prev;
			}
			else
			{
				ans+=curr;
			}
			prev=curr;
		}
		return ans;
	}
	
	public static String intToRoman(int x)
	{
		String[] romanDigits = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
		int[] romanNumbers = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
		
		String ans="";
		int i=0;
		
		for(i=0;i<romanNumbers.length;i++)
		{
			while(romanNumbers[i]<=x)
			{
				x-=romanNumbers[i];
				ans+=romanDigits[i];
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
