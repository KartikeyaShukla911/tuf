package com.tuf.arrays;

import java.util.ArrayList;
import java.util.List;

public class GeneratePascal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("nCr: "+ncr(5,3));
		System.out.println("Print nth row "+ncrRow(5));
	}
	
	public static long ncr(int n,int r)
	{
		int ans=1;
		
		for(int i =0;i<r;i++)
		{
			ans = ans * (n-i);
			ans = ans / (i+1);
		}
		return ans;
	}
	
	public static List<Long> ncrRow(int n)
	{
		List<Long> ans = new ArrayList();
		for(int i=0;i<n;i++)
		{
			ans.add(ncr(n+1,i+1));
		}
		return ans;
	}

}
