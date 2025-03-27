package com.tuf.String;

public class RabinKarp {
	
	/*
	 * Text pattern matching, given a pattern and a word
	 * Tc - Worse - O NM = where rollingHashCollison occurs
	 * S - O(1)
	 */
	public static void rabinKarp(String text,String pattern)
	{
		int q = 101; // to handle large hash value
		int d = 256; // possible characters
		
		int h = 1;
		int hashText = 0;
		int hashPattern = 0;
		int i;
		int n = text.length(),m=pattern.length();
		for(i=0;i<m-1;i++)
		{
			h = (h*d)%q; // unique hashValue
		}
		
		int match=0;
		for(i=0;i<n;i++)
		{
			hashText = (hashText*d + text.charAt(i))/q;
			hashPattern = (hashPattern*d + text.charAt(i))/q;
		}
		
		for(i=0;i<=n-m;i++)
		{
			if(hashPattern==hashText)
			{
				match=1;
				
				for(int j =0;j<m;j++)
				{
					if(text.charAt(j+i)!=pattern.charAt(j))
					{
						match=0;
						break;
					}
				}
				
				if(match==1)
					System.out.println("Pattern found at "+i);
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
