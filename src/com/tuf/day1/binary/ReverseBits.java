package com.tuf.day1.binary;

public class ReverseBits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int n = 501;
		
		System.out.println("Reverse bits "+reverseBit(n));
	}

	public static int reverseBit(int n)
	{
		int ans = 0;
		for(int i=0;i<32;i++)
		{
			int setUnset = n & 1;
			ans = (ans<<1) | setUnset;
			n = n>>>1;
		}
		return ans;
	}
}
